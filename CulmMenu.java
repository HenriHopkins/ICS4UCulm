package culmmenu;
import java.io.*;
import java.util.StringTokenizer;
import java.util.Scanner;
public class Culmmenu {

    public static void main(String[] args)throws FileNotFoundException, IOException {
     menu(); 
    }
    
    public static void menu() {
    int selected =0;
        System.out.println("Menu: (Enter the number of the option you wish to select)");
System.out.println("1. Gamemodes");
System.out.println("2. Settings");
System.out.println("3. Start Game");
System.out.println("4. Display high scores");
System.out.println("5. Info");
System.out.println("6. Exit");
Scanner input = new Scanner(System.in);
//note to self: write thing to prevent invalid input
selected = input.nextInt();
if (selected!=6) {
if (selected==1) {gamemodes();}
if (selected==2) {selected();}
if (selected==3) {start();}
if (selected==4) {doHighScore();}
if (selected==5) {infoMenu();}
    menu();
}
else {System.out.println("Exited.");}
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
    public static void infoMenu() {
        int select;
        Scanner input = new Scanner(System.in);
        System.out.println("Welcome to the Info Menu (enter 6 to exit)");
        System.out.println("1. How to start.");
        System.out.println("2. How to change settings.");
        System.out.println("3. How to play.");
        System.out.println("4. Highscores.");
        System.out.println("5. Exiting the game.");
        select = input.nextInt();
if (select==1) {
                System.out.println("How to start:");
                System.out.println("- First, select the gamemode you wish to play in the \"Gamemodes\" tab. 1 player or 2 players. ");
                System.out.println("- Then, to start the game select the \"Start Game\" tab.  ");}
if (select==2) {
                System.out.println("How to change settings:");
                System.out.println("- You can adjust your prefered options the in the \"Settings\" tab. Here you can change your player initals, the timer, highscores, and bonus point options.");}
if (select==3) {
                System.out.println("How to play:");
                System.out.println("-Depending on the amount of players you will take turns answering trivia questions once they appear on the screen.");
                System.out.println("-Either type the short answer, or insert a letter for the multiple choice questions. But be carful before the time runs out!");
                System.out.println("-Points will be rewarded for correct answers, and how quickly you can answer.");
                System.out.println("-The player with the most points at the end of the game wins!");}
if (select==4) {
                System.out.println("Highscores:");
                System.out.println("-After each game highscores will be recorded in the \"Highscores\" tab.");
                System.out.println("-You can delete records in the \"Settings\" tab.");}
if (select==5) {
                System.out.println("Exiting the game:");
                System.out.println("-To exit the game select the \"Exit\" tab.");}
        if (select!=6) {infoMenu(); select=0;}
}
    
/*Question
Letter option
Letter option
Letter option
Letter option
Answer ans
Questions
Answer ans*/
    }
