package com.demo.pojo;

import java.util.Date;

public class UserInfo {
    Integer id;
    Integer sendId;
    Integer receiveId;
    Date createtime;
    String title;
    String infodesc;
    Integer status;
    String username;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getSendId() {
        return sendId;
    }

    public void setSendId(Integer sendId) {
        this.sendId = sendId;
    }

    public Integer getReceiveId() {
        return receiveId;
    }

    public void setReceiveId(Integer receiveId) {
        this.receiveId = receiveId;
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getInfodesc() {
        return infodesc;
    }

    public void setInfodesc(String infodesc) {
        this.infodesc = infodesc;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public String toString() {
        return "UserInfo{" +
                "id=" + id +
                ", sendId=" + sendId +
                ", receiveId=" + receiveId +
                ", createtime=" + createtime +
                ", title='" + title + '\'' +
                ", infodesc='" + infodesc + '\'' +
                ", status=" + status +
                ", username='" + username + '\'' +
                '}';
    }
    public UserInfo(){

    }
}
