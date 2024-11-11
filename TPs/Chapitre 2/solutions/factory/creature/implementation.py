from creature.abstract import Creature


class Dragon(Creature):
    """Classe représentant un Dragon."""

    def __init__(self):
        super().__init__("Dragon")
        self._element = "feu"
        self._wingspan = 30  # mètres

    def get_description(self) -> str:
        return (
            f"Un majestueux {self.name}, créature légendaire crachant le {self._element}. "
            f"Avec une envergure de {self._wingspan} mètres, il inspire la crainte et le respect. "
            "Capable de voler pendant des jours et de réduire des villages entiers en cendres."
        )


class Phoenix(Creature):
    """Classe représentant un Phénix."""

    def __init__(self):
        super().__init__("Phénix")
        self._regeneration_cycle = 500  # années

    def get_description(self) -> str:
        return (
            f"Un mystérieux {self.name}, oiseau immortel de feu. "
            f"Renaît de ses cendres tous les {self._regeneration_cycle} ans. "
            "Son chant peut guérir les blessures et ses larmes ont des propriétés magiques."
        )


class Griffon(Creature):
    """Classe représentant un Griffon."""

    def __init__(self):
        super().__init__("Griffon")
        self._head_type = "aigle"
        self._body_type = "lion"

    def get_description(self) -> str:
        return (
            f"Un noble {self.name}, hybride majestueux avec la tête d'un {self._head_type} "
            f"et le corps d'un {self._body_type}. "
            "Gardien légendaire des trésors et protecteur des royaumes anciens."
        )


class Cerberus(Creature):
    """Classe représentant Cerbère."""

    def __init__(self):
        super().__init__("Cerbère")
        self._num_heads = 3

    def get_description(self) -> str:
        return (
            f"Le terrible {self.name}, chien à {self._num_heads} têtes gardien des Enfers. "
            "Ses yeux luisent d'un feu infernal et ses crocs peuvent déchirer l'âme même. "
            "Nul ne peut franchir les portes des Enfers sans son accord."
        )
