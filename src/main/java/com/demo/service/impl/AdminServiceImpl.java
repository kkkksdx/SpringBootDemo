package com.demo.service.impl;

import com.demo.mapper.AdminMapper;
import com.demo.pojo.Admin;
import com.demo.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminServiceImpl implements AdminService {
    @Autowired
     private AdminMapper adminMapper;

    @Override
    public Admin selectUserByUserName(String username) {
        return adminMapper.selectUserByUserName(username);
    }

    @Override
    public int updateAdmin(Admin admin) {
        return adminMapper.updateAdmin(admin);
    }
}
