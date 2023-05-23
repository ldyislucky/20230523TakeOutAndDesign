package builder;

/**
 * @author : ldy
 * @version : 1.0
 */
public interface ComputerBuilder {
    void setCPU() ;

    void setMemory() ;

    void setHardDisk();

    Computer createComputer();

}
