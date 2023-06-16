package Task1;

import java.util.Random;

/**
 * The Task1.Game class is an abstract class that represents a generic game.
 * Subclasses of Task1.Game must implement the abstract methods and provide
 * their own game-specific logic.
 */
public abstract class Game {
    // Private fields for storing the number of rolls, payout, and random number generator.
    private int numRolls;
    private int payout;
    private Random rand;

    /**
     * Constructs a new Task1.Game with the given number of rolls, payout, and random number generator.
     *
     * @param numRolls the number of rolls to play in each game
     * @param payout the payout for winning the game
     * @param rand the random number generator to use
     * @throws IllegalArgumentException if numRolls or payout is less than or equal to 0, or if rand is null
     */
    public Game(int numRolls, int payout, Random rand) {
        if (numRolls <= 0) {
            throw new IllegalArgumentException("numRolls must be greater than 0");
        }
        if (payout <= 0) {
            throw new IllegalArgumentException("payout must be greater than 0");
        }
        if (rand == null) {
            throw new IllegalArgumentException("rand must not be null");
        }
        this.numRolls = numRolls;
        this.payout = payout;
        this.rand = rand;
    }

    /**
     * Gets the number of rolls per game.
     *
     * @return the number of rolls per game
     */
    public int getNumRolls() {
        return numRolls;
    }

    /**
     * Gets the payout for winning the game.
     *
     * @return the payout for winning the game
     */
    public int getPayout() {
        return payout;
    }

    /**
     * Plays the game the given number of times and returns the number of wins.
     * Subclasses must implement this method with their own game-specific logic.
     *
     * @param numPlays the number of times to play the game
     * @return the number of wins
     */
    public abstract int play(int numPlays);

    /**
     * Calculates the mean payout per game based on the number of plays and wins.
     *
     * @param numPlays the total number of games played
     * @param numWins the total number of games won
     * @return the mean payout per game
     * @throws IllegalArgumentException if numPlays is less than or equal to 0
     */
    public double getMean(int numPlays, int numWins) {
        if (numPlays <= 0) {
            throw new IllegalArgumentException("numPlays must be positive");
        }
        return (double) numWins / numPlays * payout;
    }

    /**
     * Calculates the variance of the payouts based on the number of plays and wins.
     *
     * @param numPlays the total number of games played
     * @param numWins the total number of games won
     * @return the variance of the payouts
     * @throws IllegalArgumentException if numPlays is less than or equal to 0
     */
    public double getVariance(int numPlays, int numWins) {
        if (numPlays <= 0) {
            throw new IllegalArgumentException("numPlays must be positive");
        }
        return ((double) numWins / numPlays) * (1 - ((double) numWins / numPlays)) * numPlays * payout * payout;
    }

    /**
     * Calculates the standard deviation of the payouts based on the variance.
     *
     * @param variance the variance of the payouts
     * @return the standard deviation of the payouts
     */
    public double getStandardDeviation(double variance) {
        return Math.sqrt(variance);
    }

    /**
     * Gets the random number generator used by the game.
     *
     * @return the random number generator
     */
    public Random getRandom() {
        return rand;
    }


    /**
     * Gets the number of the game.
     * Subclasses must implement this method to return a unique identifier for the game.
     *
     * @return the number of the game
     */
    public abstract int getGameNumber();

    /**
     * Simulates the game the given number of times and prints out statistics about the results.
     *
     * @param numPlays the number of times to simulate the game
     */
    public void simulate(int numPlays) {
        int numWins = play(numPlays);
        int numLosses = numPlays - numWins;
        double mean = getMean(numPlays, numWins);
        double variance = getVariance(numPlays, numWins);
        double stdDev = getStandardDeviation(variance);
        double winPercentage = ((double) numWins / numPlays) * 100;
        System.out.println("Game " + getGameNumber() + ":");
        System.out.println("Number of wins: " + numWins + ", Win percentage: " + winPercentage + "%");
        System.out.println("Number of losses: " + numLosses);
        System.out.println("Mean payout: $" + mean);
        System.out.println("Variance: $" + variance);
        System.out.println("Standard deviation: $" + stdDev + "\n");
    }
}
