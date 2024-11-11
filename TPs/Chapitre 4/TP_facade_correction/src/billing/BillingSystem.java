package billing;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Map;

public class BillingSystem {
    public double calculateTotal(Map<String, Double> items) {
        return items.values().stream().mapToDouble(Double::doubleValue).sum();
    }

    public void generateReceipt(Map<String, Double> items, double total) {
        System.out.println("\n=== REÇU DE CAISSE ===");
        System.out.println("Date: " + LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm")));
        System.out.println("--------------------");
        items.forEach((item, price) -> System.out.printf("%s: %.2f€%n", item, price));
        System.out.println("--------------------");
        System.out.printf("TOTAL: %.2f€%n", total);
        System.out.println("Merci de votre visite !\n");
    }
}