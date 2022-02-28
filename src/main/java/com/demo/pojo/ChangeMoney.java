package com.demo.pojo;

import java.math.BigDecimal;

public class ChangeMoney {
    Integer id;
    String name;
    BigDecimal annualincome;
    BigDecimal peiincome;
    String investerm;
    BigDecimal invesmoney;

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

    public BigDecimal getAnnualincome() {
        return annualincome;
    }

    public void setAnnualincome(BigDecimal annualincome) {
        this.annualincome = annualincome;
    }

    public BigDecimal getPeiincome() {
        return peiincome;
    }

    public void setPeiincome(BigDecimal peiincome) {
        this.peiincome = peiincome;
    }

    public String getInvesterm() {
        return investerm;
    }

    public void setInvesterm(String investerm) {
        this.investerm = investerm;
    }

    public BigDecimal getInvesmoney() {
        return invesmoney;
    }

    public void setInvesmoney(BigDecimal invesmoney) {
        this.invesmoney = invesmoney;
    }

    @Override
    public String toString() {
        return "ChangeMoney{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", annualincome=" + annualincome +
                ", peiincome=" + peiincome +
                ", investerm='" + investerm + '\'' +
                ", invesmoney=" + invesmoney +
                '}';
    }

    public ChangeMoney(){

    }
}
