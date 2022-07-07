package com.kyle.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * project name   :KyleGalaxyBlog
 *
 * @author :KyleChyan https://github.com/KyleChyan
 * @date :2022/7/2,16:42,星期六
 */
@Controller
@RequestMapping("/admin")
public class TagController {
    @RequestMapping("/taglist")
    public String taglist(){
        return "admin/taglist";
    }

    @RequestMapping("/addtag")
    public String addtag(){
        return "admin/tagadd";
    }
}
