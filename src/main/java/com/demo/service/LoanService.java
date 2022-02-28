package com.demo.service;

import com.demo.pojo.Loan;

import java.util.List;

public interface LoanService {
    public List<Loan> selectLoanAll();
    public int checkPass(Integer id);
    public int checkNoPass(Integer id);
    public List<Loan> selectLoaninfo();
    public int sendNotice(Loan loan);
    public Loan selectNotice(Integer id);
    public int checkLoan(Integer id);
}
