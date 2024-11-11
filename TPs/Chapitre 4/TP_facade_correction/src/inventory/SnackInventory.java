package inventory;

import java.util.HashMap;
import java.util.Map;

public class SnackInventory {
    private Map<String, Product> snacks = new HashMap<>();

    public SnackInventory() {
        snacks.put("croissant", new Product("croissant", 1.50, 50));
        snacks.put("cookie", new Product("cookie", 1.00, 100));
        snacks.put("sandwich", new Product("sandwich", 4.50, 30));
    }

    public boolean checkAvailability(String snack) {
        return snacks.containsKey(snack) && snacks.get(snack).getQuantity() > 0;
    }

    public double getPrice(String snack) {
        return snacks.get(snack).getPrice();
    }

    public void updateStock(String snack) {
        if (checkAvailability(snack)) {
            snacks.get(snack).decrementQuantity();
        }
    }
}