package com.zimug.bootlaunch.controller;

import com.zimug.bootlaunch.model.AjaxResponse;
import com.zimug.bootlaunch.model.Article;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@Data
@Slf4j
@RestController

@RequestMapping("/rest")
public class ArticleRestController {

    @ApiOperation(value="添加文章", notes="添加新的文章",tags = "Article", httpMethod = "POST")
    @ApiResponses({
            @ApiResponse(code=200,message="成功",response = AjaxResponse.class),
            @ApiResponse(code=400,message="用户输入错误",response = AjaxResponse.class)
    })

    // RequestMapping() , 可以简化成  @PostMapping, @GetMapping @PutMapping @DeleteMapping等方法

    //增加一篇Article ，使用POST方法
    //  @RequestMapping(value = "/article", method = RequestMethod.POST, produces = "application/json")

    @PostMapping("/article")
    public AjaxResponse saveArticle(@RequestBody Article article) {
        // TODO: 写入数据库
        //因为使用了lombok的Slf4j注解，这里可以直接使用log变量打印日志
        log.info("saveArticle：{}", article);
        return  AjaxResponse.success(article);
    }

    //删除一篇Article，使用DELETE方法，参数是id
    //    @RequestMapping(value = "/article/{id}", method = RequestMethod.DELETE, produces = "application/json")
    @DeleteMapping("/article/{id}")
    public AjaxResponse deleteArticle(@PathVariable Long id) {
        log.info("deleteArticle：{}",id);
        return AjaxResponse.success(id);
    }
 
     //更新一篇Article，使用PUT方法，以id为主键进行更新
    //    @RequestMapping(value = "/article/{id}", method = RequestMethod.PUT, produces = "application/json")
    @PutMapping("/article/{id}")
    public AjaxResponse updateArticle(@PathVariable Long id, @RequestBody Article article) {
        article.setId(id);
        log.info("updateArticle：{}",article);
        return AjaxResponse.success(article);
    }
 
    //获取一篇Article，使用GET方法
    //  @RequestMapping(value = "/article/{id}", method = RequestMethod.GET, produces = "application/json")
    @GetMapping("/article/{id}")
    public AjaxResponse getArticle(@PathVariable Long id) {

        //使用lombok提供的builder构建对象
        Article article1 = Article.builder()
                                .id(1L)
                                .author("zimug")
                                .content("spring boot 2.深入浅出")
                                .createTime(new Date())
                                .title("t1").build();
        log.info("GetArticle：{}",article1);
        return AjaxResponse.success(article1);
    }
}