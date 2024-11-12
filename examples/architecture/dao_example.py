from dataclasses import dataclass


@dataclass
class User:
    user_id: int
    name: str
    email: str


class UserDAO:
    def __init__(self) -> None:
        self._users = self.get_data()

    def get_data(self) -> dict[int, User]:
        # Fake récupération des données
        return {
            1: User(1, "Alice", "alice@example.com"),
            2: User(2, "Bob", "bob@example.com"),
            3: User(3, "Charlie", "charlie@example.com"),
        }

    def get_user_by_id(self, user_id: int) -> User | None:
        return self._users.get(user_id)

    def get_all_users(self) -> list[User]:
        return list(self._users.values())


# Utilisation du DAO pour accéder aux données
def run():
    user_dao = UserDAO()

    # Récupérer un utilisateur par ID
    user = user_dao.get_user_by_id(1)
    if user:
        print("User found:", user)
    else:
        print("User not found.")

    # Récupérer tous les utilisateurs
    all_users = user_dao.get_all_users()
    print("All users:", all_users)


if __name__ == "__main__":
    run()
