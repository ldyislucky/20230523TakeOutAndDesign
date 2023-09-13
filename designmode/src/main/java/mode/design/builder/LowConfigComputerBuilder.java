package mode.design.builder;

/**
 * @author : ldy
 * @version : 1.0
 */
public class LowConfigComputerBuilder implements ComputerBuilder {
    private Computer computer;

    public LowConfigComputerBuilder(){
        computer = new Computer();
    }

    @Override
    public void setCPU() {
        computer.setCPU("Intel Celeron");
    }

    @Override
    public void setMemory() {
        computer.setMemory("4GB");
    }

    @Override
    public void setHardDisk() {
        computer.setHardDisk("128GB SSD");
    }

    @Override
    public Computer createComputer() {
        return computer;
    }
}
