/** Deck.java
  *
  @author Alyssa Roach
  @author 2313952
  @author aroach@chapman.edu
  *CPSC-231-01
  *Assignment 8
*/

/** Simple program that stores playing cards in a LinkedList
*/
import java.util.LinkedList;
import java.util.Random;

/** The Deck class allows the user to create a standard deck of playing cards using
  * the card class and defines accessor methods and a method to deal cards from the
  * deck.
*/
public class Deck
{
  // Stores a collection of cards representing a standard deck
  private LinkedList<Card> m_deck;

  /** The default constructor creates a standard deck of
    * 52 cards using the card constructor
    * @param none
  */
  public Deck()
  {
    m_deck = new LinkedList<Card>();
    for (int i = 1; i <= 13; i++)
    {
      if(i==1){
        Card cSpades = new Card("Ace", "Spades");
        m_deck.add(cSpades);
        Card cDiamonds= new Card("Ace", "Diamonds");
        m_deck.add(cDiamonds);
        Card cHearts = new Card("Ace", "Hearts");
        m_deck.add(cHearts);
        Card cClubs = new Card("Ace", "Clubs");
        m_deck.add(cClubs);
      }
      else if (i==11){
        Card cSpades = new Card("Jack", "Spades");
        m_deck.add(cSpades);
        Card cDiamonds= new Card("Jack", "Diamonds");
        m_deck.add(cDiamonds);
        Card cHearts = new Card("Jack", "Hearts");
        m_deck.add(cHearts);
        Card cClubs = new Card("Jack", "Clubs");
        m_deck.add(cClubs);
      }
      else if (i==12){
        Card cSpades = new Card("Queen", "Spades");
        m_deck.add(cSpades);
        Card cDiamonds= new Card("Queen", "Diamonds");
        m_deck.add(cDiamonds);
        Card cHearts = new Card("Queen", "Hearts");
        m_deck.add(cHearts);
        Card cClubs = new Card("Queen", "Clubs");
        m_deck.add(cClubs);
      }
      else if (i==13){
        Card cSpades = new Card("King", "Spades");
        m_deck.add(cSpades);
        Card cDiamonds= new Card("King", "Diamonds");
        m_deck.add(cDiamonds);
        Card cHearts = new Card("King", "Hearts");
        m_deck.add(cHearts);
        Card cClubs = new Card("King", "Clubs");
        m_deck.add(cClubs);
      }
      else{
        Card cSpades = new Card(i, "Spades");
        m_deck.add(cSpades);
        Card cDiamonds = new Card(i, "Diamonds");
        m_deck.add(cDiamonds);
        Card cHearts = new Card(i, "Hearts");
        m_deck.add(cHearts);
        Card cClubs = new Card(i, "Clubs");
        m_deck.add(cClubs);
      }
    }
  }

  /** Returns the cards in the deck
    * @param none
    * @return A LinkedList containing all the cards currently in the deck
  */
  public LinkedList getDeck(){
    return m_deck;
  }

  /** Returns a random card from the deck
    * @param none
    * @return a random card from the deck
  */
  public Card deal()
  {
    Random randNum = new Random();
    int location = randNum.nextInt(m_deck.size());
    Card card = m_deck.get(location);
    m_deck.remove(location);
    return card;
  }

  public void shuffle()
  {
    LinkedList<Card> shuffledDeck = new LinkedList<Card>();
    Random randNum = new Random();
    for(int i = 0; i < m_deck.size(); i++)
    {
      int randomNum = randNum.nextInt(m_deck.size());
      shuffledDeck.add(m_deck.get(randomNum));
    }
    m_deck.clear();
    m_deck.addAll(shuffledDeck);
  }

  public Card dealFromTop()
  {
    Card c = m_deck.get(0);
    m_deck.remove(c);
    return c;
  }

  public void printDeck(){
    for(int i = 0; i < m_deck.size(); i++){
      System.out.println(m_deck.get(i).toString());
    }
  }
}
