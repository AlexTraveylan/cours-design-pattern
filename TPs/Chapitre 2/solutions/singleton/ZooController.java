public class ZooController {
    // Instance unique du contrôleur
    private static ZooController instance;

    // Statistiques du zoo
    private int totalAnimaux;
    private int visiteursActuels;
    private double revenuJournalier;
    private boolean estOuvert;

    // Constructeur privé pour empêcher l'instanciation directe
    private ZooController() {
        // Initialisation des valeurs par défaut
        this.totalAnimaux = 0;
        this.visiteursActuels = 0;
        this.revenuJournalier = 0.0;
        this.estOuvert = false;
    }

    // Méthode pour obtenir l'instance unique du contrôleur
    public static ZooController getInstance() {
        if (instance == null) {
            instance = new ZooController();
        }
        return instance;
    }

    // Méthodes pour mettre à jour les statistiques
    public void ajouterAnimal() {
        this.totalAnimaux++;
    }

    public void retirerAnimal() {
        if (this.totalAnimaux > 0) {
            this.totalAnimaux--;
        }
    }

    public void ajouterVisiteur() {
        this.visiteursActuels++;
    }

    public void retirerVisiteur() {
        if (this.visiteursActuels > 0) {
            this.visiteursActuels--;
        }
    }

    public void ajouterRevenu(double montant) {
        this.revenuJournalier += montant;
    }

    public void ouvrirZoo() {
        this.estOuvert = true;
    }

    public void fermerZoo() {
        this.estOuvert = false;
        this.visiteursActuels = 0; // On vide le zoo à la fermeture
    }

    // Méthode pour afficher l'état actuel du zoo
    public void afficherEtatZoo() {
        System.out.println("=== État Actuel du Zoo ===");
        System.out.println("Statut : " + (estOuvert ? "Ouvert" : "Fermé"));
        System.out.println("Nombre total d'animaux : " + totalAnimaux);
        System.out.println("Visiteurs actuels : " + visiteursActuels);
        System.out.println("Revenu journalier : " + revenuJournalier + " €");
        System.out.println("========================");
    }

    // Getters pour accéder aux statistiques
    public int getTotalAnimaux() {
        return totalAnimaux;
    }

    public int getVisiteursActuels() {
        return visiteursActuels;
    }

    public double getRevenuJournalier() {
        return revenuJournalier;
    }

    public boolean isEstOuvert() {
        return estOuvert;
    }
}
