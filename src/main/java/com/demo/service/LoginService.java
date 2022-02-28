package com.demo.service;

import com.demo.pojo.Admin;
import com.demo.pojo.User;

public interface LoginService {
    public Admin selectAdminByUserName(String username);
    public Admin adminLogin(Admin admin);
    public User userLogin(User user);
    public User selectUserByUserName(String username);
    public int userRegister(Admin user);
}
