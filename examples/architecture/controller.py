from model import BookModel
from view import BookView


class BookController:
    def __init__(self, model: BookModel, view: BookView):
        self.model = model
        self.view = view

    def add_book(self, title: str, author: str) -> None:
        self.model.add_book(title, author)

    def show_books(self) -> None:
        books = self.model.get_books()
        self.view.show_books(books)

    def request_new_book(self) -> None:
        title, author = self.view.prompt_for_book()
        self.add_book(title, author)
