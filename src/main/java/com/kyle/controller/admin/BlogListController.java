package com.kyle.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * project name   :KyleGalaxyBlog
 *
 * @author :KyleChyan https://github.com/KyleChyan
 * @date :2022/6/23,19:58,星期四
 */
@Controller
@RequestMapping("/admin")
public class BlogListController {

    @RequestMapping("/bloglist")
    public String bloglist(){
        return "admin/adminblog";
    }
}
