package com.demo.service.impl;

import com.demo.mapper.AdminPermissionsMapper;
import com.demo.pojo.AdminPermissions;
import com.demo.pojo.UserPermissions;
import com.demo.service.AdminPermissionsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminPermissionsImpl implements AdminPermissionsService {
    @Autowired
    private AdminPermissionsMapper adminPermissionsMapper;

    @Override
    public List<AdminPermissions> selectAdminPermissionsByUserId(Integer id) {
        return adminPermissionsMapper.selectAdminPermissionsByUserId(id);
    }

    @Override
    public List<AdminPermissions> selectAdminPermissionsAll() {
        return adminPermissionsMapper.selectAdminPermissionsAll();
    }

    @Override
    public int updateAdminPermissionsAll() {
        return adminPermissionsMapper.updateAdminPermissionsAll();
    }

    @Override
    public int updateNewAdminPermissions(Integer id) {
        return adminPermissionsMapper.updateNewAdminPermissions(id);
    }
}
