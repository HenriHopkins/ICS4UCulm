
package culmmenu;


import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;
public class CulmMenu {

   
    public static void main(String[] args) throws FileNotFoundException, IOException{
//questions, options, and answers stored in array lists
        ArrayList<String> q = new ArrayList();
                ArrayList<String> op = new ArrayList();	
 ArrayList<String> ans = new ArrayList();
        
//gamemode 0 is word answering only, this would not be an integer in final edition
//gamemode 1 is options only
//gamemode 2 is both
        int gamemode = 0;
        if (gamemode==0) {wordOnly(q,op,ans);}
           if (gamemode==1) {optionOnly(q,op,ans);}
        if (gamemode==2) {both(q,op,ans);}
     
    }
    
    public static void wordOnly(ArrayList<String> q, ArrayList<String> op, ArrayList<String> ans) throws FileNotFoundException, IOException {
           //int co=0;
	//this version adds blank thing to option arraylist to keep acessing in order, may be changed

 BufferedReader br= new BufferedReader(new FileReader("qs.txt"));
 String Line;

 while((Line=br.readLine())!=null){
     
if(Line.contains("answer")) {ans.add(Line.substring(Line.indexOf("answer")+1));op.add("");}
//change this if questions are longer than a line
else{q.add(Line);} }
 br.close();
 }
    
     public static void optionOnly(ArrayList<String> q, ArrayList<String> op, ArrayList<String> ans) throws FileNotFoundException, IOException {
    int c=0;
    String o="";
         BufferedReader br= new BufferedReader(new FileReader("qs.txt"));
 String Line;

 while((Line=br.readLine())!=null){
//with OP i mark S as this is where I would split the options when displaying them later on, as this is better than integrating 4 options
c++;
if (c==1) {q.add(Line);}   
else if (c==2){o+=Line;}
else if (c==3){o+=Line;}
else if (c==4){o+=Line;}
else if (c==5){o+=Line;op.add(o+"S");o="";}
else if (c==6/*may not be needed:*/&&Line.contains("answer")) {ans.add(Line.substring(Line.indexOf("answer")+1));c=0;}
//change this if questions are longer than a line
//may have to change c based on how reader reads empty spaces
 }
 br.close();
}
     
     
      public static void both(ArrayList<String> q, ArrayList<String> op, ArrayList<String> ans) throws FileNotFoundException, IOException {
	//this version adds blank thing to option arraylist to keep acessing in order, may be changed

 BufferedReader br= new BufferedReader(new FileReader("qs.txt"));
 String Line;
int c=0;
String o="";
 while((Line=br.readLine())!=null){
     c++;
     
     if (c==1) {q.add(Line);}
     else if (c==2) {if(Line.contains("answer")) {ans.add(Line.substring(Line.indexOf("answer")+1));op.add("");c=0;}
     else{o+=Line;}
     } else if (c==3){o+=Line;}
else if (c==4){o+=Line;}
else if (c==5){o+=Line;op.add(o+"S");o="";}
else if (c==6/*may not be needed:*/&&Line.contains("answer")) {ans.add(Line.substring(Line.indexOf("answer")+1));c=0;}
//change this if questions are longer than a line
else{q.add(Line);} }
 br.close();
 }
     
}
/*Question
Letter option
Letter option
Letter option
Letter option
Answer ans

Questions
Answer ans*/