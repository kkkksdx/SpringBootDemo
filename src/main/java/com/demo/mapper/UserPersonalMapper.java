package com.demo.mapper;

import com.demo.pojo.*;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Service;

import java.util.List;

@Mapper
public interface UserPersonalMapper {
    //我的理财
    @Select("SELECT u.`name`,u.`annualIncome`,u.`invesMoney`,u.`invesTerm`,u.`peiIncome`,t.* FROM change_money u JOIN user_change_money t ON u.id=t.changeId WHERE t.userId=#{id}")
    public List<UserChangeMoney> selectUserChangeMoney(Integer id);

    @Select("SELECT u.`autoInto`,u.`invesTerm`,u.`monthMoney`,u.`type`,t.* FROM pay_money u JOIN user_pay_money t ON u.id=t.payId WHERE t.userId=#{id}")
    public List<UserPayMoney> selectUserPayMoney(Integer id);

    @Select("SELECT u.`annualIncome`,u.`invesTerm`,u.`name`,u.`leastMoney`,t.* FROM term_financial u JOIN user_term_financial t ON u.id=t.termId WHERE t.userId=#{id}")
    public List<UserTermFinacial> selectUserTermFinacial(Integer id);

    @Select("SELECT u.`annualGrowth`,u.`code`,u.`dailyGrowth`,u.`fundDesc`,u.`invesTerm`,u.`leastMoney`,u.`monthlyGrowth`,u.`type`,t.* FROM fund_product u JOIN user_fund_product t ON u.id=t.fundId WHERE t.userId=#{id}")
    public List<UserFundProduct> selectUserFundProduct(Integer id);

    @Update("update user_change_money set status=3 where id=#{id}")
    public int updateUserChangeMoney(int id);

    @Update("update user_pay_money set status=3 where id=#{id}")
    public int updateUserPayMoney(int id);

    @Update("update user_term_financial set status=3 where id=#{id}")
    public int updateUserTermFinacial(int id);

    @Update("update user_fund_product set status=3 where id=#{id}")
    public int updateUserFundProduct(int id);
    //我的借贷
    @Select("select * from loan where loanId=#{id}")
    public List<UserLoan> selectUserLoan(int id);
    @Update("update loan set loanStatus=2 where id=#{id}")
    public int updateUserLoanStatus(Integer id);
    //银行卡管理
    @Select("select * from bankcard where userId=#{id}")
    public List<BankCard> selectUserBankCard(int id);
    @Insert("insert into bankcard (cardBank,type,cardNum,userId) values (#{cardbank},#{type},#{cardnum},#{userId})")
    public int addBankCard(BankCard bankCard);
    //账户安全
    @Select("select * from user where id=#{id} and password =#{password}")
    public User chackUserPassword(Integer id, String password);

    @Update("update user set password=#{password} where id=#{id}")
    public int changeUserPassword(Integer id,String password);
    //我的消息
    @Select("select info.id,sendId,receiveId,createTime,title,infoDesc,info.status,username from info,admin where admin.id=sendId and receiveId=#{id}")
    public List<UserInfo> selectUserInfoAll(Integer id);
    @Update("update info set status=1 where id = #{id}")
    public int updateUserInfo(UserInfo userInfo);
    @Delete("delete from info where id = #{id}")
    public  int deleteUserInfo(UserInfo userInfo);

}
