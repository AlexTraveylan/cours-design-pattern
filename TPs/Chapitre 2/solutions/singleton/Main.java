public class Main {
    public static void main(String[] args) {
        // Test du Singleton et des fonctionnalités du zoo
        System.out.println("=== Démonstration du Zoo Management System ===\n");

        // Obtention de l'instance unique
        ZooController zoo = ZooController.getInstance();

        // Tentative de création d'une deuxième instance (retournera la même)
        ZooController zoo2 = ZooController.getInstance();

        // Vérification que c'est la même instance
        System.out.println("Les instances sont-elles identiques ? " + (zoo == zoo2));

        // Simulation d'une journée au zoo
        System.out.println("\n=== Simulation d'une journée au zoo ===\n");

        // Ouverture du zoo
        zoo.ouvrirZoo();

        // Ajout d'animaux
        for (int i = 0; i < 5; i++) {
            zoo.ajouterAnimal();
        }

        // Arrivée de visiteurs
        for (int i = 0; i < 10; i++) {
            zoo.ajouterVisiteur();
            zoo.ajouterRevenu(15.0); // Prix du ticket : 15€
        }

        // Affichage de l'état du zoo
        zoo.afficherEtatZoo();

        // Simulation de départ de visiteurs
        for (int i = 0; i < 3; i++) {
            zoo.retirerVisiteur();
        }

        System.out.println("\n=== Après le départ de quelques visiteurs ===\n");
        zoo.afficherEtatZoo();

        // Fermeture du zoo
        zoo.fermerZoo();

        System.out.println("\n=== Après la fermeture du zoo ===\n");
        zoo.afficherEtatZoo();
    }
}