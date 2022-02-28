package com.demo.mapper;

import com.demo.pojo.ChangeMoney;
import com.demo.pojo.TermFinancial;
import com.demo.pojo.UserTermFinacial;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface TermFinancialMapper {
    @Select("select * from term_financial")
    public List<TermFinancial> selectTermFinancialAll();
    @Insert("insert into term_financial (name,invesTerm,leastMoney,profit,annualIncome) values (#{name},#{investerm},#{leastmoney},#{profit},#{annualincome})")
    public int addTermFinancial(TermFinancial termFinancial);
    @Select("select * from term_financial where id = #{id}")
    public TermFinancial selectTermFinancialById(Integer id);
    @Update("update term_financial set name=#{name},invesTerm=#{investerm},leastMoney=#{leastmoney},profit=#{profit},annualIncome=#{annualincome} where id=#{id}")
    public int UpdateTermFinancial(TermFinancial termFinancial);
    @Delete("delete from term_financial where id = #{id}")
    public  int deleteTermFinancial(TermFinancial termFinancial);
    @Insert("insert into user_term_financial(userId,termId,startTime,averYield,profit,status) values(#{userId},#{termFinancialId},curdate(),#{averYield},#{profit},1)")
    public int buyTermFinancial(UserTermFinacial userTermFinacial);
}
