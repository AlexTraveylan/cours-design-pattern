package beverage;

public abstract class Beverage {
    protected String description = "Boisson inconnue";
    protected Size size = Size.MEDIUM;

    public enum Size {
        SMALL, MEDIUM, LARGE
    }

    public void setSize(Size size) {
        this.size = size;
    }

    public Size getSize() {
        return size;
    }

    public String getDescription() {
        return description + " " + size;
    }

    public abstract double cost();
}