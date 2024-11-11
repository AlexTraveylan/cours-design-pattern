from abc import ABC, abstractmethod


class Creature(ABC):
    """Classe abstraite de base pour toutes les créatures mythiques."""

    def __init__(self, name: str):
        self.name = name

    @abstractmethod
    def get_description(self) -> str:
        """Retourne une description détaillée de la créature."""

        raise NotImplementedError("La méthode get_description doit être implémentée.")
