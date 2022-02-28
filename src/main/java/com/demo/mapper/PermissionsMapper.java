package com.demo.mapper;

import com.demo.pojo.Permissions;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface PermissionsMapper {
    @Select("select id from permissions where permission =#{permission}")
    public int selectPermissionsAll(String permission);
}
