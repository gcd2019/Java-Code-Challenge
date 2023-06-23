package Task2;

import java.util.*;

/**
 * Represents a reel in a slot machine.
 */
public class Reel {
    private final List<Symbol> symbols;
    private int currentPosition;

    /**
     * Constructs a reel with the specified symbols.
     *
     * @param symbols the list of symbols in the reel
     */
    public Reel(List<Symbol> symbols) {
        this.symbols = symbols;
        this.currentPosition = 0; // Initial position
    }

    /**
     * Spins the reel and returns a symbol at the current position.
     *
     * @return the symbol at the current position
     */
    public Symbol spin() {
        // Draw a random number between 0 and the reel length
        Random rand = new Random();
        currentPosition = rand.nextInt(symbols.size());
        return getSymbolAtPosition(currentPosition);
    }

    /**
     * Retrieves the symbol at the specified position.
     * If the position exceeds the number of symbols in the reel, it wraps around.
     *
     * @param position the position of the symbol
     * @return the symbol at the specified position
     */
    public Symbol getSymbolAtPosition(int position) {
        return symbols.get(position % symbols.size());
    }
}

