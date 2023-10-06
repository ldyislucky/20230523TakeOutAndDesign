package com.ldy.mpp;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * @author : ldy
 * @version : 1.0
 * 注意： @ComponentScan({"com.ldy.mpp.service", "com.ldy.mpp.mapper"})，@MapperScan("com.ldy.mpp.mapper")
 *       以上2个注解缺一不可，一个是将类注册为bean，一个是将类与mybaties映射
 */
@ComponentScan({"com.ldy.mpp.service", "com.ldy.mpp.mapper"})
@MapperScan("com.ldy.mpp.mapper")
@SpringBootApplication
public class MppApplication {
    public static void main(String[] args) {
        SpringApplication.run(MppApplication.class,args);
    }
}
