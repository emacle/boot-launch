package com.zimug.bootlaunch.service;


import com.zimug.bootlaunch.entity.User;
import com.zimug.bootlaunch.mapper.UserMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Resource
    private UserMapper userMapper;

    @Override
    public List<User> getUsers() {
        List<User> userList = userMapper.selectAllUser();
        return userList;
    }

    @Override
    public User getUsersById(Long id) {
        User userList = userMapper.selectUserById(id);

        return userList;
    }

    @Override
    public int deleteUserById(Long id) {
        int retVal = userMapper.deleteById(id);

        return retVal;
    }

    @Override
    public int saveUser(User user) {
        int retVal = userMapper.saveUser(user);

        return retVal;
    }


    @Override
    public int updateUser(User user) {
        int retVal = userMapper.updateUser(user);

        return retVal;
    }
}