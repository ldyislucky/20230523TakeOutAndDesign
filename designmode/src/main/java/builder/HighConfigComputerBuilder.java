package builder;

/**
 * @author : ldy
 * @version : 1.0
 */
public class HighConfigComputerBuilder implements ComputerBuilder{

    private Computer computer;

    public HighConfigComputerBuilder() {
        computer = new Computer();
    }

    @Override
    public void setCPU() {
        computer.setCPU("Intel i7");
    }

    @Override
    public void setMemory() {
        computer.setMemory("16GB");
    }

    @Override
    public void setHardDisk() {
        computer.setHardDisk("512GB SSD");
    }

    @Override
    public Computer createComputer() {
        return computer;
    }
}
