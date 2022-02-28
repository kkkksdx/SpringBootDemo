package com.demo;

import com.demo.interceptor.MyInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

//@Configuration//配置类
public class InterceptorConfig implements WebMvcConfigurer {
    public void addInterceptors(org.springframework.web.servlet.config.annotation.InterceptorRegistry registry) {
        /* compiled code */
        registry.addInterceptor(new MyInterceptor()).addPathPatterns("/**").excludePathPatterns("/","/bootstrap/**","/lyear/**","/js/**","/images/**","/login/verifyLogin","/login/loginVerifyUsername/**");
    }
}
