import java.util.Random;
import java.util.Scanner;
public class Main //"main" will be changed upon integration
{
	public static void main(String[] args) {
	int c = 0;

	playGame(c);
	}
	
	public static void playGame(c){
	    int players = 1; //obviously integrate diff variable, players is placeholder
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
//if timer>time limit decided by court,points = 10-counter, timer.cancel(); timer.purge(); do recursion
//maybe implement while loop with c condition to prevent infinite loop and whatnot
if (ans==answers.get(num)) {System.out.println("correct!") scoreArr.get(0)+=points;};
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
	  checkHighScore();
	}
	  public static void checkHighScore();
	  //do buffered reader to load top (?, ask court) high scores
	  //sort array list and see if it is bigger than last one, if it is check again and again until yk, then write it there?
	  //else nothing happens
}
//obviously endCondition is defunct atm
