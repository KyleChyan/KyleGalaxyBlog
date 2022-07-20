package com.kyle.service;

import com.github.pagehelper.PageInfo;
import com.kyle.pojo.Blog;


/**
 * project name   :KyleGalaxyBlog
 *
 * @author :KyleChyan https://github.com/KyleChyan
 * @date :2022/7/20,15:15,星期三
 */
public interface BlogService {
    //根据id查找博客
    Blog selectBlogById(Long id);
    //用插件的方式实现分页
    PageInfo<Blog> listBlog(int pageNum, int pageSize);
    //新增博客
    int insertBlog(Blog blog);
    //修改博客
    int updateBlog(Blog blog);
    //根据id删除博客
    int deleteBlog(Long id);

}
