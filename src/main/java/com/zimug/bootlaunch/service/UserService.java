package com.zimug.bootlaunch.service;

import com.zimug.bootlaunch.entity.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {

    List<User> getUsers();

    // 此处 User 指实体类， 所有用户的类型为 List<User>， 每一个类型为 User， 控制器->service->serviceimpl-> 注意类型一定要对应
    User getUsersById(Long id);

    int deleteUserById(Long id);

    int saveUser(User user);

    int updateUser(User user);

}