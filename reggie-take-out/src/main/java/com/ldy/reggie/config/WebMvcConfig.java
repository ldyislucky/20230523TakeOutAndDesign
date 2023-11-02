package com.ldy.reggie.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

/**
 * @author : ldy
 * @version : 1.0
 */
@Slf4j
@Configuration
public class WebMvcConfig extends WebMvcConfigurationSupport {
    /**
     * 设置静态资源映射
     * 其实把前端的静态资源放在resources的static之中之后，就能够做到静态资源映射了，但是除了
     * index页面，其它页面的路径都需要加上static
     * 这个配置类就没啥用了，在这里就是熟悉一下不放在static中的开发方式，知道有折磨回事儿
     */
    @Override
    protected void addResourceHandlers(ResourceHandlerRegistry registry) {
        /**
         * Handlers 操作者
         * Registry 注册、登记
         */
        log.info("开始静态资源映射");
        registry.addResourceHandler("backend/**").addResourceLocations("classpath:/backend/");
        registry.addResourceHandler("front/**").addResourceLocations("classpath:/front/");
    }
}
