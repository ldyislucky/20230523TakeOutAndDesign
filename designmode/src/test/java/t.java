import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Observable;

/**
 * @author : ldy
 * @version : 1.0
 */
@SpringBootTest
public class t {
  @Test
  public void t1(){
    Observable observable = new Observable();
    System.out.println(observable);
  }
}
