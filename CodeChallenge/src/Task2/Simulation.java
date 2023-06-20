package Task2;

import java.util.*;

public class Simulation {
    public static void main(String[] args) {
        // Initialize symbols
        Symbol wild = new Symbol(Symbol.Type.WILD);
        Symbol highPay = new Symbol(Symbol.Type.HIGH_PAY);
        Symbol lowPay = new Symbol(Symbol.Type.LOW_PAY);
        Symbol bonus = new Symbol(Symbol.Type.BONUS);

        // Initialize reels
        Reel reel1 = new Reel(Arrays.asList(wild, highPay, lowPay, bonus));
        Reel reel2 = new Reel(Arrays.asList(wild, highPay, lowPay, bonus));
        Reel reel3 = new Reel(Arrays.asList(wild, highPay, lowPay, bonus));
        List<Reel> reels = Arrays.asList(reel1, reel2, reel3);

        SlotMachine machine = new SlotMachine(reels, 10);

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
