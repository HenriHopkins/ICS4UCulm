package culmtest;

import java.io.*;
//import java.util.StringTokenizer;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;
import java.util.Collections;


public class culmMenu {
    int sP=0;
    public String tem = "";
    public static int n;
    public static ArrayList<String> q = new ArrayList();
    public static ArrayList<String> op = new ArrayList();
    public static ArrayList<String> ans = new ArrayList();
    private  ArrayList<Integer> playerScore = new ArrayList();
    public static int gamemode1;
    public static int teamPlayer;
   // public static int co=0;
  //  public static int runs=0;
    public static int timeLimit;
    Timer timer = new Timer();
    TimerTask task = new TimerTask() {
        public void run() {
            sP++;
           System.out.println("timeLimit is"+timeLimit);
         //   System.out.println("sP is: "+sP);
                    if (sP>=timeLimit) {System.out.println("TIMES UP"); System.out.println("Press enter to return to menu"); //Scanner may = new Scanner(System.in); for (int c=0; c<1; c++) {may.close();}//timer.cancel(); timer.purge();
                        try {
                            menu(playerScore, q,  op,  ans,  n,timeLimit);
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
        } //if all else fails just write press enter before putting in input lmao
    };
    /* TimerTask task = new TimerTask()
     {
         public void run()
         {
             if( tem.equals("") )
             {                 System.out.println("0size is: "+playerScore.size());
                 if (playerScore.size()==0) {playerScore.add(0);}
                 System.out.println("TIME IS UP");
                 System.out.println("1size is: "+playerScore.size());
                     runs++;
                     System.out.println("accessing run");
                 try {
                     playGame(n,q,op,ans,playerScore,co);
                 } catch (IOException e) {
                     e.printStackTrace();
                 }
                 System.out.println("accessing run2");
                     System.out.println("2size is: "+playerScore.size());
                     //      System.exit( 0 );
             }
             //   if(tem.equals("ENDGAME")) {exitGame();}
         }
     }; */
    public void startTimer() {
        timer.scheduleAtFixedRate(task, 1000, 1000);
    }

    public static void main(String[] args) throws FileNotFoundException, IOException {
       defaults();
    }
public static void defaults() throws IOException {
     //set defaults here
timeLimit=10;
         gamemode1 = 2;
      // int timeLimit=120;
        int teamPlayer=2;
        n=0;
        ArrayList<Integer> playerScore = new ArrayList();
        playerScore.add(0);
menu(playerScore,q,op,ans,n,timeLimit);       // menu(gamemode1,playerScore,teamPlayer,q,op,ans,n,timeLimit);
}
    public static void menu(ArrayList<Integer>playerScore, ArrayList<String> q, ArrayList<String> op, ArrayList<String> ans, int n, int timeLimit) throws IOException {
        int selected = 0;
        System.out.println("Menu: (Enter the number of the option you wish to select)");
        System.out.println("1. Gamemodes");
        System.out.println("2. Settings");
        System.out.println("3. Reset gamemodes and settings to default");
        System.out.println("4. Start Game");
        System.out.println("5. Display high scores");
        System.out.println("6. Info (recommended for new players)");
        System.out.println("7. Exit");
        Scanner s = new Scanner(System.in);
//note to henri: write thing to prevent invalid input

       // System.out.println("Picking menu");
        String i = s.nextLine();
       // System.out.println("PickED menu");
        selected = Integer.parseInt(i);
        if (selected != 6) {
            if (selected == 1) {
                gamemodes(playerScore,q,op,ans,n,timeLimit);
            }
            if (selected == 2) {
                settings(playerScore,q,op,ans,n,timeLimit);
            }
            if (selected == 3) {
               defaults();
            }
            if (selected == 4) {
                start(playerScore,q,op,ans,n);
            }
            if (selected == 5) {
                doHighScore(playerScore,timeLimit);
            }
            if (selected == 6) {
                infoMenu(playerScore,q,op,ans,timeLimit);
            }
            // menu(gamemode1,playerScore);
        } if (selected==7) {
            exitGame();//exited doesnt work on the first try for some reason
        }
    }

    public static void exitGame () {
        System.out.println("Exited"); System.exit(0);
    } //figure this out because its making u do an exit for  each back button, causing the back buttons to be a bit defunct

    public static void gamemodes(ArrayList<Integer> playerScore, ArrayList<String> q, ArrayList<String> op, ArrayList<String> ans, int n, int timeLimit) throws IOException {
        int pick=0;
        //rn this is a defunct variable but if we decide to implement the team/player feature we'll use it
//note that if we were to use it i'd to have to set it as a default like I did with gamemode1
        Scanner input = new Scanner(System.in);
        System.out.println("1. Adjust mix of questions about teams and/or players");
        System.out.println("2. Adjust type of questions");
        System.out.println("3. Back to menu");
        pick = input.nextInt();
        if (pick == 1) {teamsOrPlayers(playerScore,q,op,ans,n,timeLimit);}


        if (pick == 2) {questionType(playerScore,q,op,ans,n,timeLimit);}



        if (pick==3) {menu(playerScore,q,op,ans,n,timeLimit);}
    }

    public static void teamsOrPlayers(ArrayList<Integer> playerScore, ArrayList<String> q, ArrayList<String> op, ArrayList<String> ans, int n, int timeLimit) throws IOException {
      int pick2=0;
        Scanner input = new Scanner(System.in);
        System.out.println("1. Questions about players only");
        System.out.println("2. Questions about teams only");
        System.out.println("3. Randomized mix of both");
        System.out.println("4. Back to gamemodes menu");
        System.out.println("5. Back to main menu");
        pick2 = input.nextInt();
        if (pick2 == 1) {
            teamPlayer = 0;
            menu(playerScore, q, op, ans, n,timeLimit);
        }
        if (pick2 == 2) {
            teamPlayer = 1;
            menu(playerScore, q, op, ans, n,timeLimit);
        }
        if (pick2 == 3) {
            teamPlayer = 2;
            menu(playerScore, q, op, ans, n,timeLimit);
        }
        if (pick2 == 4) {
            gamemodes(playerScore, q, op, ans, n,timeLimit);
        }
        if (pick2==5) {menu(playerScore,q,op,ans,n,timeLimit);}

    }
    public static void questionType(ArrayList<Integer> playerScore, ArrayList<String> q, ArrayList<String> op, ArrayList<String> ans, int n,int timeLimit) throws IOException {
        int pick3=0;
        Scanner input = new Scanner(System.in);
        System.out.println("1. Multiple choice questions only");
        System.out.println("2. Direct answer questions only");
        System.out.println("3. Randomized mix of both");
        System.out.println("4. Back to gamemodes menu");
        System.out.println("5. Back to main menu");
        pick3 = input.nextInt();
//ignore these comments, they're for if we need to import a class
        //  import culmmenu.CulmReader;
        // CulmReader cr = new CulmReader();
        //cr.wordOnly();
        if (pick3 == 1) {
            gamemode1 = 1;
            menu(playerScore, q, op, ans, n,timeLimit);

        }
        if (pick3 == 2) {
            gamemode1 = 0;
            menu(playerScore, q, op, ans, n,timeLimit);
        }
        if (pick3 == 3) {
            gamemode1 = 2;
            menu(playerScore, q, op, ans, n,timeLimit);
        }
        if (pick3 == 4) {
            gamemodes(playerScore, q, op, ans, n,timeLimit);
        }
        if (pick3==5) {menu(playerScore,q,op,ans,n,timeLimit);}


    }
    public static void settings(ArrayList<Integer> playerScore, ArrayList<String> q, ArrayList<String> op, ArrayList<String> ans, int n, int timeLimit) throws IOException {
        int selected = 0;
        Scanner input = new Scanner(System.in);
        System.out.println("1. Adjust time limit (or remove it)");
        System.out.println("2. Adjust number of players");
        System.out.println("3. Back to main menu");

        selected = input.nextInt();
        if (selected==1) {timerSettings(playerScore,q,op,ans,n);}



        //code here to adjust timer somehow
        if (selected==2) {playerNumbers(playerScore,q,op,ans,n,timeLimit);
        }
        if (selected==3) {menu(playerScore,q,op,ans,n,timeLimit);}

    }
    public static void timerSettings(ArrayList<Integer> playerScore, ArrayList<String> q, ArrayList<String> op, ArrayList<String> ans, int n) throws IOException {int selected1=0;
        Scanner input = new Scanner(System.in);
        System.out.println("The current time limit is: ");
        System.out.println("1. Change the Time Limit (or remove it)");
        System.out.println("2. Back to settings menu");
        System.out.println("3. Back to main menu");
        selected1=input.nextInt();
        if(selected1==1){System.out.println("enter the new timeLimit (enter 0 to remove it?"); timeLimit=input.nextInt(); menu(playerScore,q,op,ans,n,timeLimit);}
        if (selected1==2) {settings(playerScore,q,op,ans,n,timeLimit);}
        if (selected1==3) {menu(playerScore,q,op,ans,n,timeLimit);}
    }

    public static void playerNumbers(ArrayList<Integer> playerScore, ArrayList<String> q, ArrayList<String> op, ArrayList<String> ans, int n, int timeLimit) throws IOException {System.out.println("Current number of players is: "+playerScore.size());
      Scanner input = new Scanner(System.in);
        int selected1=0;
        System.out.println("1. Remove players");
        System.out.println("2. Add players");
        System.out.println("3. Back to settings menu");
        System.out.println("4. Back to main menu");

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
                playerScore.add(0); menu(playerScore,q,op,ans,n,timeLimit);}
        }
        if (selected1==3) {settings(playerScore,q,op,ans,n,timeLimit);}
        if (selected1==4) {menu(playerScore,q,op,ans,n,timeLimit);}
    }

    public static void start( ArrayList<Integer> playerScore,ArrayList<String> q,ArrayList<String> op,ArrayList<String> ans, int n) throws IOException {

        culmReader(playerScore,q,op,ans,n);

    }//if this works (which it does atm), we probs could make it shorter as you could just call culmReader() in the main menu

    public static void doHighScore(ArrayList<Integer> playerScore,int timeLimit) throws FileNotFoundException, IOException {
        //code that displays highscores, we still need one that records it either in a connected method to playGame, or playGame itself
    ArrayList<Integer> numbers = new ArrayList();
        ArrayList<String> names = new ArrayList();
        BufferedReader d = new BufferedReader(new FileReader("highscores.txt"));
        String dLine;
        while ((dLine = d.readLine()) != null) {
numbers.add(Integer.parseInt(dLine.substring(dLine.indexOf(" ")+1)));
names.add(dLine.substring(0,dLine.indexOf(":")));
        }
        d.close();



insertionSort(numbers,names);

        BufferedReader br = new BufferedReader(new FileReader("highscores.txt"));
        String Line;
        while ((Line = br.readLine()) != null) {
            System.out.println(Line);
        }
        br.close();
        menu(playerScore,q,op,ans,n,timeLimit);
    }

    public static void infoMenu(ArrayList<Integer> playerScore, ArrayList<String> q, ArrayList<String> op, ArrayList<String> ans, int timeLimit) throws IOException {
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
            infoMenu(playerScore,q,op,ans,n);
            //  select = 0; //can delete this i think
        } else{menu(playerScore,q,op,ans,n,timeLimit);}
    }

    public static void insertionSort(ArrayList<Integer> numbers,ArrayList<String> names) throws IOException {
        int j;
        for(int i=1; i<numbers.size();i++){
            j=i;
            while(j>0 && numbers.get(j).compareTo(numbers.get(j-1))<0){
                Collections.swap(numbers, j, j-1);
                Collections.swap(names, j, j-1);
                j--;
            }
        }


        BufferedWriter WriteFile = new BufferedWriter(new FileWriter("highscores.txt"));
        for(int intC=0;intC<numbers.size();intC++){
            WriteFile.write(names.get(intC)+": "+numbers.get(intC));
            WriteFile.newLine();
        }
        WriteFile.close();

    }
    public static void culmReader(ArrayList<Integer> playerScore, ArrayList<String> q,ArrayList<String> op,ArrayList<String> ans, int n) throws FileNotFoundException, IOException {
        // import culmmenu.Culmmenu;
        // Culmmenu cr = new Culmmenu();
        //cr.gamemodes();
        //ignore^
        int co=0;
        //questions, options, and answers stored in array lists
        //  ArrayList<String> q = new ArrayList();
        //   ArrayList<String> op = new ArrayList();
        //   ArrayList<String> ans = new ArrayList();


        //  ignore: int gamemode = cr.gamemodes().gamemode1;
        int gamemode = gamemode1;
        if (gamemode==0) { wordOnly(q,op,ans);}
        if (gamemode==1) {optionOnly(q,op,ans);}
        if (gamemode==2) {both(q,op,ans);}
        culmMenu timerTest = new culmMenu();
        timerTest.startTimer();
        playGame(n,q,op,ans,playerScore,co);
    }

    public static void wordOnly(ArrayList<String> q, ArrayList<String> op, ArrayList<String> ans) throws FileNotFoundException, IOException {
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

    public static void optionOnly(ArrayList<String> q, ArrayList<String> op, ArrayList<String> ans) throws FileNotFoundException, IOException {
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


    public static void both(ArrayList<String> q, ArrayList<String> op, ArrayList<String> ans) throws FileNotFoundException, IOException {
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


    public static void playGame(int n,ArrayList<String> q,ArrayList<String> op,ArrayList<String> ans, ArrayList<Integer> playerScore,int co) throws IOException {
        //this one is still a bit of a WIP, especially with the highScore and timer, plus multiplayer has not been tested as of yet
//for (String a : op) {
        //System.out.println(a);
//}
      /*  Timer time = new Timer();
        TimerTask task = new TimerTask() {
            int ct=10;
            public void run(){
                if (ct>0) {
                    ct--;
                } else if (ct>=0){System.out.println("TIMES UP"); time.cancel(); time.purge();}
            }
        };
        if (t>0) {time.cancel(); time.purge(); t=0; playGame(c,q,op,ans,playerScore,co,t);}
*/




        System.out.println("size is: "+playerScore.size());

//int d==;
//int timer =1; //note delete this later, once timer is implemented
        int   points =1;
        int players = playerScore.size();
        String tem = "";
      /* boolean safe = false;
        while (!safe) {
        if (runs>0) {Scanner input = new Scanner(System.in); input.close();}
        else {Scanner input = new Scanner(System.in); runs=0; safe=true; break;}
        }
        */
        System.out.println("players equals: "+players);
        if (players ==1) {
            // String answer = "";
            //  System.out.println("accessing if players==1");
            Random r = new Random();
            int num =r.nextInt(q.size()-1)+1; //may have to adjust random based on looping, so far so good, although it does repeat some things so I could change it if we need
            // System.out.println(q.get(num));
            //     System.out.println("accessing getInput");

            System.out.println(q.get(num));
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

            System.out.println("tem1 is: "+tem);
Scanner may = new Scanner(System.in);
tem = may.nextLine();
          //  input.reset();
            //  BufferedReader in = new BufferedReader(
                 //   new InputStreamReader( System.in ) );
         //   tem = in.readLine();
            System.out.println("tem2 is: "+tem);
            //timer.cancel();
            if (tem.equalsIgnoreCase(ans.get(num))) {System.out.println("correct!");

                playerScore.set(0,points+playerScore.get(0));
            }
            else if(tem.equals("ENDGAME")) {exitGame();}
            else {System.out.println("Incorrect!"); System.out.println("The answer was: "+ans.get(num));}
            if (points==1) {playGame(n,q,op,ans,playerScore,co);}
          
        }



        if (players>1) {
            int player;
            if (co==0) {player=n;co++;}
            else if (n<playerScore.size()) {n++;player=n;}
            if (n==playerScore.size()) {n=0; player=n;} //fix this
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
            System.out.format("Player "+(n+1)+"'s answer: ");
            Scanner input = new Scanner(System.in);
            answer  = input.nextLine();
            input.close();

            if (answer.equalsIgnoreCase(ans.get(num))) {System.out.println("correct!");
                playerScore.set(n,points+playerScore.get(n));
            }
            else {System.out.println("Incorrect!"); System.out.println("The answer was: "+ans.get(num));} // System.out.println("Player "+(c+1)+" 's score is: "+playerScore.get(c)); if (timer<2) {playGame(c,q,op,ans,playerScore,co,t);}
//else {System.out.println("TIMES UP");} //must integrate timer yktv
            int hi = 0;
            for (int i = 0; i<playerScore.size(); i++) {if (playerScore.get(i)>playerScore.get(hi)) {hi=i;}}
            System.out.println("Player "+hi+1+" wins with a final score of "+playerScore.get(hi)+"!");
        }
//checkHighScore(playerScore);
    }
    //once the game is stopped, call highScore method? checkHighScore();
    public static void checkHighScore(ArrayList<Integer> playerScore) throws IOException {
        ArrayList<Integer> numbers = new ArrayList();
        ArrayList<String> names = new ArrayList();

        BufferedReader br= new BufferedReader(new FileReader("highscores.txt"));
        String Line;

        while((Line=br.readLine())!=null){
            numbers.add(Integer.parseInt(Line.substring(Line.indexOf(" ")+1)));
            names.add(Line.substring(0,Line.indexOf(":")));
        }
        br.close();


        Scanner input = new Scanner(System.in);
        int winner = 0;
int low=0;


//alt timer to close input
//.remove player score in loop for high scores

        //search for winner (highest score)
        int hi=playerScore.get(0);
        for(int intC=1; intC<playerScore.size();intC++) {
            if (playerScore.get(intC) > hi) {
                hi = playerScore.get(intC); winner=intC;
            }
        }

        if (names.size()==5) { int max=numbers.get(0);
            int min=numbers.get(0);
            for(int intC=1; intC<numbers.size();intC++){
                if(numbers.get(intC)>max){max=numbers.get(intC);}
                if(numbers.get(intC)<min){min=numbers.get(intC);}
            low=intC;}
            if(hi>low){names.remove(low); numbers.remove(low);
                System.out.println("NEW HIGH SCORE!");
                System.out.println("Enter your initials (first and last name only):");
            String temp = input.nextLine();
            //write thing here to prevent it from being more than two lines yk
names.add(temp); numbers.add(playerScore.get(winner));
            }}
        else{  System.out.println("NEW HIGH SCORE!");
            System.out.println("Enter your initials (first and last name only):");
            String temp = input.nextLine();
            //write thing here to prevent it from being more than two lines yk
            names.add(temp); numbers.add(playerScore.get(winner));}
        insertionSort(numbers,names);
playerScore.remove(winner);
if(playerScore.size()>1) {checkHighScore(playerScore);}
    

    }

  

}
