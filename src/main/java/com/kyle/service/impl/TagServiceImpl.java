package com.kyle.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.kyle.mapper.TagMapper;
import com.kyle.mapper.TypeMapper;
import com.kyle.pojo.Tag;
import com.kyle.pojo.Type;
import com.kyle.service.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * project name   :KyleGalaxyBlog
 *
 * @author :KyleChyan https://github.com/KyleChyan
 * @date :2022/6/28,20:36,星期二
 */
@Service
public class TagServiceImpl implements TagService {
    @Autowired
    private TagMapper tagMapper;


    @Override
    public Tag selectTagById(Long id) {
        return tagMapper.selectTagById(id);
    }

    //用插件的方式实现分页
    @Override
    public PageInfo<Tag> listTag(int pageNum, int pageSize){
        PageHelper.startPage(pageNum,pageSize);
        List<Tag> tagList = tagMapper.listTag();
        PageInfo<Tag> pageInfo = new PageInfo<>(tagList);
        return pageInfo;
    }

    @Override
    public List<Tag> allTag() {
        return tagMapper.listTag();
    }

    @Override
    public int insertTag(Tag tag) {
        return tagMapper.insertTag(tag);
    }

    @Override
    public List<Tag> getListTagByString(String tagId) {
        List<Long> longList = converToList(tagId);
        List<Tag> taglist = new ArrayList<>();
        for (Long aLong : longList) {
            taglist.add(tagMapper.selectTagById(aLong));
        }
        return taglist;
    }
    //字符串转换为list
    private List<Long> converToList(String ids){
        List<Long> list = new ArrayList<>();
        if (ids != null) {
            String[] split = ids.split(",");
            for (String s : split) {
                list.add(new Long(s));
            }
        }
        return list;
    }
    @Override
    public int updateTag(Tag tag) {
        return tagMapper.updateTag(tag);
    }

    @Override
    public int deleteTag(Long id) {
        return tagMapper.deleteTag(id);
    }
}
