package mode.design.Decorator;

/**
 * @author : ldy
 * @version : 1.0
 */
public class Main {
  public static void main(String[] args) {
    Coffee coffee = new AmericanoCoffee();
    SugarDecorator sugarDecorator = new SugarDecorator(coffee);
    System.out.println(sugarDecorator.getDescription());
    System.out.println(sugarDecorator.getCost());

    LatteCoffee latteCoffee = new LatteCoffee();
    MilkDecorator milkDecoratorLatteCoffee = new MilkDecorator(latteCoffee);
    System.out.println(milkDecoratorLatteCoffee.getDescription());
    System.out.println(milkDecoratorLatteCoffee.getCost());

  }
}
