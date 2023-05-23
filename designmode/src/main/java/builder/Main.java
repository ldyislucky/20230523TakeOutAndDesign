package builder;

/**
 * @author : ldy
 * @version : 1.0
 */
public class Main {
  public static void main(String[] args) {
    ComputerBuilder highConfigComputerBuilder = new HighConfigComputerBuilder();
    Director director = new Director(highConfigComputerBuilder);
    director.constructComputer();
    System.out.println(highConfigComputerBuilder.createComputer());

    ComputerBuilder lowConfigComputerBuilder = new LowConfigComputerBuilder();
    Director director1 = new Director(lowConfigComputerBuilder);
    director1.constructComputer();
    Computer computer = lowConfigComputerBuilder.createComputer();
    System.out.println(computer);
  }
}
