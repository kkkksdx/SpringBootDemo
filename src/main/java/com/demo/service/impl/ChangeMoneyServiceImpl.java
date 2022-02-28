package com.demo.service.impl;

import com.demo.mapper.ChangeMoneyMapper;
import com.demo.pojo.ChangeMoney;
import com.demo.pojo.UserChangeMoney;
import com.demo.service.ChangeMoneyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ChangeMoneyServiceImpl implements ChangeMoneyService {
    @Autowired
    private ChangeMoneyMapper changeMoneyMapper;

    @Override
    public List<ChangeMoney> selectChangeMoneyAll() {
        return changeMoneyMapper.selectChangeMoneyAll();
    }

    @Override
    public int addChangeMoney(ChangeMoney changeMoney) {
        return changeMoneyMapper.addChangeMoney(changeMoney);
    }

    @Override
    public ChangeMoney selectChangeMoneyById(Integer id) {
        return changeMoneyMapper.selectChangeMoneyById(id);
    }

    @Override
    public int UpdateChangeMoney(ChangeMoney changeMoney) {
        return changeMoneyMapper.UpdateChangeMoney(changeMoney);
    }

    @Override
    public int deleteChangeMoney(ChangeMoney changeMoney) {
        return changeMoneyMapper.deleteChangeMoney(changeMoney);
    }
    @Override
    public int buyChangeMoney(UserChangeMoney userChangeMoney){
        return changeMoneyMapper.buyChangeMoney(userChangeMoney);
    }
}
