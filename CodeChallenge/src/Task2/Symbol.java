package Task2;

public class Symbol {
    public enum Type {
        WILD, H1, H2, H3, L1, L2, L3, L4, BONUS
    }

    private final Type type;

    public Symbol(Type type) {
        this.type = type;
    }

    public Type getType() {
        return type;
    }
}

