package Task2;

import java.util.List;

/**
 * Represents a payline in a slot machine.
 */
public class Payline {
    private final List<Symbol> symbols;

    /**
     * Constructs a payline with the specified symbols.
     *
     * @param symbols the list of symbols in the payline
     */
    public Payline(List<Symbol> symbols) {
        this.symbols = symbols;
    }

    /**
     * Retrieves the symbols in the payline.
     *
     * @return the list of symbols in the payline
     */
    public List<Symbol> getSymbols() {
        return symbols;
    }
}
