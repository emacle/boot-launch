package com.zimug.bootlaunch.controller; // 此处controller 为 package 名

import com.zimug.bootlaunch.model.Article;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

// 1. 新建控制器文件夹 com.zimug.bootlaunch  New-> _Package_ (controller/)
// 2. 新建控制器类 controller/ 右键-> New -> Java Class
//    手动输入 @RestController 回车后 自动引入
//    import org.springframework.web.bind.annotation.RestController;
//    手动输入 @RequestMapping("/hello")  回车后 自动引入
//    import org.springframework.web.bind.annotation.RequestMapping;


@Slf4j // lombok logger

@RestController
public class HelloController {

    @RequestMapping("/hello")
    public String hello() {
        Article article =  new Article(1L, "zimuge");
        // 输入 Article 回车，自动引入 import  com.zimug.bootlaunch.model.Article; 包

        // return article.getAuthor();

        article.setAuthor("字母哥");  // @Data set,get
        //  return article.getAuthor();

        Article article1 = Article.builder().id(2L).author("莫言").build();

        log.info("测试一下"+ article1);
        return article1.getAuthor();

    }

}