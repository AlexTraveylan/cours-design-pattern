package beverage;

public class Latte extends Beverage {
    public Latte() {
        description = "Latte";
    }

    @Override
    public double cost() {
        double baseCost = 2.99;
        switch (size) {
            case SMALL:
                return baseCost - 0.30;
            case LARGE:
                return baseCost + 0.30;
            default:
                return baseCost;
        }
    }
}