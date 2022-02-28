package com.demo.service;

import com.demo.pojo.*;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface UserPersonalService {
    //我的理财
    public List<UserChangeMoney> selectUserChangeMoney(Integer id);
    public List<UserPayMoney> selectUserPayMoney(Integer id);
    public List<UserTermFinacial> selectUserTermFinacial(Integer id);
    public List<UserFundProduct> selectUserFundProduct(Integer id);
    public int updateUserChangeMoney(int id);
    public int updateUserPayMoney(int id);
    public int updateUserTermFinacial(int id);
    public int updateUserFundProduct(int id);
    //我的借贷
    public List<UserLoan> selectUserLoan(int id);
    public int updateUserLoanStatus(Integer id);
    //银行卡管理
    public List<BankCard> selectUserBankCard(int id);
    public int addBankCard(BankCard bankCard);
    //账户安全
    public User chackUserPassword(Integer id, String password);
    public int changeUserPassword(Integer id,String password);
    //我的消息
    public List<UserInfo> selectUserInfoAll(Integer id);
    public int updateUserInfo(UserInfo userInfo);
    public  int deleteUserInfo(UserInfo userInfo);
}
