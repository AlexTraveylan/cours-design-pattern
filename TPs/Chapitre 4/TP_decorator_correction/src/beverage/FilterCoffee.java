package beverage;

public class FilterCoffee extends Beverage {
    public FilterCoffee() {
        description = "Café Filtre";
    }

    @Override
    public double cost() {
        double baseCost = 1.49;
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