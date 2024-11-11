from __future__ import annotations
from abc import ABC, abstractmethod


class State(ABC):
    @abstractmethod
    def press_play(self, player: MediaPlayer) -> None:
        pass

    @abstractmethod
    def press_pause(self, player: MediaPlayer) -> None:
        pass

    @abstractmethod
    def press_stop(self, player: MediaPlayer) -> None:
        pass


class PlayingState(State):
    def press_play(self, player: MediaPlayer) -> None:
        print("Le lecteur est déjà en lecture.")

    def press_pause(self, player: MediaPlayer) -> None:
        print("Pause le lecteur.")
        player.state = PausedState()

    def press_stop(self, player: MediaPlayer) -> None:
        print("Arrête le lecteur.")
        player.state = StoppedState()


class PausedState(State):
    def press_play(self, player: MediaPlayer) -> None:
        print("Reprend la lecture.")
        player.state = PlayingState()

    def press_pause(self, player: MediaPlayer) -> None:
        print("Le lecteur est déjà en pause.")

    def press_stop(self, player: MediaPlayer) -> None:
        print("Arrête le lecteur depuis la pause.")
        player.state = StoppedState()


class StoppedState(State):
    def press_play(self, player: MediaPlayer) -> None:
        print("Démarre la lecture.")
        player.state = PlayingState()

    def press_pause(self, player: MediaPlayer) -> None:
        print("Le lecteur est arrêté. Impossible de mettre en pause.")

    def press_stop(self, player: MediaPlayer) -> None:
        print("Le lecteur est déjà arrêté.")


class MediaPlayer:
    def __init__(self) -> None:
        self.state: State = StoppedState()

    def press_play(self) -> None:
        self.state.press_play(self)

    def press_pause(self) -> None:
        self.state.press_pause(self)

    def press_stop(self) -> None:
        self.state.press_stop(self)


# Exemple d'utilisation
if __name__ == "__main__":
    player = MediaPlayer()
    player.press_play()  # Démarre la lecture.
    player.press_pause()  # Pause le lecteur.
    player.press_stop()  # Arrête le lecteur depuis la pause.
