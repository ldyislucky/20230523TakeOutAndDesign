import com.ldy.mpp.MppApplication;
import com.ldy.mpp.controller.UserContrller;
import com.ldy.mpp.domain.query.UserQuery;
import com.ldy.mpp.entity.User;
import com.ldy.mpp.mapper.UserMapper;
import com.ldy.mpp.service.UserService;
import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

/**
 * @author : ldy
 * @version : 1.0
 */
@SpringBootTest(classes = MppApplication.class)//需要引入括号中的配置类，否则会自动装配失败
//@RequiredArgsConstructor  测试中好像用不了这个注解，只能用@Autowired
public class tt {
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private UserContrller userContrller;
    @Autowired
    private UserService userService;
    @Test
    public void t1(){
        userMapper.selectById("5");
    }
    @Test
    public void t2(){
        UserQuery userQuery = new UserQuery();
        userQuery.setStatus(2);
        List<User> users = userContrller.queryUsers(userQuery);
        users.forEach(System.out::println);
    }
}
