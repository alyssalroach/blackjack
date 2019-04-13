import java.util.LinkedList;

public class BlackjackPlayer{
  private String m_playerName;
  private LinkedList<Card> m_hand;

  public BlackjackPlayer(){
    m_playerName = null;
    m_hand = new LinkedList<Card>();
  }

  public BlackjackPlayer(String playerName){
    m_playerName = playerName;
    m_hand = new LinkedList<Card>();
  }

  public void collect(Card card, int location){
    m_hand.add(location, card);
  }

  public Card getCard(int location){
    return m_hand.get(location);
  }

  public int getNumOfCards(){
    return m_hand.size();
  }

  public void clearDeck()
  {
    m_hand.clear();
  }

  public boolean checkNatural(){
    boolean natural = true;
    for (int i = 0; i < m_hand.size(); i++){
      if (m_hand.get(0).getFace().equals("Ace") && m_hand.get(1).getValue() == 10){
        natural = true;
      }
      else if (m_hand.get(0).getFace().equals("Ace") && m_hand.get(1).getValue() == 10){
        natural = true;
      }
      else{
        natural = false;
      }
    }
    return natural;
  }

  public Integer sumHand(){
    Integer sumOfHand = 0;
    int aceCount = 0;
    for (int i = 0; i < m_hand.size(); i++){
      if(!m_hand.get(i).getFace().equals("Ace")){
        sumOfHand += m_hand.get(i).getValue();
      }
      else{
        aceCount += 1;
      }
    }
    if(aceCount > 1){
      sumOfHand += aceCount;
    }
    else if(aceCount == 1){
      if(sumOfHand <= 10){
        sumOfHand += 11;
      }
      else{
        sumOfHand += 1;
      }
    }
    return sumOfHand;
  }
}
