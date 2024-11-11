// Interface pour les handlers de la chaîne
interface SupportHandler {
    void setNextHandler(SupportHandler handler);

    void handleRequest(String issue);
}

// Handler de support technique de base
class BasicSupportHandler implements SupportHandler {
    private SupportHandler nextHandler;

    public void setNextHandler(SupportHandler handler) {
        this.nextHandler = handler;
    }

    public void handleRequest(String issue) {
        if (issue.equals("basic")) {
            System.out.println("Basic Support: Problème résolu par le support technique de base.");
        } else {
            if (nextHandler != null) {
                nextHandler.handleRequest(issue);
            }
        }
    }
}

// Handler de support technique avancé
class AdvancedSupportHandler implements SupportHandler {
    private SupportHandler nextHandler;

    public void setNextHandler(SupportHandler handler) {
        this.nextHandler = handler;
    }

    public void handleRequest(String issue) {
        if (issue.equals("advanced")) {
            System.out.println("Advanced Support: Problème résolu par le support technique avancé.");
        } else {
            if (nextHandler != null) {
                nextHandler.handleRequest(issue);
            }
        }
    }
}

// Handler de support par le manager
class ManagerSupportHandler implements SupportHandler {

    public void setNextHandler(SupportHandler handler) {
        // Pas de prochain handler, car c'est le dernier niveau de la chaîne
    }

    public void handleRequest(String issue) {
        System.out.println("Manager Support: Problème résolu par le manager.");
    }
}

// Exemple d'utilisation de la chaîne de responsabilité
public class ChainOfResponsibilityExample {
    public static void main(String[] args) {
        // Création des handlers
        SupportHandler basicSupport = new BasicSupportHandler();
        SupportHandler advancedSupport = new AdvancedSupportHandler();
        SupportHandler managerSupport = new ManagerSupportHandler();

        // Configuration de la chaîne de responsabilité
        basicSupport.setNextHandler(advancedSupport);
        advancedSupport.setNextHandler(managerSupport);

        // Simulation de différentes requêtes
        System.out.println("Envoi d'une requête de type 'basic':");
        basicSupport.handleRequest("basic");

        System.out.println("\nEnvoi d'une requête de type 'advanced':");
        basicSupport.handleRequest("advanced");

        System.out.println("\nEnvoi d'une requête de type 'other':");
        basicSupport.handleRequest("other");
    }
}