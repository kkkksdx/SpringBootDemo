package com.demo.service;

import com.demo.pojo.Permissions;

import java.util.List;

public interface PermissionsService {
    public List<Permissions> selectPermissionsAll(String[] strings);
}
