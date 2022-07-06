package com.kyle.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.kyle.mapper.TypeMapper;
import com.kyle.pojo.Type;
import com.kyle.service.TypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * project name   :KyleGalaxyBlog
 *
 * @author :KyleChyan https://github.com/KyleChyan
 * @date :2022/6/28,20:36,星期二
 */
@Service
public class TypeServiceImpl implements TypeService {
    @Autowired
    private TypeMapper typeMapper;

    @Override
    public int selectType(Long id) {
        return typeMapper.selectType(id);
    }

    //用插件的方式实现分页
    @Override
    public PageInfo<Type> listType(int pageNum, int pageSize){
        PageHelper.startPage(pageNum,pageSize);
        List<Type> typeList = typeMapper.listType();
        PageInfo<Type> pageInfo = new PageInfo<>(typeList);
        return pageInfo;
        /*
        //这些是用map+sql的方式实现分页
        Map<String, Object> data = new HashMap();
        data.put("currIndex", (currPage-1)*pageSize);
        data.put("pageSize", pageSize);
        return typeMapper.listType(data);
        */
    }

    @Override
    public int insertType(Type type) {
        return typeMapper.insertType(type);
    }

    @Override
    public int updateType(Map<String,Object> map) {
        return typeMapper.updateType(map);
    }

    @Override
    public int deleteType(Long id) {
        return typeMapper.deleteType(id);
    }
}
