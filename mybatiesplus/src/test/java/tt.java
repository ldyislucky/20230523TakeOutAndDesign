import com.baomidou.mybatisplus.core.metadata.OrderItem;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.ldy.mpp.MppApplication;
import com.ldy.mpp.controller.UserController;
import com.ldy.mpp.controller.UsersController;
import com.ldy.mpp.domain.query.UserQuery;
import com.ldy.mpp.entity.User;
import com.ldy.mpp.entity.Users;
import com.ldy.mpp.mapper.UsersMapper;
import com.ldy.mpp.service.IAddressTestService;
import com.ldy.mpp.service.IUserService;
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
    private UsersMapper usersMapper;
    @Autowired
    private UsersController usersController;
    @Autowired
    private IAddressTestService iAddressTestService;
    @Autowired
    private UserController userController;
    @Autowired
    private IUserService userService;
    @Test
    public void t1(){
        usersMapper.selectById("5");
    }
    @Test
    public void t2(){
        UserQuery userQuery = new UserQuery();
        userQuery.setStatus(2);
        List<Users> users = usersController.queryUsers(userQuery);
        users.forEach(System.out::println);
    }
    @Test
    public void t3(){
        iAddressTestService.getById(66);
    }
    @Test
    public void t4(){
        userController.getUserVo(1);
    }

    @Test
    public void t5(){
        int pageNo = 1, pageSize = 5;
        // 分页参数
        Page<User> page = Page.of(pageNo, pageSize);
        // 排序参数, 通过OrderItem来指定
        page.addOrder(new OrderItem("id", false));
        userService.page(page);

    }
    @Test
    public void t6(){
        int pageNo = 3, pageSize = 5;
        // 分页参数
        Page<User> page = Page.of(pageNo, pageSize);
        // 排序参数, 通过OrderItem来指定
        page.addOrder(new OrderItem("id", false));
        userService.page(page);
        List<User> users = page.getRecords();
        users.forEach(System.out::println);

    }


}
