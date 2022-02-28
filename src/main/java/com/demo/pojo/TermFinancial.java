package com.demo.pojo;

import java.math.BigDecimal;

public class TermFinancial {
    Integer id;
    String name;
    String investerm;
    BigDecimal leastmoney;
    Integer profit;
    BigDecimal annualincome;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getInvesterm() {
        return investerm;
    }

    public void setInvesterm(String investerm) {
        this.investerm = investerm;
    }

    public BigDecimal getLeastmoney() {
        return leastmoney;
    }

    public void setLeastmoney(BigDecimal leastmoney) {
        this.leastmoney = leastmoney;
    }

    public Integer getProfit() {
        return profit;
    }

    public void setProfit(Integer profit) {
        this.profit = profit;
    }

    public BigDecimal getAnnualincome() {
        return annualincome;
    }

    public void setAnnualincome(BigDecimal annualincome) {
        this.annualincome = annualincome;
    }

    @Override
    public String toString() {
        return "TermFinancial{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", investerm='" + investerm + '\'' +
                ", leastmoney=" + leastmoney +
                ", profit=" + profit +
                ", annualincome=" + annualincome +
                '}';
    }

    public TermFinancial(){

    }
}
