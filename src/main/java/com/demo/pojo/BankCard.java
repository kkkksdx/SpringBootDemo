package com.demo.pojo;

public class BankCard {
    private Integer id;
    private String cardbank;
    private Integer type;
    private String cardnum;
    private Integer userId;
    private String username;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCardbank() {
        return cardbank;
    }

    public void setCardbank(String cardbank) {
        this.cardbank = cardbank;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getCardnum() {
        return cardnum;
    }

    public void setCardnum(String cardnum) {
        this.cardnum = cardnum;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public String toString() {
        return "BankCard{" +
                "id=" + id +
                ", cardbank='" + cardbank + '\'' +
                ", type=" + type +
                ", cardnum='" + cardnum + '\'' +
                ", userId=" + userId +
                ", username='" + username + '\'' +
                '}';
    }

    public BankCard(){

    }
}
