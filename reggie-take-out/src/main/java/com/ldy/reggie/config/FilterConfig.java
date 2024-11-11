//package com.ldy.reggie.config;
//
//import com.ldy.reggie.filter.LoginCheckFilter;
//import com.ldy.reggie.filter.TestFilter;
//import org.springframework.boot.web.servlet.FilterRegistrationBean;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
///**
// * 配置过滤器的执行顺序
// */
//@Configuration
//public class FilterConfig {
//    @Bean
//    public FilterRegistrationBean<TestFilter> filter1Registration() {
//        FilterRegistrationBean<TestFilter> registration = new FilterRegistrationBean<>();
//        registration.setFilter(new TestFilter());
//        registration.addUrlPatterns("/*");
//        registration.setOrder(1);  // 设置优先级
//        return registration;
//    }
//
//    @Bean
//    public FilterRegistrationBean<LoginCheckFilter> filter2Registration() {
//        FilterRegistrationBean<LoginCheckFilter> registration = new FilterRegistrationBean<>();
//        registration.setFilter(new LoginCheckFilter());
//        registration.addUrlPatterns("/*");
//        registration.setOrder(2);  // 设置优先级
//        return registration;
//    }
//
//}
