from pydantic import BaseModel


class Book(BaseModel):
    title: str
    description: str


class FakeDB:
    _books = {
        1: Book(title="livre1", description="livre1 description"),
        2: Book(title="livre2", description="livre2 description"),
        3: Book(title="livre3", description="livre3 description"),
        4: Book(title="livre4", description="livre4 description"),
    }

    def __init__(self) -> None:
        print("Database connexion SUCCESS")

    def get_all_books(self) -> list[Book]:
        return list(self._books.values())

    def get_by_id(self, book_id: int) -> Book | None:
        return self._books.get(book_id)


async def get_db() -> FakeDB:
    return FakeDB()
