import facade.CafeteriaFacade;
import java.util.HashMap;
import java.util.Map;

public class CafeteriaApp {
    public static void main(String[] args) {
        CafeteriaFacade cafeteria = new CafeteriaFacade();

        // Exemple de commande
        Map<String, String> order = new HashMap<>();
        order.put("boisson", "café");
        order.put("snack", "croissant");

        System.out.println("=== Nouvelle Commande ===");
        cafeteria.placeOrder(order);

        // Deuxième exemple de commande
        Map<String, String> order2 = new HashMap<>();
        order2.put("boisson", "chocolat chaud");
        order2.put("snack", "cookie");

        System.out.println("=== Nouvelle Commande ===");
        cafeteria.placeOrder(order2);
    }
}