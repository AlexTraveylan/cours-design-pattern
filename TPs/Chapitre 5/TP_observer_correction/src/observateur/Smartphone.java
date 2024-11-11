package src.observateur;

public class Smartphone implements Observateur {
    @Override
    public void mettreAJour(float temperature, float humidite, float pression) {
        System.out.println("Notification Smartphone:");
        System.out.println("Nouvelle météo: Température " + temperature + "°C, Humidité " + humidite + "%, Pression "
                + pression + " hPa");
    }
}