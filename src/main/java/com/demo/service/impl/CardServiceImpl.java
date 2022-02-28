package com.demo.service.impl;


import com.demo.mapper.CardMapper;
import com.demo.pojo.BankCard;
import com.demo.service.CardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CardServiceImpl implements CardService {
    @Autowired
    private CardMapper cardMapper;

    @Override
    public List<BankCard> selectBankCardALL() {

        return cardMapper.selectBankCardALL();
    }

    @Override
    public BankCard selectBankCardById(Integer id) {
        return cardMapper.selectBankCardById(id);
    }

    @Override
    public int updateBankCard(BankCard bankCard) {
        return cardMapper.updateBankCard(bankCard);
    }

    @Override
    public int deleteBankCard(Integer id) {
        return cardMapper.deleteBankCard(id);
    }
}
