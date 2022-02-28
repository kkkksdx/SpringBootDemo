package com.demo.service.impl;

import com.demo.mapper.UserMapper;
import com.demo.pojo.Admin;
import com.demo.pojo.User;
import com.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;

    @Override
    public List<User> selectUserALL() {
        return userMapper.selectUserALL();
    }

    @Override
    public int addUser(User user) {
        return userMapper.addUser(user);
    }

    @Override
    public User selectUserById(Integer id) {
        return userMapper.selectUserById(id);
    }

    @Override
    public int updateUser(User user) {
        return userMapper.updateUser(user);
    }

    @Override
    public int deleteUser(User user) {
        return userMapper.deleteUser(user);
    }

    @Override
    public User selectReputationById(Integer id) {
        return userMapper.selectReputationById(id);
    }

    @Override
    public List<User> selectReputationAll() {
        return userMapper.selectReputationAll();
    }

    @Override
    public int updateReputation(User user) {
        return userMapper.updateReputation(user);
    }

    @Override
    public int updateUserStatus(User user) {
        return userMapper.updateUserStatus(user);
    }

    @Override
    public User selectUserByUserName(String username) {
        return userMapper.selectUserByUserName(username);
    }
}
