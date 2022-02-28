package com.demo.mapper;

import com.demo.pojo.AdminPermissions;
import com.demo.pojo.UserPermissions;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

@Mapper
public interface AdminPermissionsMapper {
    @Select("select permission from admin_permissions,permissions where adminId=#{id} and permissionId=permissions.id")
    public List<AdminPermissions> selectAdminPermissionsByUserId(Integer id);
    @Select("select permission from admin_permissions,permissions where permissionId=permissions.id and adminId=1")
    public List<AdminPermissions> selectAdminPermissionsAll();
    @Update("update admin_permissions set adminId=0;")
    public int updateAdminPermissionsAll();
    @Update("update admin_permissions set adminId=1 where permissionId=#{id}")
    public int updateNewAdminPermissions(Integer id);
}
