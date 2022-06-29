package com.kyle.mapper;

import com.kyle.pojo.Type;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * project name   :KyleGalaxyBlog
 *
 * @author :KyleChyan https://github.com/KyleChyan
 * @date :2022/6/28,20:37,星期二
 */
@Repository
public interface TypeMapper {
    //根据id查找
    int selectType(Long id);
    /*
    //这个是用map+sql的方式实现分页
    List<Type> listType(Map<String,Object> data);
    */
    //这个是用插件的方式实现分页
    List<Type> listType();

    Type insertType(Type type);

    int updateType(Map<String,Object> map);

    int deleteType(Long id);


}
