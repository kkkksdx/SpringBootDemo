package com.demo.mapper;

import com.demo.pojo.UserPermissions;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

@Mapper
public interface UserPermissionMapper {
    @Select("select permission from user_permissions,permissions where permissionId=permissions.id and userId=1")
    public List<UserPermissions> selectUserPermissionsAll();
    @Select("select permission from user_permissions,permissions where userId=#{id} and permissionId=permissions.id")
    public List<UserPermissions> selectUserPermissionsByUserId(Integer id);
    @Update("update user_permissions set userId=0;")
    public int updateUserPermissionsAll();
    @Update("update user_permissions set userId=1 where permissionId=#{id}")
    public int updateNewUserPermissions(Integer id);
}
