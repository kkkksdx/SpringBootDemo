package com.demo.mapper;

import com.demo.pojo.News;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface NewsMapper {
    @Select("select id,title,newsDesc,createTime from news")
    public List<News> selectNewsAll();
}
