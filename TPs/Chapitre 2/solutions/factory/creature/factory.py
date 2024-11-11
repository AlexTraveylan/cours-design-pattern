from typing import Literal
from creature.abstract import Creature
from creature.implementation import Cerberus, Dragon, Griffon, Phoenix

type CreatureType = Literal["dragon", "phenix", "griffon", "cerbere"]


class CreatureFactory:
    """Factory pour créer différentes instances de créatures mythiques."""

    _creatures: dict[CreatureType, Creature] = {
        "dragon": Dragon,
        "phenix": Phoenix,
        "griffon": Griffon,
        "cerbere": Cerberus,
    }

    @classmethod
    def create_creature(cls, type_creature: str) -> Creature:
        """
        Crée une instance de créature en fonction du type spécifié.

        Args:
            type_creature: Le type de créature à créer (en minuscules)

        Returns:
            Une instance de la créature demandée

        Raises:
            ValueError: Si le type de créature n'est pas reconnu
        """
        type_creature = type_creature.lower()
        if type_creature not in cls._creatures:
            raise ValueError(
                f"Type de créature '{type_creature}' non reconnu. "
                f"Types disponibles: {', '.join(cls._creatures.keys())}"
            )
        return cls._creatures[type_creature]()

    @classmethod
    def display_creatures_possibles(cls):
        """Affiche les types de créatures disponibles dans la factory."""
        print("\nCréatures disponibles:")
        print("======================")
        for creature in cls._creatures.keys():
            print(f"- {creature.capitalize()}")
        print("======================")
