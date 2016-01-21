/**
 * @file WarDeck.java
 * @author Matthew chan
 * @date 01/20/2016
 * @brief This class models a deck of playing cards which can shuffle itself and
 * deal itself to two players
 */
package hw3;

import java.util.ArrayList;
import java.util.Random;

// WarDeck class models a playing card deck
public class WarDeck {

    private ArrayList<WarCard> deck;
    public static final int DECK_SIZE = 52;

    /**
     * Constructor
     *
     * @brief This constructor adds 52 cards to the deck each taking on 1 of 13
     * ranks (KING, QUEEN, etc.) and 1 of 4 suits (SPADES, DIAMONDS, CLUBS,
     * HEARTS)
     */
    WarDeck() {
        deck = new ArrayList<WarCard>();
        for (int i = 0; i < DECK_SIZE; i++) {
            int suit = i / 13;
            int rank = i % 13;
            deck.add(new WarCard(rank, suit));
        }
    }

    /**
     * Shuffle the deck
     *
     * @brief Shuffles the deck by iterating through the deck and moving each
     * card to a random position in the deck
     */
    public void shuffle() {
        for (int i = 0; i < DECK_SIZE; i++) {
            int rand = new Random().nextInt(51);
            WarCard temp = deck.get(i);
            deck.set(i, deck.get(rand));
            deck.set(rand, temp);
        }
    }

    /**
     * Print each card in the deck to the console
     */
    public void print() {
        for (WarCard card : deck) {
            card.print();
        }
    }

    /**
     * Deal the cards in the deck to two players
     *
     * @param p1 is the first player to deal to
     * @param p2 is the second player to deal to
     */
    public void deal(WarPlayer p1, WarPlayer p2) {
        for (int i = 0; i < DECK_SIZE; i += 2) {
            p1.acceptCard(deck.get(i));
            p2.acceptCard(deck.get(i + 1));
        }
        deck.clear();
    }
}
