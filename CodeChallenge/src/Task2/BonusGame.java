package Task2;

import java.util.*;

public class BonusGame {
    private static final int[] COIN_VALUES = {10, 20, 30, 40, 50, 60};

    public int play() {
        Random rand = new Random();
        int coinValue = COIN_VALUES[rand.nextInt(COIN_VALUES.length)];
        int diceRoll = 1 + rand.nextInt(6); // random number between 1 and 6
        return coinValue * diceRoll;
    }
}
