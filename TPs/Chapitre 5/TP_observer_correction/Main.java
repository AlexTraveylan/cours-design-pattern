import src.observateur.*;
import src.sujet.*;

public class Main {
    public static void main(String[] args) {
        // Créer la station météo
        StationMeteo stationMeteo = new StationMeteo();

        // Créer les observateurs
        Observateur affichageNumerique = new AffichageNumerique();
        Observateur smartphone = new Smartphone();
        Observateur panneauExterieur = new PanneauExterieur();

        // Ajouter les observateurs à la station météo
        stationMeteo.ajouterObservateur(affichageNumerique);
        stationMeteo.ajouterObservateur(smartphone);
        stationMeteo.ajouterObservateur(panneauExterieur);

        // Simuler les changements de conditions météorologiques
        stationMeteo.setConditions(22.5f, 65.0f, 1012.3f);
        System.out.println();

        // Retirer les smartphone de la station météo
        stationMeteo.supprimerObservateur(smartphone);

        stationMeteo.setConditions(24.1f, 70.2f, 1010.1f);
        System.out.println();

        // Retirer les panneaux de la station météo
        stationMeteo.supprimerObservateur(panneauExterieur);

        stationMeteo.setConditions(19.8f, 55.3f, 1015.7f);
    }
}