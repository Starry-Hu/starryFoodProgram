package com.practice.starryfood;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;

@ServletComponentScan
@ComponentScan(basePackages = {"com.practice.starryfood","com.practice.starryfood.handle"})
@SpringBootApplication
@MapperScan(basePackages = {"com.practice.starryfood.dao","com.practice.starryfood.daoExtend"})
public class StarryfoodApplication extends SpringBootServletInitializer {

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        // TODO Auto-generated method stub
        return builder.sources(StarryfoodApplication.class);
    }

    public static void main(String[] args) {
        SpringApplication.run(StarryfoodApplication.class, args);
    }

}
