package mode.design.Decorator;

/**
 * @author : ldy
 * @version : 1.0
 */
public class AmericanoCoffee implements Coffee {
    @Override
    public String getDescription() {
        return "美式咖啡";
    }

    @Override
    public double getCost() {
        return 3;
    }
}
