import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Observable;

/**
 * @author : ldy
 * @version : 1.0
 */
//@SpringBootTest
public class t {
  @Test
  public void t1(){
    Observable observable = new Observable();
    System.out.println(observable);
  }
  @Test
  public void t2(){
    ArrayList<String> strings = new ArrayList<>();
    strings.add("1");
    strings.add("2");
    strings.add("1");
    strings.add("4");

    for (String str : strings){
      int i = Integer.valueOf(str);
      if (i%2==0){
        strings.remove(str);
      }

    }
  }
  @Test
  public void t3(){
    SimpleDateFormat formater = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    String date = formater.format(new Date( 2023+0,9 + 0,  20));
    System.out.println(date);
  }

  @Test
  public void t4(){
    SimpleDateFormat formater = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    String date = formater.format(new Date( 2023,9,  20));
    System.out.println(date);
  }
}
