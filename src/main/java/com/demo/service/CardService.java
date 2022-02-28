package com.demo.service;

import com.demo.pojo.BankCard;

import java.util.List;

public interface CardService {
    public List<BankCard> selectBankCardALL();
    public BankCard selectBankCardById(Integer id);
    public int updateBankCard(BankCard bankCard);
    public int deleteBankCard(Integer id);
}
