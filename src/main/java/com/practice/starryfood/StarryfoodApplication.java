package com.practice.starryfood;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan(basePackages = {"com.practice.starryfood","com.practice.starryfood.handle"})
@SpringBootApplication
@MapperScan(basePackages = {"com.practice.starryfood.dao","com.practice.starryfood.daoExtend"})
public class StarryfoodApplication {

    public static void main(String[] args) {
        SpringApplication.run(StarryfoodApplication.class, args);
    }

}
