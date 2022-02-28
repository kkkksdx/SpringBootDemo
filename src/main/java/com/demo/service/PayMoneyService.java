package com.demo.service;

import com.demo.pojo.PayMoney;
import com.demo.pojo.UserPayMoney;

import java.util.List;

public interface PayMoneyService {
    public List<PayMoney> selectPayMoneyAll();
    public int addPayMoney(PayMoney payMoney);
    public PayMoney selectPayMoneyById(Integer id);
    public int UpdatePayMoney(PayMoney payMoney);
    public int DeletePayMoney(Integer id);
    public int buyPayMoney(UserPayMoney userPayMoney);
}
