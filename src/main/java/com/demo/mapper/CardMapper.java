package com.demo.mapper;

import com.demo.pojo.BankCard;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

@Mapper
public interface CardMapper {
    @Select("select bankcard.id,username,cardBank,type,cardNum from bankcard,user where user.id=userId")
    public List<BankCard> selectBankCardALL();
    @Select("select username,cardBank,cardNum,type from bankcard,user where bankcard.id=#{id} and user.id=userId")
    public BankCard selectBankCardById(Integer id);
    @Update("update bankcard set cardBank=#{cardbank},type=#{type},cardNum=#{cardnum} where id=#{id}")
    public int updateBankCard(BankCard bankCard);
    @Delete("delete from bankcard where id=#{id}")
    public int deleteBankCard(Integer id);
}
