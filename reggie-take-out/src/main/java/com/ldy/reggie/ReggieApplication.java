package com.ldy.reggie;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author : ldy
 * @version : 1.0
 */
@Slf4j//来自于lombok
@SpringBootApplication
public class ReggieApplication {
  public static void main(String[] args) {
    SpringApplication.run(ReggieApplication.class,args);
    log.info("项目启动成功");
  }
}
