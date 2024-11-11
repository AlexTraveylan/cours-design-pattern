from singleton import Singleton


def test_singleton_default_value():
    singleton = Singleton()
    assert singleton.get_value() == 0


def test_singleton_set_value():
    singleton = Singleton()
    singleton.set_value(10)

    assert singleton.get_value() == 10


def test_singleton_init_value():
    singleton = Singleton(42)
    assert singleton.get_value() == 42
