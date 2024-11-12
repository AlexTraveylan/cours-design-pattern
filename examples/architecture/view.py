from model import Book


class BookView:
    def show_books(self, books: list[Book]) -> None:
        for book in books:
            print(f"Title: {book.title}, Author: {book.author}")

    def prompt_for_book(self) -> tuple:
        title = input("Enter book title: ")
        author = input("Enter book author: ")
        return title, author
