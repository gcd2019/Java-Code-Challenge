package Task2;

import java.util.*;

public class SlotGame {
    private Reel reel;
    private int totalBet;
    private BonusGame bonusGame;

    public SlotGame() {
        this.reel = new Reel();
        this.totalBet = 10;
        this.bonusGame = new BonusGame();
    }

    public void play() {
        // Spin the reel and get the result
        List<String> result = reel.spin();

        // Check if we got a bonus symbol
        if (result.contains("Bonus")) {
            bonusGame.start();
        }

        // TODO: Implement the payout logic based on the result from the reel.
    }
}