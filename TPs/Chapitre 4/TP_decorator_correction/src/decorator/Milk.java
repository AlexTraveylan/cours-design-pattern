package decorator;

import beverage.Beverage;

public class Milk extends CondimentDecorator {
    public Milk(Beverage beverage) {
        this.beverage = beverage;
    }

    @Override
    public String getDescription() {
        return beverage.getDescription() + ", Lait";
    }

    @Override
    public double cost() {
        return beverage.cost() + 0.50;
    }
}