from unittest.mock import MagicMock

from database import Book, FakeDB
from main import get_books


def test_get_books():
    bd = MagicMock(spec=FakeDB)
    test_book = Book(title="test book", description="test description")
    bd.get_all_books.return_value = [test_book]

    books = get_books(bd)

    assert len(books) == 1
    assert books[0].title == test_book.title
