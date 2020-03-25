package com.zimug.bootlaunch.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

// 1. 新建控制器文件夹 com.zimug.bootlaunch  New-> _Package_ (controller/)
// 2. 新建控制器类 controller/ 右键-> New -> Java Class
//    手动输入 @RestController 回车后 自动引入
//    import org.springframework.web.bind.annotation.RestController;
//    手动输入 @RequestMapping("/hello")  回车后 自动引入
//    import org.springframework.web.bind.annotation.RequestMapping;

@RestController
public class HelloController {

    @RequestMapping("/hello")
    public String hello(String name) {
        return "hello world, " + name;
    }

}