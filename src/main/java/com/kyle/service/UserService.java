package com.kyle.service;

import com.kyle.pojo.User;
import org.springframework.util.DigestUtils;

/**
 * project name   :blog-01
 * project version:1.0
 *
 * @author :KyleChyan https://github.com/KyleChyan
 * @date :2022/6/15,16:13,ζζδΈ
 */
public interface UserService {
    User checkUser(String username,String password);
    String result = DigestUtils.md5DigestAsHex("123456".getBytes());
}
