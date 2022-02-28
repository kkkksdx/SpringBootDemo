package com.demo.mapper;

import com.demo.pojo.ChangeMoney;
import com.demo.pojo.FundProduct;
import com.demo.pojo.UserFundProduct;
import org.apache.ibatis.annotations.*;

import java.util.List;
@Mapper
public interface FundProductMapper {
    @Select("select * from fund_product")
    public List<FundProduct> selectFundProductAll();
    @Insert("insert into fund_product (type,code,fundDesc,dailyGrowth,monthlyGrowth,annualGrowth,leastMoney,invesTerm) values (#{type},#{code},#{funddesc},#{dailygrowth},#{monthlygrowth},#{annualgrowth},#{leastmoney},#{investerm})")
    public int addFundProduct(FundProduct fundProduct);
    @Select("select * from fund_product where id = #{id}")
    public FundProduct selectFundProductById(Integer id);
    @Update("update fund_product set type=#{type},code=#{code},fundDesc=#{funddesc},dailyGrowth=#{dailygrowth},monthlyGrowth=#{monthlygrowth},annualGrowth=#{annualgrowth},leastMoney=#{leastmoney},invesTerm=#{investerm} where id=#{id}")
    public int UpdateFundProduct(FundProduct fundProduct);
    @Delete("delete from fund_product where id = #{id}")
    public  int deleteFundProduct(FundProduct fundProduct);
    @Insert("insert into user_fund_product(userId,fundId,startTime,averYield,profit,status) values(#{userId},#{fundId},curdate(),#{monthlyGrowth},#{profit},1)")
    public int buyFundProduct(UserFundProduct userFundProduct);
}
