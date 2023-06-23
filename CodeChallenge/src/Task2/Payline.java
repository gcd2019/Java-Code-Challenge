package Task2;

import java.util.List;

public class Payline {
    private final List<Symbol> symbols;

    public Payline(List<Symbol> symbols) {
        this.symbols = symbols;
    }

    public List<Symbol> getSymbols() {
        return symbols;
    }
}