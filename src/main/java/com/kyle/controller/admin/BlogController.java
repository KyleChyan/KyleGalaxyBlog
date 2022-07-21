package com.kyle.controller.admin;

import com.github.pagehelper.PageInfo;
import com.kyle.pojo.Blog;
import com.kyle.pojo.Tag;
import com.kyle.pojo.User;
import com.kyle.service.BlogService;
import com.kyle.service.TagService;
import com.kyle.service.TypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

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
    @Autowired
    private TypeService typeService;
    @Autowired
    private TagService tagService;
    //前往博客列表页
    @RequestMapping("/bloglist")
    public String bloglist(@RequestParam(value = "pageNum",required = false,defaultValue = "1")int pageNum,
                           @RequestParam(value = "pageSize",required = false,defaultValue = "5") int pageSize, Model model){
        PageInfo<Blog> blogPageInfo = blogService.listBlog(pageNum, pageSize);
        model.addAttribute("typelist",typeService.allType());
        model.addAttribute("blogPageInfo",blogPageInfo);
        return "admin/bloglist";
    }
    //前往发布博客页
    @GetMapping("/blogpublish")
    public String blogpublish(Model model){
        model.addAttribute("typelist",typeService.allType());
        model.addAttribute("taglist",tagService.allTag());
        model.addAttribute("blog",new Blog());
        return "admin/blogpublish";
    }
    //发布/保存博客
    @PostMapping("/postblog")
    public String postblog(Blog blog, HttpSession session, Model model){
        blog.setUser((User) session.getAttribute("user"));
        blog.setType(typeService.selectTypeById(blog.getType().getId()));
        blog.setTags(tagService.getListTagByString(blog.getTagId()));
        blogService.insertBlog(blog);
        return "redirect:/admin/bloglist";
    }
    //删除博客
    @GetMapping("/deleteblog/{id}")
    public String deleteblog(@PathVariable("id") Long id){
        blogService.deleteBlog(id);
        return "redirect:/admin/bloglist";
    }
}
