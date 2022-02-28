package com.demo.service.impl;

import com.demo.mapper.LoginMapper;
import com.demo.pojo.Admin;
import com.demo.pojo.User;
import com.demo.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginServiceImpl implements LoginService {
    @Autowired
    private LoginMapper loginMapper;

    @Override
    public Admin selectAdminByUserName(String username) {
        return loginMapper.selectAdminByUserName(username);
    }

    @Override
    public Admin adminLogin(Admin admin) {
        return loginMapper.adminLogin(admin);
    }

    @Override
    public User userLogin(User user) {
        return loginMapper.userLogin(user);
    }

    @Override
    public User selectUserByUserName(String username) {
        return loginMapper.selectUserByUserName(username);
    }
    @Override
    public int userRegister(Admin user){
        return loginMapper.userRegister(user);
    }
}
