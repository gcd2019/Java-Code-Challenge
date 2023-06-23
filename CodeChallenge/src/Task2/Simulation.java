package Task2;

import java.util.*;

public class Simulation {
    public static void main(String[] args) {
        // Initialize symbols
        Symbol wild = new Symbol(Symbol.Type.WILD);
        Symbol h1 = new Symbol(Symbol.Type.H1);
        Symbol h2 = new Symbol(Symbol.Type.H2);
        Symbol h3 = new Symbol(Symbol.Type.H3);
        Symbol l1 = new Symbol(Symbol.Type.L1);
        Symbol l2 = new Symbol(Symbol.Type.L2);
        Symbol l3 = new Symbol(Symbol.Type.L3);
        Symbol l4 = new Symbol(Symbol.Type.L4);
        Symbol bonus = new Symbol(Symbol.Type.BONUS);

        // Initialize reels with appropriate number of each symbol
        List<Symbol> symbolPool = new ArrayList<>();
        symbolPool.add(wild);
        symbolPool.add(h1);
        symbolPool.add(h2);
        symbolPool.add(h3);
        symbolPool.add(l1);
        symbolPool.add(l2);
        symbolPool.add(l3);
        symbolPool.add(l4);
        symbolPool.add(bonus);

        Reel reel1 = new Reel(new ArrayList<>(symbolPool));
        Reel reel2 = new Reel(new ArrayList<>(symbolPool));
        Reel reel3 = new Reel(new ArrayList<>(symbolPool));
        List<Reel> reels = Arrays.asList(reel1, reel2, reel3);

        SlotMachine machine = new SlotMachine(reels, 10, 5);

        long totalBet = 0;
        long totalWin = 0;

        for (int i = 0; i < 10_000_000; i++) {
            totalBet += machine.getCreditPerSpin();
            totalWin += machine.spin();
        }

        double rtp = (double) totalWin / totalBet;
        System.out.println("RTP: " + rtp);
    }
}
