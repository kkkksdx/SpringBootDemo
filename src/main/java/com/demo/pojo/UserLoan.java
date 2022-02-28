package com.demo.pojo;

import java.math.BigDecimal;
import java.util.Date;

public class UserLoan {
    Integer id;
    Integer loanId;
    Integer examineId;
    Date loanTime;
    BigDecimal amount;
    Integer term;
    BigDecimal rate;
    Integer applyStatus;
    Integer loanStatus;
    User user;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getLoanId() {
        return loanId;
    }

    public void setLoanId(Integer loanId) {
        this.loanId = loanId;
    }

    public Integer getExamineId() {
        return examineId;
    }

    public void setExamineId(Integer examineId) {
        this.examineId = examineId;
    }

    public Date getLoanTime() {
        return loanTime;
    }

    public void setLoanTime(Date loanTime) {
        this.loanTime = loanTime;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public Integer getTerm() {
        return term;
    }

    public void setTerm(Integer term) {
        this.term = term;
    }

    public BigDecimal getRate() {
        return rate;
    }

    public void setRate(BigDecimal rate) {
        this.rate = rate;
    }

    public Integer getApplyStatus() {
        return applyStatus;
    }

    public void setApplyStatus(Integer applyStatus) {
        this.applyStatus = applyStatus;
    }

    public Integer getLoanStatus() {
        return loanStatus;
    }

    public void setLoanStatus(Integer loanStatus) {
        this.loanStatus = loanStatus;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "UserLoan{" +
                "id=" + id +
                ", loanId=" + loanId +
                ", examineId=" + examineId +
                ", loanTime=" + loanTime +
                ", amount=" + amount +
                ", term=" + term +
                ", rate=" + rate +
                ", applyStatus=" + applyStatus +
                ", loanStatus=" + loanStatus +
                ", user=" + user +
                '}';
    }
    public UserLoan(){

    }
}
