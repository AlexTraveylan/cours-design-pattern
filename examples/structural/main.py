# Interface cible que l'application connaît et utilise
class Target:
    def request(self):
        return "Target: The default target's behavior."


# Classe existante avec une interface incompatible
class Adaptee:
    def specific_request(self):
        return ".ecnatsiseru tekcollet A"


# L'Adapter permet à Adaptee d'être compatible avec Target
class Adapter(Target):
    def __init__(self, adaptee: Adaptee):
        self._adaptee = adaptee

    def request(self):
        # Adapter convertit l'interface d'Adaptee à celle de Target
        return f"Adapter: (TRANSLATED) {self._adaptee.specific_request()[::-1]}"


# Client code
def client_code(target: Target):
    print(target.request())


# Utilisation sans adaptation
target = Target()
client_code(target)

# Adaptation de l'Adaptee pour qu'il soit utilisable où Target est requis
adaptee = Adaptee()
adapter = Adapter(adaptee)
client_code(adapter)