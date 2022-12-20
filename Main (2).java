import java.util.Random;
import java.util.Scanner;
import java.util.*;
import java.text.*;
import java.lang.*;
import java.util.Arrays;

class Main {
  static int userScore = 0;
  static int computerScore = 0;

  public static void main(String[] args) {
    welcome();
    int computerScore;
    
  }

  //Welcome
  public static void welcome(){
    System.out.println ("Hello, welcome to Fifty the Game");
    System.out.println("\nWould you like to read the instructions? (y/n)");
    Scanner myScan=new Scanner (System.in);
    String instructions = myScan.nextLine();
    if (instructions.equals("y")){
      System.out.println("\nYou will roll two dice trying to get a double. If you get double ones, double twos, double fours and double fives you gain 5 points and roll again.");
      System.out.println("\nIf you roll double sixes, you gain 25 points but do not roll again.");
      System.out.println("\nIf you roll double threes then you lose all your points and do not get to roll again.");
      System.out.println("\nIf you roll no double you lose your turn.");
      doesUserRoll();
    }
    else if (instructions.equals("n")){
      System.out.println("\nOkay, you are set to play the game. Goodluck!");
      doesUserRoll();
    }
    
  }

  //User Roll
  public static void doesUserRoll(){
    Scanner myScan=new Scanner (System.in);
    System.out.println("\nPlease enter (roll) to roll both of the dice. Press any other key to quit");
    boolean roll1 = false;
    String roll_ = myScan.nextLine();
    while (roll1 == false){
      if (roll_.equals("roll")){
        roll1 = true;
        userRoll();
      }
      else{
        System.out.println ("\nComputer had a score of " + computerScore);
        System.out.println("You had a score of " + userScore);
        System.out.println ("Sad to see you go");
        System.exit(0);
      }
    }
  }

  //User Roll Dice Array
  public static int [] userRoll(){
    int[] diceRolled= new int [2];
    for (int i = 0; i < 2; i++){
      int userDiceRolled = (int) (Math.random()*6+1);
      diceRolled[i] = userDiceRolled;
    }  
    System.out.println ("\nYou rolled " + Arrays.toString(diceRolled));
    updateUserScore(diceRolled);
    return diceRolled; 
  }

  //User Score Update
  public static int updateUserScore(int [] diceRolled ){
    Scanner myScan=new Scanner (System.in);
    while (userScore<50 && computerScore<50){

      //Double 1,2,4,5
      if(diceRolled[0]==diceRolled[1] && diceRolled[0]!=6 && diceRolled[0]!=3){
        System.out.println("5 points");
        userScore = (userScore+5);
        System.out.println("You have a score of " + userScore);
        System.out.println("Would you like to roll again? (y/n)");
        String rollAgain = myScan.nextLine();
        if (rollAgain.equals("y")){
          doesUserRoll();
        }
        if (rollAgain.equals("n")){
          System.out.println ("Computer had a score of " + computerScore);
          System.out.println("You had a score of " + userScore);
          System.out.println ("Sad to see you go");
        }
      }

      //No Doubles
      if (diceRolled[0]!=diceRolled[1]){
        System.out.println("0 Points");
        System.out.println("Computers Turn");
        System.out.println("You have a score of " + userScore);
        computerDiceRoll();
      }

      //Double Threes
      if (diceRolled[0]==3 && diceRolled[1]==3){
        System.out.println("Lose all points");
        System.out.println("Computers Turn");
        userScore = 0;
        System.out.println("You have a score of " + userScore);
        computerDiceRoll();
      }

      // Double Sixes
      if (diceRolled[0]==6 && diceRolled[1]==6){
        System.out.println("25 Points");
        System.out.println("Computers Turn");
        userScore = userScore+25;
        System.out.println("You have a score of " + userScore);
        computerDiceRoll();
      }
    }
    if (userScore>=50){
      System.out.println("You win!");
    }
    return userScore;
  }



  //Computer Roll
  public static int [] computerDiceRoll(){
    int[] diceRolled= new int [2];
    for (int i = 0; i < 2; i++){
      int userDiceRolled = (int) (Math.random()*6+1);
      diceRolled[i] = userDiceRolled;
    }  
    System.out.println ("\nComputer rolled " + Arrays.toString(diceRolled));
    updateComputerScore(diceRolled);
    return diceRolled; 
  }

  //Computer Score Update
  public static int updateComputerScore(int [] diceRolled ){
    //int computerScore=0;
    Scanner myScan=new Scanner (System.in);
    while (computerScore<50 && userScore<50){
      
      //Double 1,2,4,5
      if(diceRolled[0]==diceRolled[1] && diceRolled[0]!=6 && diceRolled[0]!=3){
        System.out.println("5 points");
        computerScore = (computerScore+5);
        System.out.println("Computer has a score of " + computerScore);
        computerDiceRoll();
      }

      //No Doubles
      if (diceRolled[0]!=diceRolled[1]){
        System.out.println("0 Points");
        System.out.println("Users Turn");
        System.out.println("Computer has a score of " + computerScore);
        doesUserRoll();
      }

      //Double Threes
      if (diceRolled[0]==3 && diceRolled[1]==3){
        System.out.println("Lose all points");
        System.out.println("Users Turn");
        computerScore = 0;
        System.out.println("Computer has a score of " + computerScore);
        doesUserRoll();
      }

      // Double Sixes
      if (diceRolled[0]==6 && diceRolled[1]==6){
        System.out.println("25 Points");
        System.out.println("Users Turn");
        computerScore = computerScore+25;
        System.out.println("Computer has a score of " + computerScore);
        doesUserRoll();
      }
    }
    if (computerScore>=50){
      System.out.println("Computer wins!");
    }
      return computerScore;
  }
}
