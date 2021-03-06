package com.zimug.bootlaunch.controller;

import com.zimug.bootlaunch.entity.User;
import com.zimug.bootlaunch.mapper.UserMapper;
import com.zimug.bootlaunch.model.AjaxResponse;
import com.zimug.bootlaunch.service.UserService;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Slf4j
@RestController
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@RequestMapping("/rest")
public class UserRestController {

    // 操作数据通用流程：
    // Controller class -> Service interface -> Service impl class
    // -> Mapper inteface --> Mapper.xml-> database

    // @Autowired 注解，自动装载 Service inteface
    @Autowired
    private UserService userService;

    // 使用 @Resource 注解 , 在 Controller class 里可直接调用 Mapper interface
    // 省去写 Service interface 与 Service impl class
    @Resource
    private UserMapper userMapper;

    // 查所有
    @GetMapping("/users")
    public AjaxResponse getAllUsers() {
        // List<User> users = userService.getUsers(); // 通用流程 Controller 调用 Service 接口
        List<User> users = userMapper.selectAllUser(); // Controller 里直接调用 Mapper 接口
        return  AjaxResponse.success(users);
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

        // Entity类中使用@JsonFormat注解生成 将实例类中的 createTime 转换成字符串类型，
        // 与Controller 参数类型保持一致，与数据库插入参数一样
        SimpleDateFormat sdf =new SimpleDateFormat("yyyy-MM-dd HH:mm:ss" );
        user.setCreateTime(sdf.format(new Date())); // 当前日期换成指定格式与数据库保持一致

        //因为使用了lombok的Slf4j注解，这里可以直接使用log变量打印日志
        log.info("updateUser： {}", user);

        int retVal = userService.updateUser(user); // 返回影响行数
        log.info("retVal： {}", retVal);

        return AjaxResponse.success(user);
    }

}