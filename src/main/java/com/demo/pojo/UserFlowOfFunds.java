package com.demo.pojo;

import java.math.BigDecimal;
import java.util.Date;

public class UserFlowOfFunds {
    private Integer id;
    private Integer userId;
    private BigDecimal flowmoney;
    private Integer type;
    private String source;
    private Date createtime;
    private String funddesc;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public BigDecimal getFlowmoney() {
        return flowmoney;
    }

    public void setFlowmoney(BigDecimal flowmoney) {
        this.flowmoney = flowmoney;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    public String getFunddesc() {
        return funddesc;
    }

    public void setFunddesc(String funddesc) {
        this.funddesc = funddesc;
    }

    @Override
    public String toString() {
        return "UserFlowOfFunds{" +
                "id=" + id +
                ", userId=" + userId +
                ", flowmoney=" + flowmoney +
                ", type=" + type +
                ", source='" + source + '\'' +
                ", createtime=" + createtime +
                ", funddesc='" + funddesc + '\'' +
                '}';
    }
    public UserFlowOfFunds(){

    }
}
