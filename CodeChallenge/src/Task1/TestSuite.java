package Task1;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Random;

import org.junit.jupiter.api.Test;

/**
 * This class contains JUnit tests for the Task1.Game, Task1.OneDieGame, and Task1.TwoDiceGame classes.
 */
class TestSuite {

    /**
     * Tests the constructor of Task1.OneDieGame by verifying that an IllegalArgumentException is thrown
     * if an invalid number of rolls or payout is specified, and that the properties of the game object are correctly
     * initialized otherwise.
     */
    @Test
    void testOneDieGameConstructor() {
        assertThrows(IllegalArgumentException.class, () -> new OneDieGame(0, 1, new Random()));
        assertThrows(IllegalArgumentException.class, () -> new OneDieGame(1, 0, new Random()));
        assertThrows(IllegalArgumentException.class, () -> new OneDieGame(1, 1, null));
        OneDieGame game = new OneDieGame(1, 1, new Random());
        assertEquals(1, game.getNumRolls());
        assertEquals(1, game.getPayout());
        assertNotNull(game.getRandom());
    }

    /**
     * Tests the play method of Task1.OneDieGame by verifying that the number of wins returned is within the correct range
     * based on the number of plays.
     */
    @Test
    void testOneDieGamePlay() {
        Random rand = new Random();
        OneDieGame game = new OneDieGame(1, 1, rand);
        int numPlays = 100;
        int numWins = game.play(numPlays);
        assertTrue(numWins >= 0 && numWins <= numPlays);
    }

    /**
     * Tests that an IllegalArgumentException is thrown if the play method of Task1.OneDieGame is called with a numPlays argument
     * that is not greater than zero.
     */
    @Test
    void testOneDieGamePlayNotGreaterThanZero() {
        Random rand = new Random();
        OneDieGame game = new OneDieGame(1, 1, rand);
        int numPlays = 0;

        Throwable exception = assertThrows(IllegalArgumentException.class, () -> game.play(numPlays));
        assertEquals("numPlays must be greater than 0", exception.getMessage());
    }

    /**
     * Tests the getMean method of Task1.Game by verifying that the correct mean is returned for a given number of rolls and payout.
     */
    @Test
    void testGameGetMean() {
        Game game = new OneDieGame(1, 1, new Random());
        assertEquals(1.0, game.getMean(1, 1), 0.001);
    }

    /**
     * Tests that an IllegalArgumentException is thrown if the getMean method of Task1.Game is called with a numPlays argument
     * that is not positive.
     */
    @Test
    void testGameGetMeanException(){
        Game game = new OneDieGame(1, 1, new Random());
        Throwable exception = assertThrows(IllegalArgumentException.class, () -> game.getMean(-1, 1));
        assertEquals("numPlays must be positive", exception.getMessage());
    }

    /**
     * Tests the getVariance method of Task1.Game by verifying that the correct variance is returned for a given number of rolls and payout.
     */
    @Test
    void testGameGetVariance() {
        Game game = new OneDieGame(1, 1, new Random());
        assertEquals(0.0, game.getVariance(1, 0), 0.001);
        assertEquals(0.75, game.getVariance(4, 1), 0.001);
    }

    /**
     * Tests the getVariance method of the Task1.Game class with an illegal argument.
     */
    @Test
    void testGameGetVarianceException() {
        Game game = new OneDieGame(1, 1, new Random());
        Throwable exception = assertThrows(IllegalArgumentException.class, () -> game.getVariance(-1, 1));
        assertEquals("numPlays must be positive", exception.getMessage());
    }

    /**
     * Tests the getStandardDeviation method of the Task1.Game class with various input values.
     */
    @Test
    void testGameGetStandardDeviation() {
        Game game = new OneDieGame(1, 1, new Random());
        assertEquals(0.0, game.getStandardDeviation(0.0), 0.001);
        assertEquals(0.5, game.getStandardDeviation(0.25), 0.001);
    }

    /**
     * Tests the getGameNumber method of the Task1.OneDieGame class.
     */
    @Test
    void testOneDieGameGetGameNumber() {
        OneDieGame game = new OneDieGame(1, 1, new Random());
        assertEquals(1, game.getGameNumber());
    }


    /**
     * Tests the simulate method of the Task1.Game class with a given number of simulations.
     */
    @Test
    void testGameSimulate() {
        Game game = new OneDieGame(1, 1, new Random());
        game.simulate(100);
    }


    /**
     * Tests the constructor of the Task1.TwoDiceGame class with illegal arguments.
     * Tests that the game object is properly initialized for legal arguments.
     */
    @Test
    void testTwoDiceGameConstructor() {
        assertThrows(IllegalArgumentException.class, () -> new TwoDiceGame(0, 1, new Random()));
        assertThrows(IllegalArgumentException.class, () -> new TwoDiceGame(1, 0, new Random()));
        assertThrows(IllegalArgumentException.class, () -> new TwoDiceGame(1, 1, null));
        TwoDiceGame game = new TwoDiceGame(1, 1, new Random());
        assertEquals(1, game.getNumRolls());
        assertEquals(1, game.getPayout());
        assertNotNull(game.getRandom());
    }

    /**
     * Tests the play method of the Task1.TwoDiceGame class with a given number of plays.
     * Ensures that the number of wins falls within the valid range.
     */
    @Test
    void testTwoDiceGamePlay() {
        Random rand = new Random();
        TwoDiceGame game = new TwoDiceGame(2, 2, rand);
        int numPlays = 100;
        int numWins = game.play(numPlays);
        assertTrue(numWins >= 0 && numWins <= numPlays);
    }

    /**
     * Tests the play method of the Task1.TwoDiceGame class with a number of plays less than or equal to 0.
     * Ensures that an IllegalArgumentException is thrown with the proper error message.
     */
    @Test
    void testTwoDiceGamePlayNotGreaterThanZero() {
        Random rand = new Random();
        TwoDiceGame game = new TwoDiceGame(1, 1, rand);
        int numPlays = 0;

        Throwable exception = assertThrows(IllegalArgumentException.class, () -> game.play(numPlays));
        assertEquals("numPlays must be greater than 0", exception.getMessage());
    }

    /**
     * Tests the getGameNumber method of the Task1.TwoDiceGame class.
     */
    @Test
    void testTwoDiceGameGetGameNumber() {
        TwoDiceGame game = new TwoDiceGame(1, 1, new Random());
        assertEquals(2, game.getGameNumber());
    }
}
