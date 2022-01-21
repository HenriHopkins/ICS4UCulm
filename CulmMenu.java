
package culmmenu;

import java.io.*;
import java.util.StringTokenizer;
import java.util.Scanner;
public class CulmMenu {

   
    public static void main(String[] args) throws FileNotFoundException, IOException{
int selected =0;
        System.out.println("Menu: (Enter the number of the option you wish to select)");
System.out.println("1. Gamemodes");
System.out.println("2. Settings");
System.out.println("3. Start Game");
System.out.println("4. Display high scores");
System.out.println("5. Exit");
System.out.println("6. Info");
Scanner input = new Scanner(System.in);
//note to self: write thing to prevent invalid input
selected = input.nextInt();
if (selected==1) {gamemodes();}
if (selected==2) {selected();}
if (selected==3) {start();}
if (selected==4) {doHighScore();}
if (selected==5) {}
if (selected==6) {}

 }
    
    public static void gamemodes() {
        int pick,pick2,pick3 = 0;
        Scanner input = new Scanner(System.in);
        System.out.println("1. Adjust mix of questions about teams and/or players");
System.out.println("2. Adjust type of questions");
pick = input.nextInt();
if (pick==1){
System.out.println("1. Questions about players only");
System.out.println("2. Questions about teams only"); 
System.out.println("3. Randomized mix of both");
pick2=input.nextInt();
}
if (pick==2) {
System.out.println("1. Multiple choice questions only");
System.out.println("2. Direct answer questions only");
System.out.println("3. Randomized mix of both");
pick3=input.nextInt();
//obviously the gamemode variable from the reader will have to be integrated somehow
if(pick3==1) {gamemode=1; gamemode();}
if(pick3==2) {gamemode=2; gamemode();}
if(pick3==3) {gamemode=3; gamemode();}
}
    }
    
    
    public static void selected() {
System.out.println("1. Adjust time limit (or remove it)");
System.out.println("2. Adjust number of players");
}
    public static void start() {
      //somehow integrate reader into this and then do an action depending on the value of the gamemode or something
        culmReader();
       // if () {}
    }
    
    public static void doHighScore() throws FileNotFoundException, IOException {
        BufferedReader br= new BufferedReader(new FileReader("highscores.txt"));
 String Line;

 while((Line=br.readLine())!=null){
 System.out.println(Line);
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