/**
 * @file WarGame.java
 * @author Matthew chan
 * @date 01/20/2016
 * @brief This class models a game of War
 */
package hw3;
// WarGame models a game of War between two players

public class WarGame {

    private int round;

    /**
     * Constructor
     *
     * @brief The game keeps track of how many rounds have elapsed
     */
    WarGame() {
        round = 0;
    }

    /**
     * Method runs the game
     */
    public void run() {
        WarDeck w = new WarDeck();
        w.shuffle();
        WarPlayer p1 = new WarPlayer("Matt");
        WarPlayer p2 = new WarPlayer("Elaine");
        w.deal(p1, p2);
        System.out.println("Initial Hands");
        p1.print();
        p2.print();
        while (p1.hasHand() && p2.hasHand()) {
            round += 1;
            System.out.println("Round " + round);
            p1.flip();
            p2.flip();
            p1.print();
            p2.print();
            p1.compare(p2);
        }
        System.out.println("Game Over!");
        System.out.println((p1.hasHand()) ? p1.getName() + " wins!" : p2.getName() + " wins!");
    }

    /**
     * Main method
     */
    public static void main(String[] args) {
        WarGame game = new WarGame();
        game.run();
    }

}
