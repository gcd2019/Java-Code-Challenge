package Task2;

import java.util.*;

public class BonusGame {
    private Map<Integer, Integer> weightedCoins;

    public BonusGame() {
        this.weightedCoins = new HashMap<>();
        // TODO: Initialize the weightedCoins map with weights and values
    }

    public void start() {
        Random rand = new Random();
        int randomCoin = // TODO: Select a random coin based on the weights
        int diceRoll = rand.nextInt(6) + 1;

        int payout = diceRoll * randomCoin;
        System.out.println("You won " + payout + " credits in the bonus game!");
    }
}
