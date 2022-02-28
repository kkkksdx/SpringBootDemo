package com.demo.mapper;

import com.demo.pojo.Admin;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

@Mapper
public interface AdminMapper {
    @Select("select * from admin where username=#{username}")
    public Admin selectUserByUserName(String username);
    @Update("update admin set status=#{status} where id = #{id}")
    public int updateAdmin (Admin admin);
}
