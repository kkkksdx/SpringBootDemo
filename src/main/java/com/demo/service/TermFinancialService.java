package com.demo.service;

import com.demo.pojo.TermFinancial;
import com.demo.pojo.UserTermFinacial;


import java.util.List;

public interface TermFinancialService {
    public List<TermFinancial> selectTermFinancialAll();
    public int addTermFinancial(TermFinancial termFinancial);
    public TermFinancial selectTermFinancialById(Integer id);
    public int UpdateTermFinancial(TermFinancial termFinancial);
    public  int deleteTermFinancial(TermFinancial termFinancial);
    public int buyTermFinancial(UserTermFinacial userTermFinacial);
}
