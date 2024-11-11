package beverage;

public class Espresso extends Beverage {
    public Espresso() {
        description = "Espresso";
    }

    @Override
    public double cost() {
        double baseCost = 1.99;
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