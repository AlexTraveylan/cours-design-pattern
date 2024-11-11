package preparation;

public class SnackPreparation {
    public void prepareSnack(String snack) {
        System.out.println("Préparation de " + snack + " en cours...");
        // Simulation du temps de préparation
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(snack + " est prêt !");
    }
}