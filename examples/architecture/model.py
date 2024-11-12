class Book:
    def __init__(self, title: str, author: str):
        self.title = title
        self.author = author


class BookModel:
    def __init__(self):
        self.books: list[Book] = []

    def add_book(self, title: str, author: str) -> None:
        book = Book(title, author)
        self.books.append(book)

    def get_books(self) -> list[Book]:
        return self.books
