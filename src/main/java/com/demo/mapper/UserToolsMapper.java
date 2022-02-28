package com.demo.mapper;

import com.demo.pojo.UserFlowOfFunds;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

@Mapper
public interface UserToolsMapper {
    @Select("select * from flow_of_funds where userId=#{id}")
    public List<UserFlowOfFunds> selectUserFlowOfFundsAll(Integer id);
    @Insert("insert into loan(loanId,loanTime,amount,term,rate,applyStatus,loanStatus,examineId) values(#{id},now(),#{amount},#{term},#{rate},0,0,1)")
    public int addUserFlowOfFunds(Integer id,String amount,String term,String rate);
    @Insert("insert into flow_of_funds (userId,flowMoney,type,source,createTime,fundDesc) values(#{userId},#{flowmoney},1,#{source},curdate(),#{funddesc} )")
    public int insertUserFlowOfFunds(UserFlowOfFunds userFlowOfFunds);
}
