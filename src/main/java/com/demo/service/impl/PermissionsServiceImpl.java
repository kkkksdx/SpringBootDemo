package com.demo.service.impl;

import com.demo.pojo.Permissions;
import com.demo.mapper.PermissionsMapper;
import com.demo.service.PermissionsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PermissionsServiceImpl implements PermissionsService {
    @Autowired
    private PermissionsMapper permissionsMapper;

    @Override
    public List<Permissions> selectPermissionsAll(String[] strings) {
        List<Permissions> list =new ArrayList<Permissions>();
        for(String string:strings){
            Permissions permissions=new Permissions();
            int i= permissionsMapper.selectPermissionsAll(string);
            //查询admin中的id与id相等的元组
            permissions.setId(i);
            list.add(permissions);
        }
        return list;
    }
}
