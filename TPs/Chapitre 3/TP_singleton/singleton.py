class SingletonMeta(type):
    _instances = {}

    def __call__(cls, *args, **kwargs):
        if cls not in cls._instances:
            instance = super().__call__(*args, **kwargs)
            cls._instances[cls] = instance
        return cls._instances[cls]


class Singleton(metaclass=SingletonMeta):
    def __init__(self, value: int = 0) -> None:
        self._value = value

    def get_value(self) -> int:
        return self._value

    def set_value(self, value) -> None:
        self._value = value
