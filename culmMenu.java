/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package culmtest;

/**
 *
 * @author hhopkins3105
 */
import java.io.*;
//import java.util.StringTokenizer;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Random;
public class culmMenu {

    public static void main(String[] args) throws FileNotFoundException, IOException {
        //set defaults here
        int gamemode1 = 0;
                ArrayList<Integer> playerScore = new ArrayList();
        menu(gamemode1,playerScore);
    }

    public static void menu(int gamemode1,ArrayList<Integer>playerScore) throws IOException {
        int selected = 0;
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
        if (selected != 6) {
            if (selected == 1) {
                gamemodes(gamemode1,playerScore);
            }
            if (selected == 2) {
                settings(playerScore,gamemode1);
            }
            if (selected == 3) {
                start(gamemode1);
            }
            if (selected == 4) {
                doHighScore();
            }
            if (selected == 5) {
                infoMenu(gamemode1,playerScore);
            }
            menu(gamemode1,playerScore);
        } if (selected==6) {
            System.out.println("Exited."); //exited doesnt work on the first try for some reason
        }
    }


    public static void gamemodes(int gamemode1, ArrayList<Integer> playerScore) throws IOException {
        int pick, pick2, pick3 = 0;
        int teamPlayers;
        
        Scanner input = new Scanner(System.in);
        System.out.println("1. Adjust mix of questions about teams and/or players");
        System.out.println("2. Adjust type of questions");
        System.out.println("3. Back to menu");
        pick = input.nextInt();
        if (pick == 1) {
            System.out.println("1. Questions about players only");
            System.out.println("2. Questions about teams only");
            System.out.println("3. Randomized mix of both");
            pick2 = input.nextInt();
            if (pick2 == 1) {
                teamPlayers = 0;
            }
            if (pick2 == 2) {
                teamPlayers = 1;
            }
            if (pick2 == 3) {
                teamPlayers = 2;
            }
            //note that teamPlayers should be imported
        }
        if (pick == 2) {
            System.out.println("1. Multiple choice questions only");
            System.out.println("2. Direct answer questions only");
            System.out.println("3. Randomized mix of both");
            pick3 = input.nextInt();
//obviously the gamemode variable from the reader will have to be integrated somehow
            //  import culmmenu.CulmReader;
            // CulmReader cr = new CulmReader();
            //cr.wordOnly();
            if (pick3 == 1) {
                gamemode1 = 1;
            }
            if (pick3 == 2) {
                gamemode1 = 2;
            }
            if (pick3 == 3) {
                gamemode1 = 3;
            }
        }
        
        if (pick==3) {menu(gamemode1,playerScore);}
    }



    public static void settings(ArrayList<Integer> playerScore, int gamemode1) throws IOException {
        int selected = 0;
        Scanner input = new Scanner(System.in);
        System.out.println("1. Adjust time limit (or remove it)");
        System.out.println("2. Adjust number of players");
                System.out.println("3. Back to menu");

        selected = input.nextInt();
        if (selected==1) {}//code here to adjust timer somehow
        if (selected==2) {System.out.println("Current number of players is: "+playerScore.size());
int selected1=0;
        System.out.println("1. Remove players");
System.out.println("2. Add players");
selected1=input.nextInt();
if (selected1==1) {
    System.out.println("Enter the players you wish to remove (enter d to stop removing players)");
    boolean done = false;
    while (!done) {int i; String temp=input.next(); if (temp.equals("done")){done=true; break;} else{
       i=Integer.parseInt(temp); playerScore.remove(i+1);
    }}
}
if (selected1==2) {System.out.println("Enter how many players you wish to add"); //check if the math checks out here
int size = playerScore.size();
int i = 0;
i = input.nextInt();
for (int c=size; c<size+i; c++) {
    playerScore.set(size+c,0);}
}
        
        }
                if (selected==3) {menu(gamemode1,playerScore);}

    }
    

    public static void start(int gamemode1) throws IOException {
        //somehow integrate reader into this and then do an action depending on the value of the gamemode or something
        culmReader(gamemode1);
        // if () {}
    }//if this works, you could make it shorter as you could just call culmReader() in the main menu

    public static void doHighScore() throws FileNotFoundException, IOException {
        BufferedReader br = new BufferedReader(new FileReader("highscores.txt"));
        String Line;

        while ((Line = br.readLine()) != null) {
            System.out.println(Line);
        }
        br.close();
    }

    public static void infoMenu(int gamemode1, ArrayList<Integer> playerScore) throws IOException {
        int select;
        Scanner input = new Scanner(System.in);
        System.out.println("Welcome to the Info Menu");
        System.out.println("1. How to start.");
        System.out.println("2. How to change settings.");
        System.out.println("3. How to play.");
        System.out.println("4. Highscores.");
        System.out.println("5. Exiting the game.");
                System.out.println("6. Exit Info Menu.");

        select = input.nextInt();
        if (select == 1) {
            System.out.println("How to start:");
            System.out.println("- First, select the gamemode you wish to play in the \"Gamemodes\" tab. 1 player or 2 players. ");
            System.out.println("- Then, to start the game select the \"Start Game\" tab.  ");
        }
        if (select == 2) {
            System.out.println("How to change settings:");
            System.out.println("- You can adjust your prefered options the in the \"Settings\" tab. Here you can change your player initals, the timer, highscores, and bonus point options.");
        }
        if (select == 3) {
            System.out.println("How to play:");
            System.out.println("-Depending on the amount of players you will take turns answering trivia questions once they appear on the screen.");
            System.out.println("-Either type the short answer, or insert a letter for the multiple choice questions. But be carful before the time runs out!");
            System.out.println("-Points will be rewarded for correct answers, and how quickly you can answer.");
            System.out.println("-The player with the most points at the end of the game wins!");
        }
        if (select == 4) {
            System.out.println("Highscores:");
            System.out.println("-After each game highscores will be recorded in the \"Highscores\" tab.");
            System.out.println("-You can delete records in the \"Settings\" tab.");
        }
        if (select == 5) {
            System.out.println("Exiting the game:");
            System.out.println("-To exit the game select the \"Exit\" tab.");
        }
        if (select != 6) {
            infoMenu(gamemode1,playerScore);
          //  select = 0; //can delete this i think
        } else{menu(gamemode1,playerScore);}
    }

    public static void culmReader(int gamemode1) throws FileNotFoundException, IOException {
        // import culmmenu.Culmmenu;
       // Culmmenu cr = new Culmmenu();
        //cr.gamemodes();

 int c =0;

        //questions, options, and answers stored in array lists
        ArrayList<String> q = new ArrayList();
        ArrayList<String> op = new ArrayList();
        ArrayList<String> ans = new ArrayList();

//gamemode 0 is word answering only, this would not be an integer in final edition
//gamemode 1 is options only
//gamemode 2 is both
        //  int gamemode = cr.gamemodes().gamemode1;
        int gamemode = gamemode1;
        if (gamemode==0) {wordOnly(q,op,ans);}
        if (gamemode==1) {optionOnly(q,op,ans);}
        if (gamemode==2) {both(q,op,ans);}
playGame(c);
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
    
    
    public static void playGame(int c,ArrayList<String> q,ArrayList<String> op,ArrayList<String> ans, ArrayList<Integer> playerScore){
	//this one is a definite WIP
        
        int players = 1; //obviously integrate diff variable, players is placeholder
	    Scanner input = new Scanner(System.in);
	  //  int co = 0; //may use this for recursion but not sure yet
	    if (players ==1) {
	        String answer = "";
	       	Random r = new Random();
		int num =r.nextInt(q.size())+1; //may have to adjust random based on looping
System.out.println(q.get(num));
System.out.println(op.get(num));
//timer.start();
answer  = input.nextLine();
//if timer>time limit decided by court,points = 10-counter, timer.cancel(); timer.purge(); do recursion
//maybe implement while loop with c condition to prevent infinite loop and whatnot
if (answer.equls(ans.get(num))) {System.out.println("correct!"); playerScore.get(0)+=points;};
    else {System.out.println("Incorrect!"); } if (scoreArr.get(0)<50) {playGame(c);}
}
 
if (players>1) { //couldnt this just be an else lol
 int player;
 if (c=0) {player=c;}
 else if (c<scoreArr.size() {c++;player=c;}
 else if (c==scoreArr.size() {c=0; player=c;}
	    Scanner input = new Scanner(System.in);
	  //  int co = 0; //may use this for recursion but not sure yet
	    if (players ==1) {
	        String ans = "";
	       	Random r = new Random();
		int num =r.nextInt(q.size())+1; //may have to adjust random based on looping
System.out.println(q.get(num));
System.out.println(op.get(num));
//timer.start();
ans  = input.nextLine();
//if timer>time limit decided by court, points = 10-counter, timer.cancel(); timer.purge(); do recursion
//maybe implement while loop with c condition to prevent infinite loop and whatnot
if (ans==answers.get(num)) {System.out.println("correct!") scoreArr.get(c)+=points;};
    else {System.out.println("Incorrect!"); } 
		    int hi = 0;
		    for (int i = scoreArr) {if (scoreArr.get(i)>scoreArr.get(hi)) {hi=i;}}
		    if (scoreArr.get(hi)<50) {playGame(c);}
		    else {System.out.println("Player "+hi+1+" wins!");}
	    }
	 // checkHighScore();
	}
    }
	  //public static void checkHighScore();
    
}
