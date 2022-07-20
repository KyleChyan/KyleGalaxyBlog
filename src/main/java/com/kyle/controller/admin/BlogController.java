package com.kyle.controller.admin;

import com.github.pagehelper.PageInfo;
import com.kyle.pojo.Blog;
import com.kyle.pojo.Tag;
import com.kyle.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

/**
 * project name   :KyleGalaxyBlog
 *
 * @author :KyleChyan https://github.com/KyleChyan
 * @date :2022/6/23,19:58,星期四
 */
@Controller
@RequestMapping("/admin")
public class BlogController {

    @Autowired
    private BlogService blogService;
    //前往博客列表页
    @RequestMapping("/bloglist")
    public String bloglist(@RequestParam(value = "pageNum",required = false,defaultValue = "1")int pageNum,
                           @RequestParam(value = "pageSize",required = false,defaultValue = "5") int pageSize, Model model){
        PageInfo<Blog> blogPageInfo = blogService.listBlog(pageNum, pageSize);
        model.addAttribute("blogPageInfo",blogPageInfo);
        return "admin/bloglist";
    }
    //前往发布博客页
    @RequestMapping("/blogpublish")
    public String blogpublish(){
        return "admin/blogpublish";
    }
    //前往博客编辑页
    @PostMapping("/updateblog/{id}")
    public String updateblog(@PathVariable("id") Long id , Model model){
//        Blog blog = blogService.selectBlogById(id);
//        model.addAttribute("Sblog",blog);
        return "admin/blogpublish";
    }
    //删除博客
    @GetMapping("/deleteblog/{id}")
    public String deleteblog(@PathVariable("id") Long id){
        blogService.deleteBlog(id);
        return "redirect:/admin/bloglist";
    }
}
