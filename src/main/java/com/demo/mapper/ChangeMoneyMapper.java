package com.demo.mapper;

import com.demo.pojo.ChangeMoney;
import com.demo.pojo.UserChangeMoney;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface ChangeMoneyMapper {
    @Select("select * from change_money")
    public List<ChangeMoney> selectChangeMoneyAll();
    @Insert("insert into change_money (name,annualIncome,peiIncome,invesMoney,invesTerm) values (#{name},#{annualincome},#{peiincome},#{invesmoney},#{investerm})")
    public int addChangeMoney(ChangeMoney changeMoney);
    @Select("select * from change_money where id = #{id}")
    public ChangeMoney selectChangeMoneyById(Integer id);
    @Update("update change_money set name=#{name},annualIncome=#{annualincome},peiIncome=#{peiincome},invesMoney=#{invesmoney},invesTerm=#{investerm} where id=#{id}")
    public int UpdateChangeMoney(ChangeMoney changeMoney);
    @Delete("delete from change_money where id = #{id}")
    public  int deleteChangeMoney(ChangeMoney changeMoney);
    @Insert("insert into user_change_money(userId,changeId,startTime,averYield,profit,status) values(#{userId},#{changeId},curdate(),#{averYield},#{profit},1)")
    public int buyChangeMoney(UserChangeMoney userChangeMoney);

}
