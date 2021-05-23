package com.drivinggrpc.driving.tools;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.CacheControl;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MyMvcConfig implements WebMvcConfigurer {
    //所有的WebMvcConfigurerAdapter组件都会一起起作用
    /**
     * 配置静态访问资源
     *
     * @param registry
     */
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("classpath:/static/")//设置哪些静态资源不缓存   "/**/index.html",
                .addResourceLocations("classpath:/static/androidImage/","classpath:/static/images/")
                .setCacheControl(CacheControl.noStore());//用 noStore 才起效
    }

    @Bean //将组件注册在容器中
    public WebMvcConfigurer webMvcConfigurerAdapter(){
        return new WebMvcConfigurer(){
            //注册拦截器
            @Override
            public void addInterceptors(InterceptorRegistry registry) {
                //静态资源； *.css,*.js
                //SpringBoot已经做好了静态资源映射
//                registry.addInterceptor(new LoginHandlerInterceptor()).addPathPatterns("/**")
//                .excludePathPatterns("/index.html","/","/user/login","/static/**","/webjars/**");
                // /**  表示拦截所有路径下的所有请求
                registry.addInterceptor(new Interceptor())
                        .addPathPatterns("/**")
                .excludePathPatterns("/login","/sss","/static/**","/loginRequest",
                        "/user/register","/getVerCode","/forget-password",
                        "/androidImage/**","/images/**","/PhyTheFees");
            }
        };
    }
}
