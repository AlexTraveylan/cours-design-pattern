package decorator;

import beverage.Beverage;

public abstract class CondimentDecorator extends Beverage {
    protected Beverage beverage;

    public Size getSize() {
        return beverage.getSize();
    }

    public abstract String getDescription();
}