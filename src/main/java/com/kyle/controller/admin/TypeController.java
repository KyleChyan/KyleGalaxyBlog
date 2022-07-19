package com.kyle.controller.admin;

import com.github.pagehelper.PageInfo;
import com.kyle.pojo.Type;
import com.kyle.service.TypeService;
import com.kyle.service.impl.TypeServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * project name   :KyleGalaxyBlog
 *
 * @author :KyleChyan https://github.com/KyleChyan
 * @date :2022/6/29,15:07,星期三
 */
@Controller
@RequestMapping("/admin")
public class TypeController {
    @Autowired
    private TypeService typeService;

    //前往分类列表
    @GetMapping("/typelist")
    public String gotypelist(@RequestParam(value = "pageNum",required = false,defaultValue = "1")int pageNum,
                                    @RequestParam(value = "pageSize",required = false,defaultValue = "5") int pageSize,Model model) {
        /*
        //如果使用restful风格传参，请使用这些东西 👉 @PathVariable("currPage") @PathVariable("pageSize")
        @RequestMapping("/typelist/{currPage}/{pageSize}")
        return typeService.listType(currPage, pageSize);
        */

        PageInfo<Type> typePageInfo = typeService.listType(pageNum, pageSize);
        System.out.println(typePageInfo);
        System.out.println(typePageInfo.getList());
        System.out.println(typePageInfo.getList().indexOf(1)+1);
        model.addAttribute("typePageInfo",typePageInfo);
        return "admin/typelist";

    }
    //前往新增分类页面
    @RequestMapping("/addtype")
    public String addtype(){
        return "admin/typeadd";
    }
    //新增分类
    @PostMapping("/typeadd")
    public String goaddtype(Type type, RedirectAttributes attributes){

        if (type == null) {
            attributes.addFlashAttribute("message","操作失败");
        }
        else {
            typeService.insertType(type);
            attributes.addFlashAttribute("message","操作成功");
        }
        return "redirect:/admin/typelist";
    }
    //前往修改页面
    @RequestMapping("/toupdatetype/{id}")
    public String toupdateType(@PathVariable("id") Long id , Model model) {
        Type type = typeService.selectTypeById(id);
        model.addAttribute("Stype", type);
        return "admin/typeupdate";
    }
    //更改分类
    @PostMapping("/updatetype")
    public String updateType(Type type){
        typeService.updateType(type);
        return "redirect:/admin/typelist";
    }
    //删除分类
    @RequestMapping("/deletetype/{id}")
    public String deletetype(@PathVariable("id") Long id){
        typeService.deleteType(id);
        return "redirect:/admin/typelist";
    }
}
