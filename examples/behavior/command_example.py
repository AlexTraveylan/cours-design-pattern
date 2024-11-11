from typing import Protocol


# Récepteur
class TextEditor:
    def __init__(self) -> None:
        self._clipboard: str = ""
        self._text: str = ""

    def cut(self, start: int, end: int) -> None:
        self._clipboard = self._text[start:end]
        self._text = self._text[:start] + self._text[end:]
        print(f"Text après coupe: {self._text}")

    def copy(self, start: int, end: int) -> None:
        self._clipboard = self._text[start:end]
        print(f"Clipboard après copie: {self._clipboard}")

    def paste(self, position: int) -> None:
        self._text = self._text[:position] + self._clipboard + self._text[position:]
        print(f"Text après collage: {self._text}")

    def set_text(self, text: str) -> None:
        self._text = text


# Interface Command
class Command(Protocol):
    def execute(self) -> None: ...


# Invocateur
class TextEditorInvoker:
    def __init__(self) -> None:
        self._history: list[Command] = []

    def execute_command(self, command: Command) -> None:
        command.execute()
        self._history.append(command)


# Commande concrète pour couper
class CutCommand(Command):
    def __init__(self, editor: TextEditor, start: int, end: int) -> None:
        self._editor = editor
        self._start = start
        self._end = end

    def execute(self) -> None:
        self._editor.cut(self._start, self._end)


# Commande concrète pour copier
class CopyCommand(Command):
    def __init__(self, editor: TextEditor, start: int, end: int) -> None:
        self._editor = editor
        self._start = start
        self._end = end

    def execute(self) -> None:
        self._editor.copy(self._start, self._end)


# Commande concrète pour coller
class PasteCommand(Command):
    def __init__(self, editor: TextEditor, position: int) -> None:
        self._editor = editor
        self._position = position

    def execute(self) -> None:
        self._editor.paste(self._position)


# Exemple d'utilisation
if __name__ == "__main__":
    editor = TextEditor()
    editor.set_text("Hello, World!")

    invoker = TextEditorInvoker()

    # Couper "World"
    cut_command = CutCommand(editor, start=7, end=12)
    invoker.execute_command(cut_command)

    # Copier "Hello"
    copy_command = CopyCommand(editor, start=0, end=5)
    invoker.execute_command(copy_command)

    # Coller à la fin
    paste_command = PasteCommand(editor, position=7)
    invoker.execute_command(paste_command)
