
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
        int gamemode = 0;
        if (gamemode==0) {wordOnly(q,op,ans);}
           if (gamemode==1) {optionOnly(q,op,ans);}
     
    }
    
    public static void wordOnly(ArrayList<String> q, ArrayList<String> op, ArrayList<String> ans) throws FileNotFoundException, IOException {
           //int co=0;
	//this version adds blank thing to option arraylist to keep acessing in order, may be changed

 BufferedReader br= new BufferedReader(new FileReader("qs.txt"));
 String Line;

 while((Line=br.readLine())!=null){
     
if(Line.contains("Answer")) {ans.add(Line.substring(Line.indexOf("Answer")+1));op.add("");}
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
else if (c==5){o+=Line;op.add(o+"S");}
else if (c==6/*may not be needed:*/&&Line.contains("Answer")) {ans.add(Line.substring(Line.indexOf("Answer")+1));c=0;}
//change this if questions are longer than a line
 }
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