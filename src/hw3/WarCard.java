/**
 * @file WarCard.java
 * @author Matthew chan
 * @date 01/20/2016
 * @brief This class models a traditional playing card with 4 suits (spades,
 * hearts, diamonds, clubs) and 13 different ranks (2, 3, 4, ... , KING, ACE)
 */
package hw3;

// WarCard class models a traditional playing card with a rank and suit
public class WarCard {

    private int suit;
    private int rank;

    /**
     * Constructor
     *
     * @param rank is the rank of the card
     * @param suit is the suit assigned to the card
     */
    WarCard(int rank, int suit) {
        this.rank = rank;
        this.suit = suit;
    }

    /**
     * Returns the rank of the card
     */
    public String getRank() {
        switch (rank) {
            case 0:
                return "TWO";
            case 1:
                return "THREE";
            case 2:
                return "FOUR";
            case 3:
                return "FIVE";
            case 4:
                return "SIX";
            case 5:
                return "SEVEN";
            case 6:
                return "EIGHT";
            case 7:
                return "NINE";
            case 8:
                return "TEN";
            case 9:
                return "JACK";
            case 10:
                return "QUEEN";
            case 11:
                return "KING";
            case 12:
                return "ACE";
            default:
                System.out.println("Error -- Incorrect rank");
                return "ERROR";
        }
    }

    /**
     * Returns the suit of the card
     */
    public String getSuit() {
        switch (suit) {
            case 0:
                return "SPADES";
            case 1:
                return "CLUBS";
            case 2:
                return "DIAMONDS";
            case 3:
                return "HEARTS";
            default:
                System.out.println("Error -- Incorrect suit");
                return "ERROR";
        }
    }

    /**
     * Comparison method
     *
     * @param other is a playing card to compare the current card to
     * @brief This method returns true if the rank of this card is larger than
     * the other card
     *
     * @code
     *      WarCard a = new WarCard(5,2); // Seven of Diamonds
     *      WarCard b = new WarCard(2,1); // Four of Clubs
     *      a.compareTo(b); // returns true
     *  @endcode
     */
    public boolean compareTo(WarCard other) {
        return rank > other.rank;
    }

    /**
     * Print method
     */
    public void print() {
        System.out.println(getRank() + " OF " + getSuit());
    }

}
