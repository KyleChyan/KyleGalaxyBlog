package com.kyle.controller;

import org.hibernate.annotations.Cache;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * project name   :KyleGalaxyBlog
 *
 * @author :KyleChyan https://github.com/KyleChyan
 * @date :2022/6/3,16:06,星期五
 */
@Controller
public class IndexController {
    @RequestMapping("/")
    public String index(){

        return "index";
    }
    @RequestMapping("/blog")
    public String blog(){
//        int i=1/0;
        return "blog";
    }

}
