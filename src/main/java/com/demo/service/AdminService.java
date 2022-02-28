package com.demo.service;

import com.demo.pojo.Admin;

public interface AdminService {
    public Admin selectUserByUserName(String username);
    public int updateAdmin (Admin admin);
}
