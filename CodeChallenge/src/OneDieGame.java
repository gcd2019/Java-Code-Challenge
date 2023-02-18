import java.util.Random;

/**
 * A class representing a game where the player rolls one die multiple times in an attempt to win.
 */
public class OneDieGame extends Game {

    /**
     * Constructs a new OneDieGame with the specified number of rolls per play, payout, and random number generator.
     * @param numRolls the number of times the die is rolled per play.
     * @param payout the payout for a win.
     * @param rand the random number generator used to simulate the die rolls.
     * @throws IllegalArgumentException if numRolls or payout are less than or equal to 0 or if rand is null.
     */
    public OneDieGame(int numRolls, int payout, Random rand) {
        super(numRolls, payout, rand);
    }

    /**
     * Simulates the game for the specified number of plays and returns the number of wins.
     * @param numPlays the number of plays to simulate.
     * @return the number of wins in the simulated plays.
     * @throws IllegalArgumentException if numPlays is less than or equal to 0.
     */
    public int play(int numPlays) {
        if (numPlays <= 0) {
            throw new IllegalArgumentException("numPlays must be greater than 0");
        }

        int numWins = 0;
        for (int i = 0; i < numPlays; i++) {
            boolean win = false;
            for (int j = 0; j < getNumRolls(); j++) {
                try {
                    if (getRandom().nextInt(6) + 1 == 6) {
                        win = true;
                        break;
                    }
                } catch (Exception e) {
                    System.out.println("Error generating random number: " + e.getMessage());
                }
            }
            if (win) {
                numWins++;
            }
        }
        return numWins;
    }

    /**
     * Returns the game number for this game.
     * @return the game number for this game, which is 1.
     */
    public int getGameNumber(){
        return 1;
    }
}
