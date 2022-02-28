package com.demo.pojo;

import java.util.Date;

public class Loan {
    private Integer id;
    private Integer loanId;
    private String username;
    private Integer examineId;
    private Double amount;
    private Integer term;
    private String reputation;
    private Integer applystatus;
    private Integer loanstatus;
    private String idcard;
    private String phone;
    private Date loanTime;

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

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Integer getExamineId() {
        return examineId;
    }

    public void setExamineId(Integer examineId) {
        this.examineId = examineId;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public Integer getTerm() {
        return term;
    }

    public void setTerm(Integer term) {
        this.term = term;
    }

    public String getReputation() {
        return reputation;
    }

    public void setReputation(String reputation) {
        this.reputation = reputation;
    }

    public Integer getApplystatus() {
        return applystatus;
    }

    public void setApplystatus(Integer applystatus) {
        this.applystatus = applystatus;
    }

    public Integer getLoanstatus() {
        return loanstatus;
    }

    public void setLoanstatus(Integer loanstatus) {
        this.loanstatus = loanstatus;
    }

    public String getIdcard() {
        return idcard;
    }

    public void setIdcard(String idcard) {
        this.idcard = idcard;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Date getLoanTime() {
        return loanTime;
    }

    public void setLoanTime(Date loanTime) {
        this.loanTime = loanTime;
    }

    @Override
    public String toString() {
        return "Loan{" +
                "id=" + id +
                ", loanId=" + loanId +
                ", username='" + username + '\'' +
                ", examineId=" + examineId +
                ", amount=" + amount +
                ", term=" + term +
                ", reputation='" + reputation + '\'' +
                ", applystatus=" + applystatus +
                ", loanstatus=" + loanstatus +
                ", idcard='" + idcard + '\'' +
                ", phone='" + phone + '\'' +
                ", loanTime=" + loanTime +
                '}';
    }

    public Loan(){

    }
}
