package decorator;

import beverage.Beverage;

public class Whip extends CondimentDecorator {
    public Whip(Beverage beverage) {
        this.beverage = beverage;
    }

    @Override
    public String getDescription() {
        return beverage.getDescription() + ", Crème fouettée";
    }

    @Override
    public double cost() {
        return beverage.cost() + 0.50;
    }
}