from creature.factory import CreatureFactory


def main():
    """Interface utilisateur principale."""
    print("=== Bienvenue à l'Usine de Créatures Mythiques ===")

    while True:
        CreatureFactory.display_creatures_possibles()

        type_creature = input(
            "\nQuel type de créature souhaitez-vous créer ? (ou 'q' pour quitter) : "
        )

        if type_creature.lower() == "q":
            print("\nMerci d'avoir utilisé l'Usine de Créatures Mythiques !")
            break

        try:
            creature = CreatureFactory.create_creature(type_creature)
            print("\nCréature générée avec succès !")
            print(creature.get_description())
        except ValueError as e:
            print(f"\nErreur : {e}")


if __name__ == "__main__":
    main()
