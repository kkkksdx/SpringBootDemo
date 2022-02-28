package com.demo.service;

import com.demo.pojo.Admin;
import com.demo.pojo.User;

import java.util.List;

public interface UserService {
    public List<User> selectUserALL();
    public int addUser (User user);
    public User selectUserById(Integer id);
    public int updateUser (User user);
    public  int deleteUser(User user);
    public User selectReputationById(Integer id);
    public List<User> selectReputationAll();
    public int updateReputation(User user);
    public int updateUserStatus(User user);
    public User selectUserByUserName(String username);

}
