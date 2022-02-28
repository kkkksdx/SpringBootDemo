package com.demo.service.impl;

import com.demo.mapper.UserPermissionMapper;
import com.demo.pojo.UserPermissions;
import com.demo.service.UserPermissionsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserPermissionsImpl implements UserPermissionsService {
    @Autowired
    private UserPermissionMapper userPermissionMapper;

    @Override
    public List<UserPermissions> selectUserPermissionsAll() {
        return userPermissionMapper.selectUserPermissionsAll();
    }

    @Override
    public List<UserPermissions> selectUserPermissionsByUserId(Integer id) {
        return userPermissionMapper.selectUserPermissionsByUserId(id);
    }

    @Override
    public int updateUserPermissionsAll() {
        return userPermissionMapper.updateUserPermissionsAll();
    }

    @Override
    public int updateNewUserPermissions(Integer id) {
        return userPermissionMapper.updateNewUserPermissions(id);
    }
}
