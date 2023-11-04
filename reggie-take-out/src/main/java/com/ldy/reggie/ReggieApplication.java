package com.ldy.reggie;

import lombok.extern.slf4j.Slf4j;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScans;
import org.springframework.stereotype.Component;

/**
 * @author : ldy
 * @version : 1.0
 */

@SpringBootApplication
@ComponentScan({"com.ldy.reggie.config","com.ldy.reggie.mapper","com.ldy.reggie.service","com.ldy.reggie.controller"})
@MapperScan("com.ldy.reggie.mapper")
@ServletComponentScan//让过滤器生效的配置
public class ReggieApplication {
  public static void main(String[] args) {
    SpringApplication.run(ReggieApplication.class,args);
  }
}
