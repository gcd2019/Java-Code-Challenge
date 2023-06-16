package Task2;

import java.util.*;

public class Reel {
    private List<String> symbols;

    public Reel() {
        this.symbols = Arrays.asList("W1", "High1", "High2", "High3", "Low1", "Low2", "Low3", "Low4", "Bonus");
    }

    public List<String> spin() {
        Random rand = new Random();
        List<String> result = new ArrayList<>();

        for (int i = 0; i < 3; i++) {
            int randomIndex = rand.nextInt(symbols.size());
            result.add(symbols.get(randomIndex));
        }

        return result;
    }
}