package com.demo.service.impl;

import com.demo.mapper.PayMoneyMapper;
import com.demo.pojo.PayMoney;
import com.demo.pojo.UserPayMoney;
import com.demo.service.PayMoneyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PayMoneyServiceImpl implements PayMoneyService {
    @Autowired
    private PayMoneyMapper payMoneyMapper;

    @Override
    public List<PayMoney> selectPayMoneyAll() {
        return payMoneyMapper.selectPayMoneyAll();
    }

    @Override
    public int addPayMoney(PayMoney payMoney) {
        return payMoneyMapper.addPayMoney(payMoney);
    }

    @Override
    public PayMoney selectPayMoneyById(Integer id) {
        return payMoneyMapper.selectPayMoneyById(id);
    }

    @Override
    public int UpdatePayMoney(PayMoney payMoney) {
        return payMoneyMapper.UpdatePayMoney(payMoney);
    }

    @Override
    public int DeletePayMoney(Integer id) {
        return payMoneyMapper.DeletePayMoney(id);
    }
    @Override
    public int buyPayMoney(UserPayMoney userPayMoney){
        return payMoneyMapper.buyPayMoney(userPayMoney);
    }
}
