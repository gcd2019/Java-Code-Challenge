package Task2;

import java.util.*;

public class Reel {
    private final List<Symbol> symbols;

    public Reel(List<Symbol> symbols) {
        this.symbols = symbols;
    }

    public Symbol spin() {
        int index = new Random().nextInt(symbols.size());
        return symbols.get(index);
    }
}
