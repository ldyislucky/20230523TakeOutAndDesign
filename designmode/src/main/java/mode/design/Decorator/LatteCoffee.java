package mode.design.Decorator;

/**
 * @author : ldy
 * @version : 1.0
 */
public class LatteCoffee implements Coffee {
    @Override
    public String getDescription() {
        return "拿铁咖啡";
    }

    @Override
    public double getCost() {
        return 4;
    }
}
