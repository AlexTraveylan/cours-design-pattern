from controller import BookController
from model import BookModel
from view import BookView


def main():
    model = BookModel()
    view = BookView()
    controller = BookController(model, view)

    while True:
        action = input(
            "Enter 'add' to add a book or 'list' to show books or 'exit' to quit: "
        )

        if action == "add":
            controller.request_new_book()
        elif action == "list":
            controller.show_books()
        elif action == "exit":
            break
        else:
            print("Invalid action. Please enter 'add', 'list', or 'exit'.")


if __name__ == "__main__":
    main()
