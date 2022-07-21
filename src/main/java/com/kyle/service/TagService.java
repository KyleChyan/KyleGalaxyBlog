package com.kyle.service;

import com.github.pagehelper.PageInfo;
import com.kyle.pojo.Tag;

import java.util.List;


/**
 * project name   :KyleGalaxyBlog
 *
 * @author :KyleChyan https://github.com/KyleChyan
 * @date :2022/6/28,20:31,星期二
 */

public interface TagService {
    //根据id查找
    Tag selectTagById(Long id);
    //用插件的方式实现分页
    PageInfo<Tag> listTag(int pageNum, int pageSize);
    //查询所有内容
    List<Tag> allTag();
    //新增标签
    int insertTag(Tag tag);
    //从字符串获取标签
    List<Tag> getListTagByString(String tagId);
    //修改标签
    int updateTag(Tag tag);
    //删除标签
    int deleteTag(Long id);


}
