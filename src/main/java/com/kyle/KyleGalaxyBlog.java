package com.kyle;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.util.DigestUtils;

@MapperScan("com.kyle.mapper")
@SpringBootApplication
public class KyleGalaxyBlog {

    public static void main(String[] args) {
        SpringApplication.run(KyleGalaxyBlog.class, args);
        String result = DigestUtils.md5DigestAsHex("123456".getBytes());
        System.out.println(result);
    }

}
