package com.kyle.service;

import com.github.pagehelper.PageInfo;
import com.kyle.pojo.Type;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Map;

/**
 * project name   :KyleGalaxyBlog
 *
 * @author :KyleChyan https://github.com/KyleChyan
 * @date :2022/6/28,20:31,星期二
 */

public interface TypeService {
    Type selectTypeById(Long id);

    PageInfo<Type> listType(int pageNum, int pageSize);

    int insertType(Type type);

    int updateType(Type type);

    int deleteType(Long id);


}
