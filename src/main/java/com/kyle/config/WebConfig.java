package com.kyle.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.*;

/**
 * project name   :blog-01
 * project version:1.0
 *
 * @author :KyleChyan https://github.com/KyleChyan
 * @date :2022/6/23,20:13,星期四
 */
@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addInterceptors(InterceptorRegistry interceptorRegistry) {
        interceptorRegistry.addInterceptor(new LoginInterceptor()).addPathPatterns("/admin/##")
                .excludePathPatterns("/admin/gologin","/admin/login");

    }
}
