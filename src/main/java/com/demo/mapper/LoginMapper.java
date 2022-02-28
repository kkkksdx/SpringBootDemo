package com.demo.mapper;

import com.demo.pojo.Admin;
import com.demo.pojo.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface LoginMapper {
    @Select("select * from admin where username=#{username}")
    public Admin selectAdminByUserName(String username);
    @Select("select * from user where username=#{username}")
    public User selectUserByUserName(String username);
    @Select("select * from admin where username = #{username} and password=#{password}")
    public Admin adminLogin(Admin admin);
    @Select("select * from user where username = #{username} and password=#{password}")
    public User userLogin(User user);
    //注册
    @Insert("insert into user (username,password,status) values(#{username},#{password},0)")
    public int userRegister(Admin user);
}
