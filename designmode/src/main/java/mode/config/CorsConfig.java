package mode.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author : ldy
 * @version : 1.0
 */
@Configuration
public class CorsConfig implements WebMvcConfigurer{
    // 创建一个名为 corsConfigurer 的 Bean，并返回 WebMvcConfigurer 对象
    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            // 重写 addCorsMappings 方法，用于配置 CORS 规则
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/**")// 映射所有 URL 的跨域请求
                        .allowedOriginPatterns("*") // 允许所有来源
                        .allowedMethods("*") // 允许所有 HTTP 方法
                        .allowCredentials(true); // 允许发送凭证信息
            }
        };
    }
}
