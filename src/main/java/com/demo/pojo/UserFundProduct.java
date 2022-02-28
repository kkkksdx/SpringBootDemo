package com.demo.pojo;

import java.math.BigDecimal;
import java.util.Date;

public class UserFundProduct {
    private Integer id;
    private String fundDesc;
    private String code;
    private Integer fundId;
    private Integer userId;
    private Integer type;
    private String invesTerm;
    private BigDecimal leastMoney;
    private String invesMoney;
    private Date startTime;
    private BigDecimal profit;
    private BigDecimal averYield;
    private Integer status;
    private BigDecimal dailyGrowth;
    private BigDecimal monthlyGrowth;
    private BigDecimal annualGrowth;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFundDesc() {
        return fundDesc;
    }

    public void setFundDesc(String fundDesc) {
        this.fundDesc = fundDesc;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Integer getFundId() {
        return fundId;
    }

    public void setFundId(Integer fundId) {
        this.fundId = fundId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getInvesTerm() {
        return invesTerm;
    }

    public void setInvesTerm(String invesTerm) {
        this.invesTerm = invesTerm;
    }

    public BigDecimal getLeastMoney() {
        return leastMoney;
    }

    public void setLeastMoney(BigDecimal leastMoney) {
        this.leastMoney = leastMoney;
    }

    public String getInvesMoney() {
        return invesMoney;
    }

    public void setInvesMoney(String invesMoney) {
        this.invesMoney = invesMoney;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public BigDecimal getProfit() {
        return profit;
    }

    public void setProfit(BigDecimal profit) {
        this.profit = profit;
    }

    public BigDecimal getAverYield() {
        return averYield;
    }

    public void setAverYield(BigDecimal averYield) {
        this.averYield = averYield;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public BigDecimal getDailyGrowth() {
        return dailyGrowth;
    }

    public void setDailyGrowth(BigDecimal dailyGrowth) {
        this.dailyGrowth = dailyGrowth;
    }

    public BigDecimal getMonthlyGrowth() {
        return monthlyGrowth;
    }

    public void setMonthlyGrowth(BigDecimal monthlyGrowth) {
        this.monthlyGrowth = monthlyGrowth;
    }

    public BigDecimal getAnnualGrowth() {
        return annualGrowth;
    }

    public void setAnnualGrowth(BigDecimal annualGrowth) {
        this.annualGrowth = annualGrowth;
    }

    public UserFundProduct(){

    }
}
