import java.util.Scanner;

public class BlackjackDriver{
  public static void main(String[] args){
    Scanner kb = new Scanner(System.in);
    Blackjack b = new Blackjack();
    System.out.println("Welcome to blackjack! This is a simplified version of the game and does not include betting. \nThe goal of each round is to get as close to 21 without going over as possible. \nYou will get a point if you have a greater card sum than the dealer at the end of the round.\nType 'PLAY' when you are ready to get started!");
    if(kb.nextLine().equalsIgnoreCase("play")){
      Boolean playContinue = true;
      while(playContinue){
        b.blackjackGame();
        System.out.println("The score is:\nYour Wins: " + b.getPlayerWins() + "\nComputer Wins: " + b.getHouseWins() + "\nTies: " + b.getTies());
        System.out.println("\nWould you like to 'PLAY' another round or 'Exit'?");
        String answer = kb.nextLine();
        if(answer.equalsIgnoreCase("play")){
          playContinue = true;
        }
        else if(answer.equalsIgnoreCase("exit")){
          playContinue = false;
        }
        else{
          System.out.println("I am sorry I dont understand. You have been exited from the game.");
        }
      }
      System.out.println("The final score is:\nYour Wins: " + b.getPlayerWins() + "\nComputer Wins: " + b.getHouseWins() + "\nTies: " + b.getTies());
      if(b.getPlayerWins() > b.getHouseWins()){
        System.out.println("CONGRADULATIONS! YOU HAVE WON.");
      }
      else{
        System.out.println("Better luck next time.");
      }
    }
  }
}
