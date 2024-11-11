// Define the Visitor interface
interface Visitor {
    void visit(Circle circle);

    void visit(Rectangle rectangle);
}

// Define the Element interface
interface Element {
    void accept(Visitor visitor);
}

// Implement ConcreteElement classes
class Circle implements Element {
    private double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    public double getRadius() {
        return radius;
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}

class Rectangle implements Element {
    private double width;
    private double height;

    public Rectangle(double width, double height) {
        this.width = width;
        this.height = height;
    }

    public double getWidth() {
        return width;
    }

    public double getHeight() {
        return height;
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}

// Implement a ConcreteVisitor
class AreaCalculator implements Visitor {
    @Override
    public void visit(Circle circle) {
        double area = Math.PI * Math.pow(circle.getRadius(), 2);
        System.out.println("Circle area: " + area);
    }

    @Override
    public void visit(Rectangle rectangle) {
        double area = rectangle.getWidth() * rectangle.getHeight();
        System.out.println("Rectangle area: " + area);
    }
}

// Main execution class
public class VisitorExample {
    public static void main(String[] args) {
        // Create an array of elements
        Element[] elements = {
                new Circle(5),
                new Rectangle(4, 6)
        };

        // Create a visitor
        Visitor areaCalculator = new AreaCalculator();

        // Use the visitor to calculate areas
        for (Element element : elements) {
            element.accept(areaCalculator);
        }
    }
}