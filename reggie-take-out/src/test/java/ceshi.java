import cn.hutool.json.JSON;
import cn.hutool.json.JSONUtil;
import com.ldy.reggie.ReggieApplication;
import com.ldy.reggie.entity.Employee;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.SetOperations;

import java.util.List;

/**
 * @author : ldy
 * @version : 1.0
 */
@SpringBootTest(classes = ReggieApplication.class)
public class ceshi {
    @Autowired
    private RedisTemplate<Object,Object> redisTemplate;
    @Test
    public void t1(){
        Employee employee = new Employee();
        employee.setUsername("admin");
        employee.setPassword("123456");
        String jsonStr = JSONUtil.toJsonStr(employee);
        System.out.println(jsonStr);
    }
    @Test
    public void t2(){
        SetOperations<Object, Object> operations = redisTemplate.opsForSet();
        operations.add("7","退钱！");
        System.out.println(operations.members("7"));
    }
}
