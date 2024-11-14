from typing import Annotated

from fastapi import Depends, FastAPI

from database import FakeDB, get_db

app = FastAPI()


@app.get("/books")
def get_books(db: Annotated[FakeDB, Depends(get_db)]):
    return db.get_all_books()


@app.get("/books/{item_id}")
def get_book_by_id(item_id: int, db: Annotated[FakeDB, Depends(get_db)]):
    return db.get_by_id(item_id)
