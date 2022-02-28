package com.demo.service.impl;

import com.demo.mapper.TermFinancialMapper;
import com.demo.pojo.TermFinancial;
import com.demo.pojo.UserTermFinacial;
import com.demo.service.TermFinancialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TermFinancialServiceImpl implements TermFinancialService {
    @Autowired
    private TermFinancialMapper termFinancialMapper;

    @Override
    public List<TermFinancial> selectTermFinancialAll() {
        return termFinancialMapper.selectTermFinancialAll();
    }

    @Override
    public int addTermFinancial(TermFinancial termFinancial) {
        return termFinancialMapper.addTermFinancial(termFinancial);
    }

    @Override
    public TermFinancial selectTermFinancialById(Integer id) {
        return termFinancialMapper.selectTermFinancialById(id);
    }

    @Override
    public int UpdateTermFinancial(TermFinancial termFinancial) {
        return termFinancialMapper.UpdateTermFinancial(termFinancial);
    }

    @Override
    public int deleteTermFinancial(TermFinancial termFinancial) {
        return termFinancialMapper.deleteTermFinancial(termFinancial);
    }
    @Override
    public int buyTermFinancial(UserTermFinacial userTermFinacial){
        return termFinancialMapper.buyTermFinancial(userTermFinacial);
    }
}
