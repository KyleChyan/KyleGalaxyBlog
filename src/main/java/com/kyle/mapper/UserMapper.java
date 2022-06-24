package com.kyle.mapper;

import com.kyle.pojo.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * project name   :blog-01
 * project version:1.0
 *
 * @author :KyleChyan https://github.com/KyleChyan
 * @date :2022/6/15,16:18,星期三
 */

@Repository
public interface UserMapper {
    User checkUser(@Param("username") String username,@Param("password") String password);
}
