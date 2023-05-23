package builder;


/**
 * @author : ldy
 * @version : 1.0
 */
public class Director {

    private ComputerBuilder builder;

    public Director(ComputerBuilder builder){
        this.builder = builder;
    }

    public void constructComputer(){
        builder.setCPU();
        builder.setMemory();
        builder.setHardDisk();
    }
}
