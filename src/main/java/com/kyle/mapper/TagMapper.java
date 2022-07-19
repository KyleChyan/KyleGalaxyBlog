package com.kyle.mapper;

import com.kyle.pojo.Tag;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * project name   :KyleGalaxyBlog
 *
 * @author :KyleChyan https://github.com/KyleChyan
 * @date :2022/6/28,20:37,星期二
 */
@Repository
public interface TagMapper {
    //根据id查找
    Tag selectTagById(Long id);
    //用插件的方式实现分页
    List<Tag> listTag();
    //新增标签
    int insertTag(Tag tag);
    //修改标签
    int updateTag(Tag tag);
    //删除标签
    int deleteTag(@Param("id") Long id);


}
