package com.caitou.mybatisplus.config;

import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 功能描述：mybatis-plus插件分页配置类
 *
 * @Author Mr.caitou
 * @Email 1049976610@qq.com
 * @Date 2019/11/18 14:07
 */
@Configuration
public class MybatisPlusConfig {

    @Bean
    public PaginationInterceptor paginationInterceptor() {
        return new PaginationInterceptor();
    }
}
