import com.ldy.mpp.MppApplication;
import com.ldy.mpp.mapper.UserMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @author : ldy
 * @version : 1.0
 */
@SpringBootTest(classes = MppApplication.class)//需要引入括号中的配置类，否则会自动装配失败
public class tt {
    @Autowired
    private UserMapper userMapper;
    @Test
    public void t1(){
        userMapper.selectById("5");
    }
}
