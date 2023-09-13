package mode.design.Decorator;

/**
 * @author : ldy
 * @version : 1.0
 */
public class SugarDecorator extends CoffeeDecorator {

    public SugarDecorator(Coffee coffee) {
        super(coffee);
    }

    @Override
    public String getDescription() {
        return super.getDescription()+"加糖";
    }

    @Override
    public double getCost() {
        return super.getCost()+0.5;
    }

}
