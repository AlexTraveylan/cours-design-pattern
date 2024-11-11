# La classe Memento contient l'état de l'objet à sauvegarder.
class Memento:
    def __init__(self, state: str) -> None:
        self._state = state

    def get_state(self) -> str:
        return self._state


# La classe Originator crée un memento contenant un instantané de son état actuel.
class Originator:
    def __init__(self, state: str) -> None:
        self._state = state

    def save_to_memento(self) -> Memento:
        return Memento(self._state)

    def restore_from_memento(self, memento: Memento) -> None:
        self._state = memento.get_state()

    def set_state(self, state: str) -> None:
        print(f"Changer l'état en: {state}")
        self._state = state

    def get_state(self) -> str:
        return self._state


# La classe Caretaker ne connaît pas les détails de l'état de l'Originator, mais sait gérer les mementos.
class Caretaker:
    def __init__(self) -> None:
        self._mementos: list[Memento] = []

    def add_memento(self, memento: Memento) -> None:
        self._mementos.append(memento)

    def get_memento(self, index: int) -> Memento:
        return self._mementos[index]


# Exemple d'utilisation du pattern Memento
if __name__ == "__main__":
    caretaker = Caretaker()
    originator = Originator("État initial")

    # Sauvegarder l'état initial
    caretaker.add_memento(originator.save_to_memento())

    # Changer l'état et sauvegarder
    originator.set_state("État 1")
    caretaker.add_memento(originator.save_to_memento())

    originator.set_state("État 2")
    caretaker.add_memento(originator.save_to_memento())

    # Restauration de l'état initial
    originator.restore_from_memento(caretaker.get_memento(0))
    print(f"État restauré: {originator.get_state()}")

    # Restauration de l'état 1
    originator.restore_from_memento(caretaker.get_memento(1))
    print(f"État restauré: {originator.get_state()}")
