package Decorator;

/**
 * @author : ldy
 * @version : 1.0
 */
abstract class CoffeeDecorator implements Coffee {
    private Coffee coffee;

    public CoffeeDecorator(Coffee coffee) {
        this.coffee = coffee;
    }

    @Override
    public String getDescription() {
        return coffee.getDescription();
    }

    @Override
    public double getCost() {
        return coffee.getCost();
    }

    @Override
    public String toString() {
        return "CoffeeDecorator{" +
                "coffee=" + coffee +
                '}';
    }
}
