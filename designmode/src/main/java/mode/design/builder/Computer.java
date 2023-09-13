package mode.design.builder;

/**
 * @author : ldy
 * @version : 1.0
 */
public class Computer {
    private String CPU;
    private String memory;
    private String hardDisk;

    public void setCPU(String cpu) {
        this.CPU = cpu;
    }

    public void setMemory(String memory) {
        this.memory = memory;
    }

    public void setHardDisk(String hardDisk) {
        this.hardDisk = hardDisk;
    }

    @Override
    public String toString() {
        return "Computer{" +
                "CPU='" + CPU + '\'' +
                ", memory='" + memory + '\'' +
                ", hardDisk='" + hardDisk + '\'' +
                '}';
    }
}
