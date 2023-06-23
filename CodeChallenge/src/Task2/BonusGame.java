package Task2;

import java.util.*;

public class BonusGame {
    private final List<Integer> coinValues = List.of(2, 3, 4, 5, 10, 20, 30, 50, 100);
    private final List<Integer> weights = List.of(350, 300, 260, 220, 151, 50, 40, 20, 10);
    private final int totalBet;

    public BonusGame(int totalBet) {
        this.totalBet = totalBet;
    }

    public int play() {
        Random rand = new Random();
        int coinValue = getWeightedRandom(coinValues, weights, rand);
        int diceRoll = 1 + rand.nextInt(6); // random number between 1 and 6
        return coinValue * diceRoll * totalBet;
    }

    private static int getWeightedRandom(List<Integer> values, List<Integer> weights, Random rand) {
        List<Integer> cumulativeWeights = new ArrayList<>();
        int sum = 0;
        for (int weight : weights) {
            sum += weight;
            cumulativeWeights.add(sum);
        }
        int randomValue = rand.nextInt(sum);
        for (int i = 0; i < cumulativeWeights.size(); i++) {
            if (randomValue < cumulativeWeights.get(i)) {
                return values.get(i);
            }
        }
        throw new IllegalStateException("Should not reach here if weights are correct.");
    }
}

