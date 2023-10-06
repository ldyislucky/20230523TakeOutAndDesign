package com.ldy.mpp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * @author : ldy
 * @version : 1.0
 */
@ComponentScan({"com.ldy.mpp.service", "com.ldy.mpp.mapper"})
@SpringBootApplication
public class MppApplication {
    public static void main(String[] args) {
        SpringApplication.run(MppApplication.class,args);
    }
}
