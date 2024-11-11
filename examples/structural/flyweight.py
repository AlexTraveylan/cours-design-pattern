class Circle:
    def __init__(self, color):
        self.color = color

    def draw(self, x, y, radius):
        print(
            f"Drawing circle of color {self.color} at ({x}, {y}) with radius {radius}"
        )


class CircleFactory:
    _circles = {}

    @classmethod
    def get_circle(cls, color):
        if color not in cls._circles:
            cls._circles[color] = Circle(color)
            print(f"Creating new circle of color {color}")
        else:
            print(f"Reusing existing circle of color {color}")
        return cls._circles[color]


def main():
    colors = ["Red", "Green", "Blue", "Red", "Green", "Blue"]
    positions = [(10, 20), (30, 40), (50, 60), (70, 80), (90, 100), (110, 120)]
    radius = [5, 10, 15, 20, 25, 30]

    for i in range(len(colors)):
        circle = CircleFactory.get_circle(colors[i])
        circle.draw(positions[i][0], positions[i][1], radius[i])


if __name__ == "__main__":
    main()
