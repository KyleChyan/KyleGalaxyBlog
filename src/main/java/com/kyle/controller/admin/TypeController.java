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

import java.util.List;

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
    @RequestMapping("/typelist")
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
    @RequestMapping("/goaddtype")
    public String goaddtype(){
        return "admin/typelist";
    }
    //更改分类
    //删除分类

}
