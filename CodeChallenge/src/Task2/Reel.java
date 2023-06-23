package Task2;

import java.util.*;

public class Reel {
    private final List<Symbol> symbols;
    private int currentPosition;

    public Reel(List<Symbol> symbols) {
        this.symbols = symbols;
        this.currentPosition = 0; // Initial position
    }

    public Symbol spin() {
        // Draw a random number between 0 and the reel length
        Random rand = new Random();
        currentPosition = rand.nextInt(symbols.size());
        return getSymbolAtPosition(currentPosition);
    }

    public Symbol getSymbolAtPosition(int position) {
        return symbols.get(position % symbols.size());
    }
}
