package com.demo.service.impl;

import com.demo.mapper.UserToolsMapper;
import com.demo.pojo.UserFlowOfFunds;
import com.demo.service.UserToolsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserToolsServiceImpl implements UserToolsService {
    @Autowired
    private UserToolsMapper userToolsMapper;

    @Override
    public List<UserFlowOfFunds> selectUserFlowOfFundsAll(Integer id) {
        return userToolsMapper.selectUserFlowOfFundsAll(id);
    }

    @Override
    public int addUserFlowOfFunds(Integer id, String amount, String term, String rate) {
        return userToolsMapper.addUserFlowOfFunds(id,amount,term,rate);
    }
    @Override
    public int insertUserFlowOfFunds(UserFlowOfFunds userFlowOfFunds){
        return userToolsMapper.insertUserFlowOfFunds(userFlowOfFunds);
    }
}
