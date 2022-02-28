package com.demo.service;

import com.demo.pojo.UserPermissions;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface UserPermissionsService {
    public List<UserPermissions> selectUserPermissionsAll();
    public List<UserPermissions> selectUserPermissionsByUserId(Integer id);
    public int updateUserPermissionsAll();
    public int updateNewUserPermissions(Integer id);
}
