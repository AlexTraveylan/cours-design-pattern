package facade;

import inventory.*;
import preparation.*;
import billing.*;
import java.util.HashMap;
import java.util.Map;

public class CafeteriaFacade {
    private BeverageInventory beverageInventory;
    private SnackInventory snackInventory;
    private BeveragePreparation beveragePreparation;
    private SnackPreparation snackPreparation;
    private BillingSystem billingSystem;

    public CafeteriaFacade() {
        this.beverageInventory = new BeverageInventory();
        this.snackInventory = new SnackInventory();
        this.beveragePreparation = new BeveragePreparation();
        this.snackPreparation = new SnackPreparation();
        this.billingSystem = new BillingSystem();
    }

    public void placeOrder(Map<String, String> items) {
        Map<String, Double> orderItems = new HashMap<>();
        boolean orderValid = true;

        // Vérification de la disponibilité
        for (Map.Entry<String, String> entry : items.entrySet()) {
            String type = entry.getKey();
            String item = entry.getValue();

            if (type.equals("boisson")) {
                if (!beverageInventory.checkAvailability(item)) {
                    System.out.println("Désolé, " + item + " n'est pas disponible.");
                    orderValid = false;
                }
            } else if (type.equals("snack")) {
                if (!snackInventory.checkAvailability(item)) {
                    System.out.println("Désolé, " + item + " n'est pas disponible.");
                    orderValid = false;
                }
            }
        }

        if (!orderValid) {
            System.out.println("Commande annulée.");
            return;
        }

        // Traitement de la commande
        for (Map.Entry<String, String> entry : items.entrySet()) {
            String type = entry.getKey();
            String item = entry.getValue();

            if (type.equals("boisson")) {
                beverageInventory.updateStock(item);
                beveragePreparation.prepareBeverage(item);
                orderItems.put(item, beverageInventory.getPrice(item));
            } else if (type.equals("snack")) {
                snackInventory.updateStock(item);
                snackPreparation.prepareSnack(item);
                orderItems.put(item, snackInventory.getPrice(item));
            }
        }

        // Facturation
        double total = billingSystem.calculateTotal(orderItems);
        billingSystem.generateReceipt(orderItems, total);
    }
}