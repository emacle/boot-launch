package com.zimug.bootlaunch.controller;

import com.zimug.bootlaunch.entity.User;
import com.zimug.bootlaunch.model.AjaxResponse;
import com.zimug.bootlaunch.service.UserService;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@RequestMapping("/rest")
public class UserRestController {

    @Autowired
    private UserService userService;

    // 查所有
    @GetMapping("/users")
    public AjaxResponse getAllUsers() {
        List<User> article = userService.getUsers();
        return  AjaxResponse.success(article);
    }

    // 查指定
    @GetMapping("/users/{id:\\d+}")
    public AjaxResponse getUserById(@PathVariable("id") Long id) {
        // log.info("GetArticle：{}",article1);
        log.info("seleteUsers： {}", id);  //  logi.info必须带有 {} 才能输出参数
        User user = userService.getUsersById(id);
        return AjaxResponse.success(user);
    }

    // 删
    @DeleteMapping("/users/{id}")
    public AjaxResponse deleteArticle(@PathVariable Long id) {
        log.info("deleteUsers： {}",id);
        int retVal = userService.deleteUserById(id); // 返回影响行数
        return AjaxResponse.success(retVal);
    }

    // 增
    @PostMapping("/users")
    public AjaxResponse saveUser(@RequestBody User user) {

        //因为使用了lombok的Slf4j注解，这里可以直接使用log变量打印日志
        log.info("saveUser： {}", user);
        int retVal = userService.saveUser(user); // 返回影响行数
        log.info("retVal： {}", retVal);

        return AjaxResponse.success(user);
    }

    // 更新 主键ID 位于RequestBody 里，如下，更新id=4的记录
    //    {
    //        "id": 4,
    //        "name": "wrold",
    //        "password": "aaaaa"
    //    }
    // **** 注意 mapper.xml文件里面 因为传递过去的参数是 User 对象，所以需要取出正确的值 user.id, user.name 等
    //        <update id="updateUser">
    //    update orm_user
    //    set `name` = #{user.name},
    //            `password` = #{user.password}
    //    where id = #{user.id}
    //    </update>
    @PutMapping("/users")
    public AjaxResponse updateUser(@RequestBody User user) {
        // entiy 中的 @Data 注解修改某些值
        user.setEmail("ok@qq.com");

        //因为使用了lombok的Slf4j注解，这里可以直接使用log变量打印日志
        log.info("updateUser： {}", user);

        int retVal = userService.updateUser(user); // 返回影响行数
        log.info("retVal： {}", retVal);


        return AjaxResponse.success(user);
    }

}