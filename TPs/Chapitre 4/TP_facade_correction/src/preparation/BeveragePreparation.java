package preparation;

public class BeveragePreparation {
    public void prepareBeverage(String beverage) {
        System.out.println("Préparation de " + beverage + " en cours...");
        // Simulation du temps de préparation
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(beverage + " est prêt !");
    }
}