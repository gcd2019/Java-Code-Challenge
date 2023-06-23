package Task2;

import java.util.*;

public class Reel {
    private final List<Symbol> symbols;

    public Reel(List<Symbol> symbols) {
        this.symbols = symbols;
    }

    public List<Symbol> spin() {
        // Shuffling the symbols to simulate a spin
        Collections.shuffle(symbols);
        return symbols;
    }

    public Symbol getSymbolAtPosition(int position) {
        return symbols.get(position);
    }
}
