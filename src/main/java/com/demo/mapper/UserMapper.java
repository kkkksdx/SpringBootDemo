package com.demo.mapper;

import com.demo.pojo.Admin;
import com.demo.pojo.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface UserMapper {
    @Select("select * from user")
    public List<User> selectUserALL();
    @Insert("insert into user (username,password,realname,phone,email,status) values (#{username},#{password},#{realname},#{phone},#{email},0)")
    public int addUser (User user);
    @Select("select * from user where id = #{id}")
    public User selectUserById(Integer id);
    @Update("update user set password = #{password} , realname=#{realname} , phone=#{phone} , email=#{email} ,status=#{status},IDcard=#{idcard},paypwd=#{paypwd} where id = #{id}")
    public int updateUser (User user);
    @Delete("delete from user where id = #{id}")
    public  int deleteUser(User user);
    //信誉
    @Select("select username,reputation from user where id=#{id}")
    public User selectReputationById(Integer id);
    @Select("select id,username,reputation from user")
    public List<User> selectReputationAll();
    @Update("update user set reputation=#{reputation} where id=#{id}")
    public int updateReputation(User user);
    @Update("update user set status=0 where id=#{id}")
    public int updateUserStatus(User user);
    //通过姓名查询
    @Select("select * from user where username=#{username}")
    public User selectUserByUserName(String username);
}
