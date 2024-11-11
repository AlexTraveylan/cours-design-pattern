// Abstraction
abstract class Shape {
    protected Color color;

    protected Shape(Color color) {
        this.color = color;
    }

    abstract void draw();
}

// Refined Abstraction
class Circle extends Shape {
    public Circle(Color color) {
        super(color);
    }

    @Override
    void draw() {
        System.out.print("Drawing Circle in ");
        color.applyColor();
    }
}

// Implementor
interface Color {
    void applyColor();
}

// Concrete Implementor
class RedColor implements Color {
    @Override
    public void applyColor() {
        System.out.println("Red.");
    }
}

// Concrete Implementor
class BlueColor implements Color {
    @Override
    public void applyColor() {
        System.out.println("Blue.");
    }
}

// Client code to test the pattern
public class BridgePatternDemo {
    public static void main(String[] args) {
        Shape redCircle = new Circle(new RedColor());
        Shape blueCircle = new Circle(new BlueColor());

        redCircle.draw(); // Output: Drawing Circle in Red.
        blueCircle.draw(); // Output: Drawing Circle in Blue.
    }
}