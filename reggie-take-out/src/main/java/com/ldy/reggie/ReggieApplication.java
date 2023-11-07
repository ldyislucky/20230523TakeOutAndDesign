package com.ldy.reggie;


import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.annotation.ComponentScan;

/**
 * @author : ldy
 * @version : 1.0
 */

@SpringBootApplication
@ComponentScan({"com.ldy.reggie.config","com.ldy.reggie.mapper","com.ldy.reggie.service","com.ldy.reggie.controller","com.ldy.reggie.common"})
@MapperScan("com.ldy.reggie.mapper")
@ServletComponentScan//让过滤器生效的配置
public class ReggieApplication {
  public static void main(String[] args) {
    SpringApplication.run(ReggieApplication.class,args);
  }
}
