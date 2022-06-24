package com.kyle.service.impl;

import com.kyle.mapper.UserMapper;
import com.kyle.pojo.User;
import com.kyle.service.UserService;
import org.apache.tomcat.util.security.MD5Encoder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * project name   :blog-01
 * project version:1.0
 *
 * @author :KyleChyan https://github.com/KyleChyan
 * @date :2022/6/15,16:15,星期三
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;

    @Override
    public User checkUser(String username, String password) {
        return userMapper.checkUser(username, password);
    }
}
