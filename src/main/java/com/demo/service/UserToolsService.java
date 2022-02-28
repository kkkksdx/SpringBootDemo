package com.demo.service;

import com.demo.pojo.UserFlowOfFunds;

import java.util.List;

public interface UserToolsService {
    public List<UserFlowOfFunds> selectUserFlowOfFundsAll(Integer id);
    public int addUserFlowOfFunds(Integer id,String amount,String term,String rate);
    public int insertUserFlowOfFunds(UserFlowOfFunds userFlowOfFunds);
}
