package com.zimug.bootlaunch;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

// Spring boot 入口文件
@SpringBootApplication
@MapperScan(basePackages = {"com.zimug.bootlaunch.mapper"})

public class BootLaunchApplication {

    public static void main(String[] args) {
        SpringApplication.run(BootLaunchApplication.class, args);
    }

}
