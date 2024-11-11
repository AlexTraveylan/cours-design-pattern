// Interface Prototype
interface Clonable {
    Clonable clone();
}

// Classe concrète qui implémente Clonable
class Shape implements Clonable {
    private String type;

    Shape(String type) {
        this.type = type;
    }

    @Override
    public Clonable clone() {
        return new Shape(this.type);
    }
}

// Utilisation du Prototype
public class PrototypeDemo {
    public static void main(String[] args) {
        Shape circle = new Shape("Circle");

        Shape clonedCircle = (Shape) circle.clone();
        System.out.println(clonedCircle);
    }
}