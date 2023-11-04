package com.ldy.reggie.filter;


import com.alibaba.fastjson.JSON;
import com.ldy.reggie.common.R;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.util.AntPathMatcher;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 拦截不是登录状态的请求
 */
@Slf4j
@WebFilter(filterName = "loginCheckFilter",urlPatterns = "/*")
//@Order(1)//不清楚为啥，球用没有
public class LoginCheckFilter implements Filter {
    /**
     * 用于匹配带通配符的路径
     */
    private static final AntPathMatcher ANT_PATH_MATCHER = new AntPathMatcher();

    @Override
    public void doFilter(ServletRequest servletRequest,
                         ServletResponse servletResponse,
                         FilterChain filterChain) throws IOException, ServletException {
        log.info("登录过滤器执行！");
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        //含地址和端口号的全量请求路径
        StringBuffer requestURL = request.getRequestURL();
        //不含地址和端口号的请求路径
        String requestURI = request.getRequestURI();
        String[] usis = new String[]{
                "/employee/login",
                "/employee/logout",
                "static/**"
        };
        if (check(usis,requestURI)){
            filterChain.doFilter(request,response);
            return;
        }
        if (request.getSession().getAttribute("username")!=null){
            filterChain.doFilter(request,response);
            return;
        }
        response.getWriter().write(JSON.toJSONString(R.error("NOTLOGIN")));
    }
    public boolean check(String[] urls,String requestURI){
        for (String url : urls){
            boolean match = ANT_PATH_MATCHER.match(url, requestURI);
            if (match){
                return match;
            }
        }
        return false;
    }
}
