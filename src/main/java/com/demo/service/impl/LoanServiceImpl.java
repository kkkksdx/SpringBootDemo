package com.demo.service.impl;

import com.demo.mapper.LoanMapper;
import com.demo.pojo.Loan;
import com.demo.service.LoanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LoanServiceImpl implements LoanService {
    @Autowired
    private LoanMapper loanMapper;

    @Override
    public List<Loan> selectLoanAll() {
        return loanMapper.selectLoanAll();
    }

    @Override
    public int checkPass(Integer id) {
        return loanMapper.checkPass(id);
    }

    @Override
    public int checkNoPass(Integer id) {
        return loanMapper.checkNoPass(id);
    }
    public int checkLoan(Integer id){
        return loanMapper.checkLoan(id);
    }
    @Override
    public List<Loan> selectLoaninfo() {
        return loanMapper.selectLoaninfo();
    }

    @Override
    public Loan selectNotice(Integer id) {
        return loanMapper.selectNotice(id);
    }

    @Override
    public int sendNotice(Loan loan) {
        return loanMapper.sendNotice(loan);
    }

}
