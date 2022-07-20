package com.kyle.controller.admin;

import com.github.pagehelper.PageInfo;

import com.kyle.pojo.Tag;
import com.kyle.service.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/**
 * project name   :KyleGalaxyBlog
 *
 * @author :KyleChyan https://github.com/KyleChyan
 * @date :2022/6/29,15:07,星期三
 */
@Controller
@RequestMapping("/admin")
public class TagController {
    @Autowired
    private TagService tagService;

    //前往标签列表
    @GetMapping("/taglist")
    public String gotaglist(@RequestParam(value = "pageNum",required = false,defaultValue = "1")int pageNum,
                                    @RequestParam(value = "pageSize",required = false,defaultValue = "5") int pageSize,Model model) {

        PageInfo<Tag> tagPageInfo = tagService.listTag(pageNum, pageSize);
        System.out.println(tagPageInfo);
        System.out.println(tagPageInfo.getList());
        System.out.println(tagPageInfo.getList().indexOf(1)+1);
        model.addAttribute("tagPageInfo",tagPageInfo);
        return "admin/taglist";

    }
    //前往新增标签页面
    @RequestMapping("/addtag")
    public String addtag(){
        return "admin/tagadd";
    }
    //新增标签
    @PostMapping("/tagadd")
    public String goaddtag(Tag tag, RedirectAttributes attributes){

        if (tag == null) {
            attributes.addFlashAttribute("message","操作失败");
        }
        else {
            tagService.insertTag(tag);
            attributes.addFlashAttribute("message","操作成功");
        }
        return "redirect:/admin/taglist";
    }
    //前往修改标签页面
    @RequestMapping("/toupdatetag/{id}")
    public String toupdateTag(@PathVariable("id") Long id , Model model) {
        Tag tag = tagService.selectTagById(id);
        model.addAttribute("Stag", tag);
        return "admin/tagupdate";
    }
    //修改标签
    @PostMapping("/updatetag")
    public String updateTag(Tag tag){
        tagService.updateTag(tag);
        return "redirect:/admin/taglist";
    }
    //删除标签
    @GetMapping("/deletetag/{id}")
    public String deletetag(@PathVariable("id") Long id){
        tagService.deleteTag(id);
        return "redirect:/admin/taglist";
    }
}
