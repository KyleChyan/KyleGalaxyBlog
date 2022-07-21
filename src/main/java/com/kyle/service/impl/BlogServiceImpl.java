package com.kyle.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.kyle.mapper.BlogMapper;
import com.kyle.mapper.TagMapper;
import com.kyle.pojo.Blog;
import com.kyle.pojo.Tag;
import com.kyle.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * project name   :KyleGalaxyBlog
 *
 * @author :KyleChyan https://github.com/KyleChyan
 * @date :2022/7/20,15:32,星期三
 */
@Service
public class BlogServiceImpl implements BlogService {

    @Autowired
    private BlogMapper blogMapper;


    @Override
    public Blog selectBlogById(Long id) {
        return blogMapper.selectBlogById(id);
    }

    //用插件的方式实现分页
    @Override
    public PageInfo<Blog> listBlog(int pageNum, int pageSize){
        PageHelper.startPage(pageNum,pageSize);
        List<Blog> blogList = blogMapper.listBlog();
        PageInfo<Blog> pageInfo = new PageInfo<>(blogList);
        return pageInfo;
    }

    @Override
    public int insertBlog(Blog blog) {
        blog.setCreateTime(new Date());
        blog.setUpdateTime(new Date());
        blog.setViews(0);
        return blogMapper.insertBlog(blog);
    }

    @Override
    public int updateBlog(Blog blog) {
        return blogMapper.updateBlog(blog);
    }

    @Override
    public int deleteBlog(Long id) {
        return blogMapper.deleteBlog(id);
    }
}
