package inventory;

import java.util.HashMap;
import java.util.Map;

public class BeverageInventory {
    private Map<String, Product> beverages = new HashMap<>();

    public BeverageInventory() {
        beverages.put("café", new Product("café", 2.50, 100));
        beverages.put("thé", new Product("thé", 2.00, 100));
        beverages.put("chocolat chaud", new Product("chocolat chaud", 3.00, 50));
    }

    public boolean checkAvailability(String beverage) {
        return beverages.containsKey(beverage) && beverages.get(beverage).getQuantity() > 0;
    }

    public double getPrice(String beverage) {
        return beverages.get(beverage).getPrice();
    }

    public void updateStock(String beverage) {
        if (checkAvailability(beverage)) {
            beverages.get(beverage).decrementQuantity();
        }
    }
}