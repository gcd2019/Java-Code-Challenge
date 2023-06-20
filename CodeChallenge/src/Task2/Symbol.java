package Task2;

public class Symbol {
    public enum Type {
        WILD, HIGH_PAY, LOW_PAY, BONUS
    }

    private final Type type;

    public Symbol(Type type) {
        this.type = type;
    }

    public Type getType() {
        return type;
    }
}

