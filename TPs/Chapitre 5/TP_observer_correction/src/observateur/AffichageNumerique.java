package src.observateur;

public class AffichageNumerique implements Observateur {
    private float temperature;
    private float humidite;
    private float pression;

    @Override
    public void mettreAJour(float temperature, float humidite, float pression) {
        this.temperature = temperature;
        this.humidite = humidite;
        this.pression = pression;
        afficher();
    }

    private void afficher() {
        System.out.println("Affichage Numérique:");
        System.out.println("Température: " + temperature + "°C");
        System.out.println("Humidité: " + humidite + "%");
        System.out.println("Pression: " + pression + " hPa");
    }
}