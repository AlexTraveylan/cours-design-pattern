package src.observateur;

public class PanneauExterieur implements Observateur {
    @Override
    public void mettreAJour(float temperature, float humidite, float pression) {
        System.out.println("Panneau Extérieur:");
        System.out.println("Conditions météorologiques actuelles: " + temperature + "°C, " + humidite + "% d'humidité, "
                + pression + " hPa de pression");
    }
}