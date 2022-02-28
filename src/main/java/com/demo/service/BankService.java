package com.demo.service;

import com.demo.pojo.Bank;

import java.util.List;

public interface BankService {
    public List<Bank> selectBankAll();
    public int addBank(Bank bank);
    public Bank selectBankById(Integer id);
    public int UpdateBank(Bank bank);
    public  int deleteBank(Bank bank);
}
