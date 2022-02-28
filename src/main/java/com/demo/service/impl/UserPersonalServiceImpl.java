package com.demo.service.impl;

import com.demo.mapper.UserPersonalMapper;
import com.demo.pojo.*;
import com.demo.service.UserPersonalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserPersonalServiceImpl implements UserPersonalService {
    @Autowired
    private UserPersonalMapper userPersonalMapper;
//我的理财
    @Override
    public List<UserChangeMoney> selectUserChangeMoney(Integer id) {
        return userPersonalMapper.selectUserChangeMoney(id);
    }

    @Override
    public List<UserPayMoney> selectUserPayMoney(Integer id) {
        return userPersonalMapper.selectUserPayMoney(id);
    }

    @Override
    public List<UserTermFinacial> selectUserTermFinacial(Integer id) {
        return userPersonalMapper.selectUserTermFinacial(id);
    }

    @Override
    public List<UserFundProduct> selectUserFundProduct(Integer id) {
        return userPersonalMapper.selectUserFundProduct(id);
    }

    @Override
    public int updateUserChangeMoney(int id) {
        return userPersonalMapper.updateUserChangeMoney(id);
    }

    @Override
    public int updateUserPayMoney(int id) {
        return userPersonalMapper.updateUserPayMoney(id);
    }

    @Override
    public int updateUserTermFinacial(int id) {
        return userPersonalMapper.updateUserTermFinacial(id);
    }

    @Override
    public int updateUserFundProduct(int id) {
        return userPersonalMapper.updateUserFundProduct(id);
    }
    //我的借贷

    @Override
    public List<UserLoan> selectUserLoan(int id) {
        return userPersonalMapper.selectUserLoan(id);
    }

    @Override
    public int updateUserLoanStatus(Integer id) {
        return userPersonalMapper.updateUserLoanStatus(id);
    }

    @Override
    public List<BankCard> selectUserBankCard(int id) {
        return userPersonalMapper.selectUserBankCard(id);
    }

    @Override
    public int addBankCard(BankCard bankCard) {
        return userPersonalMapper.addBankCard(bankCard);
    }

    @Override
    public User chackUserPassword(Integer id, String password) {
        return userPersonalMapper.chackUserPassword(id, password);
    }

    @Override
    public int changeUserPassword(Integer id, String password) {
        return userPersonalMapper.changeUserPassword(id, password);
    }
//我的消息
    @Override
    public List<UserInfo> selectUserInfoAll(Integer id) {
        return userPersonalMapper.selectUserInfoAll(id);
    }

    @Override
    public int updateUserInfo(UserInfo userInfo) {
        return userPersonalMapper.updateUserInfo(userInfo);
    }

    @Override
    public int deleteUserInfo(UserInfo userInfo) {
        return userPersonalMapper.deleteUserInfo(userInfo);
    }
}
