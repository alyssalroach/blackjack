/** Card.java
  *
  @author Alyssa Roach
  @author 2313952
  @author aroach@chapman.edu
  *CPSC-231-01
  *Assignment 8
*/

/** Simple program that creates a playing card with a face, suit, and value
*/

/** The Card class allows the user to create a playing card with a face, suit,
  * and value and defines accessor and mutator methods that return the card's
  * attributes
*/
public class Card
{
  //The value the card takes from 2 - 13 with A being a 13
  private Integer m_value;
  //The face value of the card (J, K, Q, A) if applicable
  private String m_face;
  //The suit of the card (Hearts (H), Diamonds (D), Spaces (S), Clubs (C))
  private String m_suit;

  /** The defualt constuctor creates a Card of
    * the Ace of Spades
    * @param none
  */
  public Card()
  {
    m_value = 13;
    m_face = "Ace";
    m_suit = "Spades";
  }

  /** Creates a Card of a given value and suit. The face will be assigned using
    * the value.
    * @param value A integer representing the value of the card (2-13)
    * @param suit A charecter representing the suit of the card
  */
  public Card(Integer value, String suit)
  {
    m_value = value;
    m_suit = suit;
    if (value > 1 && value <= 10)
    {
      m_face = "n/a";
    }
  }

  public Card(String face, String suit)
  {
    m_face = face;
    m_suit = suit;
    if (face.equals("Ace"))
    {
      m_value = 11;
    }
    else if (face.equals("Jack") || face.equals("Queen") || face.equals("King")){
      m_value = 10;
    }
  }

  /** Returns the numerical value of the card
    * @param none
    * @return An integer representing the value of the card
  */
  public Integer getValue()
  {
    return m_value;
  }

  /** Sets the numerical value of the card.
    * @param value An integer representing the value of the card (2-13).
    * @return none
  */
  public void setValue(int value)
  {
    m_value = value;
  }

  /** Returns the face value of the card (if applicable)
    * @param none
    * @return A charecter representing the face of the card
  */
  public String getFace()
  {
    return m_face;
  }

  /** Sets the face value of the card.
    * @param face A charecter representing the face of the card (J, Q, K, A).
    * @return none
  */
  public void setFace(String face)
  {
    m_face = face;
  }

  /** Returns the suit of the card
    * @param none
    * @return A charecter representing the suit of the card
  */
  public String getSuit()
  {
    return m_suit;
  }

  /** Sets the suit of the card.
    * @param suit A charecter representing the suit of the card (D, H, S, C).
    * @return none
  */
  public void setSuit(String suit)
  {
    m_suit = suit;
  }

  public String toString(){
    if (m_face.equals("n/a")){
      return(m_value.toString() + " of " + m_suit);
    }
    else{
      return(m_face + " of " + m_suit);

    }
  }
}
