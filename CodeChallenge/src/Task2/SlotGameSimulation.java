package Task2;

import java.util.*;

public class SlotGameSimulation {
    private static final int NUM_ROUNDS = 10_000_000;
    private static final int BET_AMOUNT = 10;
    private static final int[][] PAYLINES = new int[][]{{0,1,2},{3,4,5},{6,7,8},{0,4,8},{2,4,6}};
    private static final Map<List<Integer>, Integer> PAYOUTS = new HashMap<>();

    static {
        // Define payout for 3 of '1' on a payline, 3 of '2' on a payline and so on.
        PAYOUTS.put(Arrays.asList(1, 1, 1), 20);
        PAYOUTS.put(Arrays.asList(2, 2, 2), 30);
    }

    private int[][] reels = new int[][]{
            {1, 2, 1, 2, 1, 2, 1, 2, 1, 2},  // Reel 1
            {1, 2, 1, 2, 1, 2, 1, 2, 1, 2},  // Reel 2
            {1, 2, 1, 2, 1, 2, 1, 2, 1, 2},  // Reel 3
    };

    public static void main(String[] args) {
        SlotGameSimulation simulation = new SlotGameSimulation();
        simulation.runSimulation();
    }

    public void runSimulation() {
        Random random = new Random();
        long totalPayout = 0;

        for (int i = 0; i < NUM_ROUNDS; i++) {
            // Create a copy of the initial reels
            int[][] currentReels = Arrays.stream(reels)
                    .map(int[]::clone)
                    .toArray(int[][]::new);

            // Randomly shift each reel vertically
            for (int[] reel : currentReels) {
                int shift = random.nextInt(reel.length);
                int[] temp = Arrays.copyOf(reel, reel.length);
                for (int j = 0; j < reel.length; j++) {
                    reel[(j + shift) % reel.length] = temp[j];
                }
            }

            // Evaluate wins based on the paylines
            for (int[] payline : PAYLINES) {
                List<Integer> currentPayline = new ArrayList<>();
                for (int j = 0; j < 3; j++) {
                    int index = payline[j] / 3;  // Get the reel number
                    int position = payline[j] % 3;  // Get the position on the reel
                    currentPayline.add(currentReels[index][position]);
                }
                totalPayout += PAYOUTS.getOrDefault(currentPayline, 0);
            }
        }

        double RTP = (double) totalPayout / (NUM_ROUNDS * BET_AMOUNT);
        System.out.println("Return to Player (RTP): " + RTP);
    }
}
