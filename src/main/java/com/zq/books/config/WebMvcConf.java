package com.zq.books.config;


import com.zq.books.security.SecurityInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.config.annotation.InterceptorRegistration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

/**
 * @description: description
 * @author: tangYiLong
 * @create: 2018-05-16 15:25
 **/
//@Configuration
public class WebMvcConf extends WebMvcConfigurationSupport {

    @Autowired
    SecurityInterceptor securityInterceptor;

    @Override
    protected void addInterceptors(InterceptorRegistry registry) {
        InterceptorRegistration interceptor = registry.addInterceptor(securityInterceptor);
        // 排除路径
        interceptor.excludePathPatterns("/auth/**");
        interceptor.excludePathPatterns("/swagger-ui.html");
        //拦截路径
        interceptor.addPathPatterns("/book/**");
    }

}
