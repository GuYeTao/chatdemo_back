package com.laoxianghao.shop.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MyWebMvcConfig implements WebMvcConfigurer {


    @Value("${file.uploadPath}")
    private String uploadPath;

    /**
     * 配置资源访问
     *
     * @param registry
     */
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        // 静态资源---图片url地址
        registry.addResourceHandler("/pic/**").addResourceLocations("file:///" + uploadPath);
    }
}