package com.demo.service;

import com.demo.pojo.ChangeMoney;
import com.demo.pojo.UserChangeMoney;

import java.util.List;

public interface ChangeMoneyService {
    public List<ChangeMoney> selectChangeMoneyAll();
    public int addChangeMoney(ChangeMoney changeMoney);
    public ChangeMoney selectChangeMoneyById(Integer id);
    public int UpdateChangeMoney(ChangeMoney changeMoney);
    public  int deleteChangeMoney(ChangeMoney changeMoney);
    public int buyChangeMoney(UserChangeMoney userChangeMoney);
}
