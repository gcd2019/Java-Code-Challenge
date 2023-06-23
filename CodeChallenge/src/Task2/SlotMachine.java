package Task2;

import java.util.*;

public class SlotMachine {
    private final List<Reel> reels;
    private List<Payline> paylines;
    private final int creditPerSpin;

    public SlotMachine(List<Reel> reels, int creditPerSpin, int numPaylines) {
        this.reels = reels;
        this.paylines = new ArrayList<>(Collections.nCopies(numPaylines, null));
        this.creditPerSpin = creditPerSpin;
    }

    public int spin() {
        // Re-initialize paylines before each spin
        this.paylines = new ArrayList<>(Collections.nCopies(this.paylines.size(), null));

        boolean bonusTriggered = false;
        for (int i = 0; i < 3; i++) {
            List<Symbol> symbols = new ArrayList<>();
            for (Reel reel : reels) {
                Symbol symbol = reel.spin();
                symbols.add(symbol);
                // Check for Bonus Game
                if (symbol.getType() == Symbol.Type.BONUS) {
                    bonusTriggered = true;
                }
            }
            paylines.set(i, new Payline(symbols));
        }

        // Add diagonal paylines
        for (int i = 3; i < paylines.size(); i++) {
            List<Symbol> symbols = new ArrayList<>();
            for (int j = 0; j < reels.size(); j++) {
                if (i == 3) {
                    // Top left to bottom right diagonal
                    symbols.add(reels.get(j).getSymbolAtPosition(j));
                } else {
                    // Top right to bottom left diagonal
                    symbols.add(reels.get(j).getSymbolAtPosition(2 - j));
                }
            }
            paylines.set(i, new Payline(symbols));
        }

        int totalWin = 0;
        for (Payline payline : paylines) {
            totalWin += calculateWin(payline.getSymbols());
        }

        // Trigger bonus game if bonus symbols were present
        if (bonusTriggered) {
            BonusGame bonusGame = new BonusGame(getCreditPerSpin());
            totalWin += bonusGame.play();
        }
        return totalWin;
    }

    private int calculateWin(List<Symbol> symbols) {
        int win = 0;
        Map<Symbol.Type, Integer> symbolCounts = new HashMap<>();
        for (Symbol symbol : symbols) {
            symbolCounts.put(symbol.getType(), symbolCounts.getOrDefault(symbol.getType(), 0) + 1);
        }

        // Consider Wild Symbols as any symbol except bonus
        int wildCount = symbolCounts.getOrDefault(Symbol.Type.WILD, 0);
        for (Symbol.Type type : Symbol.Type.values()) {
            if (type != Symbol.Type.BONUS && type != Symbol.Type.WILD) {
                symbolCounts.put(type, symbolCounts.getOrDefault(type, 0) + wildCount);
            }
        }

        win += symbolCounts.getOrDefault(Symbol.Type.WILD, 0) / 3 * 2000;
        win += symbolCounts.getOrDefault(Symbol.Type.H1, 0) / 3 * 800;
        win += symbolCounts.getOrDefault(Symbol.Type.H2, 0) / 3 * 400;
        win += symbolCounts.getOrDefault(Symbol.Type.H3, 0) / 3 * 80;
        win += symbolCounts.getOrDefault(Symbol.Type.L1, 0) / 3 * 60;
        win += symbolCounts.getOrDefault(Symbol.Type.L2, 0) / 3 * 20;
        win += symbolCounts.getOrDefault(Symbol.Type.L3, 0) / 3 * 16;
        win += symbolCounts.getOrDefault(Symbol.Type.L4, 0) / 3 * 12;

        return win;
    }

    public int getCreditPerSpin() {
        return creditPerSpin;
    }
}