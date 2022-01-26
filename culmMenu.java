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
public static int gamemode2;
    public static void main(String[] args) throws FileNotFoundException, IOException {
        //set defaults here
        int gamemode1 = 2;
        int teamPlayer=2;
        ArrayList<Integer> playerScore = new ArrayList();
        playerScore.add(0);
        menu(gamemode1,playerScore,teamPlayer);
    }

    public static void menu(int gamemode1,ArrayList<Integer>playerScore, int teamPlayer) throws IOException {
        int selected = 0;
        System.out.println("Menu: (Enter the number of the option you wish to select)");
        System.out.println("1. Gamemodes");
        System.out.println("2. Settings");
        System.out.println("3. Start Game");
        System.out.println("4. Display high scores");
        System.out.println("5. Info");
        System.out.println("6. Exit");
        Scanner input = new Scanner(System.in);
//note to henri: write thing to prevent invalid input
        selected = input.nextInt();
        if (selected != 6) {
            if (selected == 1) {
                gamemodes(gamemode1,playerScore,teamPlayer);
            }
            if (selected == 2) {
                settings(playerScore,gamemode1,teamPlayer);
            }
            if (selected == 3) {
               start(gamemode1,playerScore,teamPlayer);
            }
            if (selected == 4) {
                doHighScore();
            }
            if (selected == 5) {
                infoMenu(gamemode1,playerScore,teamPlayer);
            }
           // menu(gamemode1,playerScore,teamPlayer);
        } if (selected==6) {
             exitGame();//exited doesnt work on the first try for some reason
        }
    }

public static void exitGame () {
        System.out.println("Exited");
} //figure this out because its making u do an exit for  each back button, causing the back buttons to be a bit defunct

    public static void gamemodes(int gamemode1, ArrayList<Integer> playerScore, int teamPlayer) throws IOException {
        int pick, pick2, pick3 = 0;
      //rn this is a defunct variable but if we decide to implement the team/player feature we'll use it
//note that if we were to use it i'd to have to set it as a default like I did with gamemode1
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
                teamPlayer = 0;  menu(gamemode1,playerScore, teamPlayer);
            }
            if (pick2 == 2) {
                teamPlayer = 1; menu(gamemode1,playerScore, teamPlayer);
            }
            if (pick2 == 3) {
                teamPlayer = 2; menu(gamemode1,playerScore, teamPlayer);
            }
        }
        if (pick == 2) {
            System.out.println("1. Multiple choice questions only");
            System.out.println("2. Direct answer questions only");
            System.out.println("3. Randomized mix of both");
            pick3 = input.nextInt();
//ignore these comments, they're for if we need to import a class
            //  import culmmenu.CulmReader;
            // CulmReader cr = new CulmReader();
            //cr.wordOnly();
            if (pick3 == 1) {
       gamemode1 = 1; menu(gamemode1,playerScore, teamPlayer);

            }
            if (pick3 == 2) {
                gamemode1 = 0; menu(gamemode1,playerScore, teamPlayer);
            }
            if (pick3 == 3) {
                gamemode1 = 2; menu(gamemode1,playerScore, teamPlayer);
            }
        }

        if (pick==3) {menu(gamemode1,playerScore, teamPlayer);}
    }



    public static void settings(ArrayList<Integer> playerScore, int gamemode1,int teamPlayer) throws IOException {
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
                for (int c=0; c<i; c++) {
                 playerScore.add(0);}
            }


        }
        if (selected==3) {menu(gamemode1,playerScore, teamPlayer);}

    }


    public static void start(int gamemode1, ArrayList<Integer> playerScore, int teamPlayer) throws IOException {

 culmReader(gamemode1,playerScore, teamPlayer);

    }//if this works (which it does atm), we probs could make it shorter as you could just call culmReader() in the main menu

    public static void doHighScore() throws FileNotFoundException, IOException {
        //code that displays highscores, we still need one that records it either in a connected method to playGame, or playGame itself
        BufferedReader br = new BufferedReader(new FileReader("highscores.txt"));
        String Line;

        while ((Line = br.readLine()) != null) {
            System.out.println(Line);
        }
        br.close();
    }

    public static void infoMenu(int gamemode1, ArrayList<Integer> playerScore, int teamPlayer) throws IOException {
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
            infoMenu(gamemode1,playerScore, teamPlayer);
            //  select = 0; //can delete this i think
        } else{menu(gamemode1,playerScore, teamPlayer);}
    }

    public static void culmReader(int gamemode1,ArrayList<Integer> playerScore, int teamPlayer) throws FileNotFoundException, IOException {
        // import culmmenu.Culmmenu;
        // Culmmenu cr = new Culmmenu();
        //cr.gamemodes();
        //ignore^
        int c =0;
int co=0;

        //questions, options, and answers stored in array lists
        ArrayList<String> q = new ArrayList();
        ArrayList<String> op = new ArrayList();
        ArrayList<String> ans = new ArrayList();


        //  ignore: int gamemode = cr.gamemodes().gamemode1;
        int gamemode = gamemode1;
        if (gamemode==0) { wordOnly(q,op,ans,teamPlayer);}
        if (gamemode==1) {optionOnly(q,op,ans,teamPlayer);}
        if (gamemode==2) {both(q,op,ans,teamPlayer);}
        playGame(c,q,op,ans,playerScore,co);
    }

    public static void wordOnly(ArrayList<String> q, ArrayList<String> op, ArrayList<String> ans,int teamPlayer) throws FileNotFoundException, IOException {
        //this version adds blank thing to option arraylist to keep acessing in order
        int temp = 0,valid=0;
        BufferedReader br= new BufferedReader(new FileReader("qs.txt"));
        String Line;
//i changed the questions file so that the word questions and multi-choice questions are seperated by "WORDONLY" to make this easier
        while((Line=br.readLine())!=null){
            if (teamPlayer==0) {if(Line.contains("PLAYERWORD")){valid=1;} if(Line.contains("WORDONLY")) {valid=0;temp=1;} }
            if (teamPlayer==1) {if (Line.contains("PLAYERWORD")) {valid=0;} if (Line.contains("WORDONLY")){valid=1;} }
            if (teamPlayer==2) {if(!(Line.contains("PLAYERWORD"))) {valid=1;} else{valid=0;}}

            if (valid!=0&&!(Line.contains("PLAYERMC")||Line.contains("PLAYERWORD"))) {
if (Line.contains("WORDONLY")) {temp = 1; }
else if (temp==1) {
if(Line.contains("answer")) {ans.add(Line.substring(Line.indexOf("answer")+7));op.add("");}
//change this if questions are longer than a line
            else{q.add(Line);} }}}
        br.close();
    }

    public static void optionOnly(ArrayList<String> q, ArrayList<String> op, ArrayList<String> ans, int teamPlayer) throws FileNotFoundException, IOException {
       //
        int c=0,valid=0,temp=0;
        String o="";
        BufferedReader br= new BufferedReader(new FileReader("qs.txt"));
        String Line;

        while((Line=br.readLine())!=null){
            if (teamPlayer==0) {if(Line.contains("PLAYERMC")){valid=1;}}
            if (teamPlayer==1) {if (Line.contains("PLAYERMC")) {valid=0; temp++;} else if (temp==0){valid=1;}}
            if (teamPlayer==2) {if(!(Line.contains("PLAYERMC"))) {valid=1;} else{valid=0;}}

            if (valid!=0&&!(Line.contains("PLAYERMC")||Line.contains("PLAYERWORD"))) {
            if (!Line.contains("WORDONLY")) {
            c++;
            if (c==1) {q.add(Line);}
            else if (c==2){o+=Line;}
            else if (c==3){o+=Line;}
            else if (c==4){o+=Line;}
            else if (c==5){o+=Line;op.add(o);o="";}
            else if (c==6/*may not be needed:*/&&Line.contains("answer")) {ans.add(Line.substring(Line.indexOf("answer")+7));c=0;} }
           else{break;}
//change this if questions are longer than a line (no questions are longer than a line rn so we good)
        }}
        br.close();
    }


    public static void both(ArrayList<String> q, ArrayList<String> op, ArrayList<String> ans, int teamPlayer) throws FileNotFoundException, IOException {
        //this version adds blank thing to option arraylist to keep accessing in order
//does combination of both readers, this works bc of WORLDONLY separation
        int c=0,temp=0,valid=0,valid1=1;
        String o="";
        BufferedReader br= new BufferedReader(new FileReader("qs.txt"));
        String Line;

        while((Line=br.readLine())!=null){
            if (teamPlayer==0) {if(Line.contains("PLAYERMC")||Line.contains("PLAYERWORD")){valid=1;} if(Line.contains("WORDONLY")) {valid=0;temp=1;} }
            if (teamPlayer==1) {if(valid1==1||Line.contains("WORDONLY")){ valid=1;} if (Line.contains("PLAYERMC")||Line.contains("PLAYERWORD")) {valid=0; valid1=0;}  }
            if (teamPlayer==2) {if(!(Line.contains("PLAYERMC")||Line.contains("PLAYERWORD"))) {valid=1;} else{valid=0;}} //isnt this line gonna be defunct lol
            //siemthing that prevents it from gettings the words? lol^


            if (valid!=0&&!(Line.contains("PLAYERMC")||Line.contains("PLAYERWORD"))) {
               // bothCheck(Line,q,op,ans,temp,c,o);

                if (!Line.contains("WORDONLY")&&temp!=1) {
                    c++;
                    if (c==1) {q.add(Line);}
                    else if (c==2){o+=Line;}
                    else if (c==3){o+=Line;}
                    else if (c==4){o+=Line;}
                    else if (c==5){o+=Line;op.add(o);o="";}
                    else if (c==6/*may not be needed:*/&&Line.contains("answer")) {ans.add(Line.substring(Line.indexOf("answer")+7));c=0;} }
                else if (Line.contains("WORDONLY")){temp=1; System.out.println("accessed1");} else if (temp==1) {if(Line.contains("answer")) {ans.add(Line.substring(Line.indexOf("answer")+7));op.add("");}
                else{q.add(Line);}}

            }
//change this if questions are longer than a line
        }
        br.close();
    }

//    public static void bothCheck (String Line, ArrayList<String> q, ArrayList<String> op, ArrayList<String> ans, int temp, int c, String o) {





   // }


    public static void playGame(int c,ArrayList<String> q,ArrayList<String> op,ArrayList<String> ans, ArrayList<Integer> playerScore,int co) throws IOException {
        //this one is still a bit of a WIP, especially with the highScore and timer, plus multiplayer has not been tested as of yet
        int points = 1;
//for (String a : op) {
    //System.out.println(a);
//}
int timer =1; //note delete this later, once timer is implemented
        int players = playerScore.size();
        Scanner input = new Scanner(System.in);
        if (players ==1) {
            String answer = "";
            Random r = new Random();
            int num =r.nextInt(q.size()-1)+1; //may have to adjust random based on looping, so far so good, although it does repeat some things so I could change it if we need
            System.out.println(q.get(num));
           // System.out.println("op.get is: "+op.get(num));
            if (!(op.get(num).isBlank())) {
               // System.out.println(op.get((num)));
             //   System.out.println("accessing");
                String str = op.get(num);
                String A = str.substring(0,str.indexOf("B."));
                String B = str.substring(str.indexOf("B."),str.indexOf("C."));
                String C = str.substring(str.indexOf("C."),str.indexOf("D."));
                String D = str.substring(str.indexOf("D."));
                System.out.println(A);
                System.out.println(B);
                System.out.println(C);
                System.out.println(D);

                   }
//ignore the following comments, its just me thinking outloud timer.start();
            answer  = input.nextLine();
//if timer>time limit decided by court,points = 10-counter, timer.cancel(); timer.purge(); do recursion
//maybe implement while loop with c condition to prevent infinite loop and whatnot
            if (answer.equalsIgnoreCase(ans.get(num))) {System.out.println("correct!");

                playerScore.set(0,points+playerScore.get(0));
            } //due to a lack of timer, points are set to increase by 1 for each question you get right
    else {System.out.println("Incorrect!"); System.out.println("The answer was: "+ans.get(num));}  if (timer<2) {System.out.println("Your score is: "+playerScore.get(0)); playGame(c,q,op,ans,playerScore,co);}
    else {System.out.println("TIMES UP"); }
        }



        if (players>1) {
            int player;
            if (co==0) {player=c;co++;}
            else if (c<playerScore.size()) {c++;player=c;}
  if (c==playerScore.size()) {c=0; player=c;} //fix this
                String answer = "";
                Random r = new Random();
                int num =r.nextInt(q.size()-1)+1;               //does it have to be -1?
            System.out.println(q.get(num));
            if (!op.get(num).isBlank()) {
                System.out.println(op.get(num));
                String str = op.get(num);
                String A = str.substring(0,str.indexOf("B."));
                String B = str.substring(str.indexOf("B."),str.indexOf("C."));
                String C = str.substring(str.indexOf("C."),str.indexOf("D."));
                String D = str.substring(str.indexOf("D."));
                System.out.println(A);
                System.out.println(B);
                System.out.println(C);
                System.out.println(D);
            }
            System.out.format("Player "+(c+1)+"'s answer: ");
                answer  = input.nextLine();
                if (answer.equalsIgnoreCase(ans.get(num))) {System.out.println("correct!");
                    playerScore.set(c,points+playerScore.get(c));
                }
    else {System.out.println("Incorrect!"); System.out.println("The answer was: "+ans.get(num));}  System.out.println("Player "+(c+1)+" 's score is: "+playerScore.get(c)); if (timer<2) {playGame(c,q,op,ans,playerScore,co);}
else {System.out.println("TIMES UP");} //must integrate timer yktv
            int hi = 0;
            for (int i = 0; i<playerScore.size(); i++) {if (playerScore.get(i)>playerScore.get(hi)) {hi=i;}}
            System.out.println("Player "+hi+1+" wins with a final score of "+playerScore.get(hi)+"!");
            }
checkHighScore(playerScore);
        }
    //once the game is stopped, call highScore method? checkHighScore();
    public static void checkHighScore(ArrayList<Integer> playerScore) throws IOException {
        ArrayList<Integer> highScores = new ArrayList();
        ArrayList<String> data = new ArrayList();

        BufferedReader br= new BufferedReader(new FileReader("data.txt"));
        String Line;

        while((Line=br.readLine())!=null){
           data.add(Line);
highScores.add(Integer.parseInt(Line.substring(0,Line.indexOf(" "))));
        }
        br.close();


Scanner input = new Scanner(System.in);
        int hi = 0;
        if (highScores.isEmpty()) {highScores.add(0);}
        for (int i = 0; i<playerScore.size(); i++) {if (playerScore.get(i)>playerScore.get(hi)) {hi=i;
            String initials = "";
            System.out.println("NEW HIGH SCORE!!");
            System.out.println("Player "+hi+" enter your initials");
            initials = input.next(); //add thing ensuring they can only be 2 characters long
            data.add(playerScore.get(hi).toString()+" "+initials);

        }}
     //   else {System.out.println("Player "+hi+1+" wins!");}
//sort data ?
        BufferedWriter WriteFile = new BufferedWriter(new FileWriter("highScore.txt.true"));
        for(int intC=0;intC<data.size();intC++){
            WriteFile.write(data.get(intC));
            WriteFile.newLine();
        }
        WriteFile.close();
    }

}
//quicksort?

/*
      int hi = 0;
                for (int i : playerScore) {if (playerScore.get(i)>playerScore.get(hi)) {hi=i;}}
                if (playerScore.get(hi)<50) {playGame(c);}
                else {System.out.println("Player "+hi+1+" wins!");}
 */
/*
max=numbers.get(0);
        min=numbers.get(0);
        for(int intC=1; intC<numbers.size();intC++){
        if(numbers.get(intC)>max){max=numbers.get(intC);}
        if(numbers.get(intC)<min){min=numbers.get(intC);} */
        //delete last one if high score array list > 10