package src.sujet;

import src.observateur.Observateur;

import java.util.ArrayList;
import java.util.List;

public class StationMeteo implements Sujet {
    private float temperature;
    private float humidite;
    private float pression;
    private List<Observateur> observateurs;

    public StationMeteo() {
        observateurs = new ArrayList<>();
    }

    public void setConditions(float temperature, float humidite, float pression) {
        this.temperature = temperature;
        this.humidite = humidite;
        this.pression = pression;
        notifierObservateurs();
    }

    @Override
    public void ajouterObservateur(Observateur o) {
        observateurs.add(o);
    }

    @Override
    public void supprimerObservateur(Observateur o) {
        observateurs.remove(o);
    }

    @Override
    public void notifierObservateurs() {
        for (Observateur o : observateurs) {
            o.mettreAJour(temperature, humidite, pression);
        }
    }
}
