/**
 * @file WarPlayer.java
 * @author Matthew chan
 * @date 01/20/2016
 * @brief This class models a player in the card game War
 */
package hw3;

import java.util.ArrayList;

// WarPlayer models a player playing the card game War
public class WarPlayer {

    private String name;
    private ArrayList<WarCard> hand;
    private ArrayList<WarCard> pile;

    /**
     * Constructor
     *
     * @param name is the name of player
     */
    WarPlayer(String name) {
        this.name = name;
        hand = new ArrayList<WarCard>();
        pile = new ArrayList<WarCard>();
    }

    /**
     * Return the name of the player
     */
    public String getName() {
        return name;
    }

    /**
     * Add a card to the player's hand
     *
     * @param card is the card to add to the player's hand
     */
    public void acceptCard(WarCard card) {
        hand.add(card);
    }

    /**
     * Add cards from a player's pile to his/her hand
     *
     * @param player is the player from whose pile to take from
     */
    public void takePile(WarPlayer player) {
        for (WarCard card : player.pile) {
            hand.add(card);
        }
    }

    /**
     * Flip the first card from a players hand (consequently adding it to their
     * pile)
     */
    public void flip() {
        pile.add(0, hand.get(0));
        hand.remove(0);
    }

    /**
     * Compares the pile of one player to another's and determines the winner
     *
     * @param p2 is the other player to compare against
     */
    public void compare(WarPlayer p2) {
        // This player wins
        if (pile.get(0).compareTo(p2.pile.get(0))) {
            takePile(this);
            takePile(p2);
            pile.clear();
            p2.pile.clear();
            System.out.println(name + " says: I win. " + name + " took piles.");
        } // Other player wins
        else if (p2.pile.get(0).compareTo(pile.get(0))) {
            p2.takePile(p2);
            p2.takePile(this);
            pile.clear();
            p2.pile.clear();
            System.out.println(p2.name + " says: I win. " + p2.name + " took piles.");
        } // WAR!
        else if (pile.get(0).getRank() == p2.pile.get(0).getRank()) {
            war(p2);
        }
    }

    /**
     * Each player draws two cards from their hand and compares the last card
     * they drew against each other
     *
     * @param p2 is the player to compare against
     * @brief A player automatically loses the war if they do not have two cards
     * remaining in their hand to flip
     */
    public void war(WarPlayer p2) {
        System.out.println("WAR!");
        // Only engage in war if both players have at least 2 cards in their hand
        if (hand.size() > 2 && p2.hand.size() > 2) {
            flip();
            flip();
            p2.flip();
            p2.flip();
            print();
            p2.print();
            compare(p2);
        } else // If player 2 doesn't have enough cards, they lose
        if (p2.hand.size() < 2) {
            while (p2.hand.size() > 0) {
                p2.flip();
            }
            for (WarCard card : p2.pile) {
                hand.add(card);
            }
            for (WarCard card : pile) {
                hand.add(card);
            }
            p2.pile.clear();
            pile.clear();
            System.out.println(name + " wins round!");
        } // If player 1 doesn't have enough cards, they lose
        else if (hand.size() < 2) {
            while (hand.size() > 0) {
                flip();
            }
            for (WarCard card : p2.pile) {
                p2.hand.add(card);
            }
            for (WarCard card : pile) {
                p2.hand.add(card);
            }
            p2.pile.clear();
            pile.clear();
            System.out.println(p2.name + " wins round!");
        }
    }

    /**
     * Returns true if a player has cards in their hand
     */
    public boolean hasHand() {
        return hand.size() > 0;
    }

    /**
     * Returns true if a player has cards in their pile
     */
    public boolean hasPile() {
        return pile.size() > 0;
    }

    /**
     * Prints the cards in each player's hand and pile
     */
    public void print() {
        // Only print if cards exist in the player's pile
        if (hasPile()) {
            System.out.print(name + "\'s Pile: ");
            for (int i = 0; i < pile.size(); i++) {
                if (i == pile.size() - 1) {
                    System.out.print(pile.get(i).getRank() + " of " + pile.get(i).getSuit());
                } else {
                    System.out.print(pile.get(i).getRank() + " of " + pile.get(i).getSuit() + ", ");
                }
            }
        } // Dividing character between a player's hand and pile
        if (hasPile() && hasHand()) {
            System.out.print(" | ");
        }
        // Only print if cards exist in the player's hand
        if (hasHand()) {
            System.out.print(name + "'s Hand: ");
            if (hand.size() > 4) {
                // try to implement for DECK_SIZE
                for (int i = 0; i < 2; i++) {
                    System.out.print(hand.get(i).getRank() + " of " + hand.get(i).getSuit() + ", ");
                }
                System.out.print("(" + (hand.size() - 4) + " more), ");
                for (int i = hand.size() - 2; i < hand.size(); i++) {
                    if (i == hand.size() - 1) {
                        System.out.print(hand.get(i).getRank() + " of " + hand.get(i).getSuit());
                    } else {
                        System.out.print(hand.get(i).getRank() + " of " + hand.get(i).getSuit() + ", ");
                    }
                }
            } else {
                for (int i = 0; i < hand.size(); i++) {
                    if (i == hand.size() - 1) {
                        System.out.print(hand.get(i).getRank() + " of " + hand.get(i).getSuit());
                    } else {
                        System.out.print(hand.get(i).getRank() + " of " + hand.get(i).getSuit() + ", ");
                    }
                }
            }
        }
        System.out.print("\n");
    }
}
