// Interface Strategy
interface TarifStrategy {
    double calculerTarif(double distance);
}

// Implémentation de la stratégie pour le bus
class TarifBus implements TarifStrategy {
    public double calculerTarif(double distance) {
        return distance * 1.5; // Exemple de tarif par km
    }
}

// Implémentation de la stratégie pour le train
class TarifTrain implements TarifStrategy {
    public double calculerTarif(double distance) {
        return distance * 2.0; // Exemple de tarif par km
    }
}

// Contexte qui utilise une stratégie
class CalculateurDeTarif {
    private TarifStrategy strategie;

    public void setStrategie(TarifStrategy strategie) {
        this.strategie = strategie;
    }

    public double calculer(double distance) {
        if (strategie == null) {
            throw new IllegalStateException("Stratégie non définie");
        }
        return strategie.calculerTarif(distance);
    }
}

// Classe de test
public class StategyExample {
    public static void main(String[] args) {
        CalculateurDeTarif calculateur = new CalculateurDeTarif();

        // Utilisation de la stratégie de tarif pour le bus
        calculateur.setStrategie(new TarifBus());
        System.out.println("Tarif pour le bus: " + calculateur.calculer(10)); // Output: 15.0

        // Changement pour la stratégie de tarif pour le train
        calculateur.setStrategie(new TarifTrain());
        System.out.println("Tarif pour le train: " + calculateur.calculer(10)); // Output: 20.0
    }
}