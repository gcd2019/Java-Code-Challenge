import java.util.Random;

/**
 * A class representing a two-dice game that extends the Game class. In this game,
 * the player rolls two dice a specified number of times and wins if both dice
 * show a six at least once.
 */
public class TwoDiceGame extends Game {

    /**
     * Constructs a TwoDiceGame object with the given number of rolls, payout, and
     * random number generator.
     *
     * @param numRolls the number of times the player will roll the dice in a game
     * @param payout   the amount of money the player will win if they win the game
     * @param rand     the random number generator to use for the game
     * @throws IllegalArgumentException if numRolls or payout is less than or equal to zero, or if rand is null
     */
    public TwoDiceGame(int numRolls, int payout, Random rand) {
        super(numRolls, payout, rand);
    }

    /**
     * Plays the two-dice game a specified number of times and returns the number of wins.
     *
     * @param numPlays the number of times to play the game
     * @return the number of times the player wins
     * @throws IllegalArgumentException if numPlays is less than or equal to zero
     */
    public int play(int numPlays) {
        if (numPlays <= 0) {
            throw new IllegalArgumentException("numPlays must be greater than 0");
        }

        int numWins = 0;
        for (int i = 0; i < numPlays; i++) {
            boolean win = false;
            for (int j = 0; j < getNumRolls(); j++) {
                try{
                    int roll1 = getRandom().nextInt(6) + 1;
                    int roll2 = getRandom().nextInt(6) + 1;
                    if (roll1 == 6 && roll2 == 6) {
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
     * Returns the number of this game, which is 2.
     *
     * @return the number of this game
     */
    public int getGameNumber(){
        return 2;
    }
}