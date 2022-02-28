package com.demo.service;

import com.demo.pojo.AdminPermissions;
import com.demo.pojo.UserPermissions;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface AdminPermissionsService {
    public List<AdminPermissions> selectAdminPermissionsByUserId(Integer id);
    public List<AdminPermissions> selectAdminPermissionsAll();
    public int updateAdminPermissionsAll();
    public int updateNewAdminPermissions(Integer id);
}
