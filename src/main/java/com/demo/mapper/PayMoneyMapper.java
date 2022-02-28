package com.demo.mapper;

import com.demo.pojo.PayMoney;
import com.demo.pojo.UserPayMoney;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface PayMoneyMapper {
    @Select("select * from pay_money")
    public List<PayMoney> selectPayMoneyAll();
    @Insert("insert into pay_money (monthMoney,autoInto,type,invesTerm) values(#{monthmoney},#{autointo},#{type},#{investerm})")
    public int addPayMoney(PayMoney payMoney);
    @Select("select * from pay_money where id=#{id}")
    public PayMoney selectPayMoneyById(Integer id);
    @Update("update pay_money set monthMoney=#{monthmoney},autoInto=#{autointo},type=#{type},invesTerm=#{investerm} where id=#{id}")
    public int UpdatePayMoney(PayMoney payMoney);
    @Delete("delete from pay_money where id=#{id}")
    public int DeletePayMoney(Integer id);
    @Insert("insert into user_pay_money(userId,payId,startTime,averYield,profit,status) values(#{userId},#{payId},curdate(),#{averYield},#{profit},1)")
    public int buyPayMoney(UserPayMoney userPayMoney);
}
