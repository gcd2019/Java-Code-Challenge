package Task2;

/**
 * Represents a symbol in a slot game.
 */
public class Symbol {
    /**
     * Enumerates the different types of symbols.
     */
    public enum Type {
        WILD, H1, H2, H3, L1, L2, L3, L4, BONUS
    }

    private final Type type;

    /**
     * Constructs a symbol with the specified type.
     *
     * @param type the type of the symbol
     */
    public Symbol(Type type) {
        this.type = type;
    }

    /**
     * Retrieves the type of the symbol.
     *
     * @return the type of the symbol
     */
    public Type getType() {
        return type;
    }
}

