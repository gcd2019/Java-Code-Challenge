package Task2;

import java.util.*;

public class SlotMachine {
    private final List<Reel> reels;
    private final int creditPerSpin;

    public SlotMachine(List<Reel> reels, int creditPerSpin) {
        this.reels = reels;
        this.creditPerSpin = creditPerSpin;
    }

    public int spin() {
        Map<Symbol.Type, Integer> symbolCounts = new HashMap<>();

        for (Reel reel : reels) {
            Symbol.Type type = reel.spin().getType();
            symbolCounts.put(type, symbolCounts.getOrDefault(type, 0) + 1);
        }

        int totalWin = calculateWin(symbolCounts);

        // Check for bonus game
        if (symbolCounts.getOrDefault(Symbol.Type.BONUS, 0) >= 3) {
            totalWin += new BonusGame().play();
        }

        return totalWin;
    }

    private int calculateWin(Map<Symbol.Type, Integer> symbolCounts) {
        int win = 0;
        if (symbolCounts.getOrDefault(Symbol.Type.HIGH_PAY, 0) >= 3) {
            win += 1000;
        } else if (symbolCounts.getOrDefault(Symbol.Type.LOW_PAY, 0) >= 3) {
            win += 100;
        }
        return win;
    }

    public int getCreditPerSpin() {
        return creditPerSpin;
    }
}
