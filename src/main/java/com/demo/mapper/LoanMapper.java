package com.demo.mapper;

import com.demo.pojo.Loan;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

@Mapper
public interface LoanMapper {
    @Select("select loan.id,username, amount,term,reputation,applyStatus from user,loan where user.id=loanId")
    public List<Loan> selectLoanAll();

    @Update("update loan set loanTime=curdate(),applyStatus = 2 where id =#{id}")
    public int checkPass(Integer id);

    @Update("update loan set applyStatus = 1 where id =#{id}")
    public int checkNoPass(Integer id);
    @Update("update loan set loanStatus=1 where id=#{id}")
    public int checkLoan(Integer id);

    @Select("select loan.id,username,IDcard,phone,amount,term,loanStatus from user,loan where user.id=loanId and applyStatus=2")
    public List<Loan> selectLoaninfo();

    @Select("select loanId,user.username,examineId,admin.username,amount,loanTime,term,loanStatus from loan,admin,user where loan.id=#{id} and loanId=user.id")
    public Loan selectNotice(Integer id);
    @Insert("insert into info (sendId, receiveId, createTime, title, infoDesc, status) values(#{examineId},#{loanId},curdate(),#{idcard},#{phone},0)")
    public int sendNotice(Loan loan);
}
