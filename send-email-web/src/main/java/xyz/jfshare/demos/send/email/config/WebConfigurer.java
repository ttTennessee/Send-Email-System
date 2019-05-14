package xyz.jfshare.demos.send.email.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import xyz.jfshare.demos.send.email.interceptor.AfterLoginInterceptor;
import xyz.jfshare.demos.send.email.interceptor.PreLoginInterceptor;

@Configuration
public class WebConfigurer implements WebMvcConfigurer{

    @Autowired
    private PreLoginInterceptor preLoginInterceptor;

    @Autowired
    private AfterLoginInterceptor afterLoginInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(preLoginInterceptor)
                .addPathPatterns("/user/**")
                .excludePathPatterns("/user/login","/user/register","/user/notLogin");
        registry.addInterceptor(afterLoginInterceptor)
                .addPathPatterns("/user/login","/user/notLogin");
    }
}
