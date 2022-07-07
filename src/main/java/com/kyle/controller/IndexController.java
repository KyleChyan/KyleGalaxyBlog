package com.kyle.controller;

import org.apache.ibatis.annotations.Param;
import org.hibernate.annotations.Cache;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * project name   :KyleGalaxyBlog
 *
 * @author :KyleChyan https://github.com/KyleChyan
 * @date :2022/6/3,16:06,星期五
 */
@Controller
public class IndexController {
//    主页
    @RequestMapping("/")
    public String index(){
        return "index";
    }
//    博客详情
    @RequestMapping("/blog")
    public String blog(){
        return "blog";
    }
//    分类
    @RequestMapping("/type")
    public String type(){
        return "type";
    }
//    标签
    @RequestMapping("/tags")
    public String tags(){
        return "tags";
    }
//   足迹
    @RequestMapping("/timeline")
    public String timeline(){
        return "timeline";
    }
//    我的
    @RequestMapping("/about")
    public String about(){
        return "about";
    }

}
