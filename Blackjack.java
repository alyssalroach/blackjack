import java.util.Scanner;

public class Blackjack{
  private BlackjackPlayer m_player;
  private BlackjackPlayer m_dealer;
  private Deck m_deck;
  private Scanner m_kb;
  private int m_ties;
  private int m_houseWins;
  private int m_playerWins;

  public Blackjack(){
    m_deck = new Deck();
    m_player = new BlackjackPlayer("User");
    m_dealer = new BlackjackPlayer("Computer");
    m_kb = new Scanner(System.in);
    m_ties = 0;
    m_houseWins = 0;
    m_playerWins = 0;
  }

  public void blackjackGame(){
    m_deck.shuffle();
    m_player.collect(m_deck.dealFromTop(), 0);
    m_player.collect(m_deck.dealFromTop(), 1);
    m_dealer.collect(m_deck.dealFromTop(), 0);
    m_dealer.collect(m_deck.dealFromTop(), 1);
    boolean dealContinue = true;
    if (m_player.checkNatural() && m_dealer.checkNatural()){
      System.out.println("Both you and the dealer have natural blackjacks! This round is a tie!");
      m_ties += 1;
      dealContinue = false;
    }
    while(dealContinue){
      System.out.println("\nThe cards in your hand are:");
      for (int i = 0; i < m_player.getNumOfCards(); i++){
        System.out.println(m_player.getCard(i).toString());
      }
      System.out.println("The sum of your hand is: " + (m_player.sumHand()).toString() + "\nThe dealer has a " + m_dealer.getCard(0).toString() + " and a hidden card.\n");
      System.out.println("Would you like to HIT or STAND?");
      String answer = m_kb.nextLine();
      if (answer.equalsIgnoreCase("hit")){
        m_player.collect(m_deck.dealFromTop(), m_player.getNumOfCards());
        if (m_player.sumHand() > 21){
          System.out.println("\nYou busted! The house wins!\n");
          m_houseWins += 1;
          dealContinue = false;
        }
        else{
          dealContinue = true;
        }
      }
      else if(answer.equalsIgnoreCase("stand")){
        dealContinue = false;
      }
      else{
        System.out.println("\nSorry I don't understand. Please try again.");
      }
    }
    if(m_player.sumHand() <= 21){
      while(m_dealer.sumHand() < 17){
        m_dealer.collect(m_deck.dealFromTop(), m_dealer.getNumOfCards());
      }
      if(m_dealer.sumHand() > 21){
        System.out.println("The dealer busted, you have won.");
        m_playerWins += 1;
      }
    }
    System.out.println("\nYou have " + m_player.sumHand() + " and the dealer has " + m_dealer.sumHand());
    if(m_player.sumHand() > m_dealer.sumHand()){
      System.out.println("You have won this round\n");
      m_playerWins += 1;
    }
    else if(m_player.sumHand() < m_dealer.sumHand()){
      System.out.println("The dealer won this round\n");
      m_houseWins += 1;
    }
    else{
      System.out.println("This round is a tie\n");
      m_ties += 1;
    }
    m_player.clearDeck();
    m_dealer.clearDeck();
  }

  public int getTies(){
    return m_ties;
  }

  public int getPlayerWins(){
    return m_playerWins;
  }

  public int getHouseWins(){
    return m_houseWins;
  }
}
