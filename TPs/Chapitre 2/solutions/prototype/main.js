// Interface Prototype (simulée en JS)
class Prototype {
  clone() {
    throw new Error("La méthode clone() doit être implémentée");
  }
}

// Classe représentant un super-héros
class SuperHero extends Prototype {
  constructor(nom, pouvoirs, experience, equipe) {
    super();
    this.nom = nom;
    this.pouvoirs = [...pouvoirs]; // Copie profonde du tableau des pouvoirs
    this.experience = experience;
    this.equipe = equipe;
  }

  // Méthode de clonage implémentant le pattern Prototype
  clone() {
    return new SuperHero(this.nom, this.pouvoirs, this.experience, this.equipe);
  }

  // Méthode pour afficher les caractéristiques du super-héros
  afficherCaracteristiques() {
    console.log(`
            Super-héros: ${this.nom}
            Pouvoirs: ${this.pouvoirs.join(", ")}
            Expérience: ${this.experience} années
            Équipe: ${this.equipe}
        `);
  }

  // Méthode pour modifier l'équipe du super-héros
  changerEquipe(nouvelleEquipe) {
    this.equipe = nouvelleEquipe;
  }
}

// Démonstration de l'utilisation du pattern Prototype
console.log("=== Création des super-héros originaux ===");

// Création du premier super-héros
const spiderMan = new SuperHero(
  "Spider-Man",
  ["Agilité surhumaine", "Force surhumaine", "Sens d'araignée"],
  10,
  "Avengers"
);

// Création du second super-héros
const ironMan = new SuperHero(
  "Iron Man",
  ["Vol", "Super-intelligence", "Arsenal technologique"],
  15,
  "Avengers"
);

// Affichage des super-héros originaux
console.log("Super-héros originaux :");
spiderMan.afficherCaracteristiques();
ironMan.afficherCaracteristiques();

// Clonage et modification des super-héros
console.log("\n=== Clonage et modification des super-héros ===");

// Clonage de Spider-Man et modification
const spiderManClone = spiderMan.clone();
spiderManClone.nom = "Spider-Man 2099";
spiderManClone.changerEquipe("Defenders");

// Clonage d'Iron Man et modification
const ironManClone = ironMan.clone();
ironManClone.nom = "War Machine";
ironManClone.changerEquipe("Forces armées");

// Affichage des clones modifiés
console.log("Super-héros clonés et modifiés :");
spiderManClone.afficherCaracteristiques();
ironManClone.afficherCaracteristiques();

// Vérification que les originaux n'ont pas été modifiés
console.log("\n=== Vérification des super-héros originaux ===");
console.log("Super-héros originaux (non modifiés) :");
spiderMan.afficherCaracteristiques();
ironMan.afficherCaracteristiques();
