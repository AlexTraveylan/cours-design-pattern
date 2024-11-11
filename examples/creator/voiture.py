# Classe Voiture
class Voiture:
    def __init__(self):
        self.carrosserie = None
        self.moteur = None
        self.roues = None


# Builder pour la classe Voiture
class VoitureBuilder:
    def __init__(self):
        self.voiture = Voiture()

    def set_carrosserie(self, carrosserie):
        self.voiture.carrosserie = carrosserie
        return self

    def set_moteur(self, moteur):
        self.voiture.moteur = moteur
        return self

    def set_roues(self, roues):
        self.voiture.roues = roues
        return self

    def build(self):
        return self.voiture


# Utilisation du Builder pour créer une Voiture
builder = VoitureBuilder()
voiture_personnalisee = (
    builder.set_carrosserie("berline").set_moteur("V8").set_roues(4).build()
)

print(voiture_personnalisee)
