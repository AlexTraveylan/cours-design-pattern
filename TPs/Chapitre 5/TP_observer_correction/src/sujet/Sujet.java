package src.sujet;

import src.observateur.Observateur;

public interface Sujet {
    void ajouterObservateur(Observateur o);

    void supprimerObservateur(Observateur o);

    void notifierObservateurs();
}