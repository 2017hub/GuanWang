package com.guanwang.entity;

import java.sql.Timestamp;

public class User {
    private String userId;
    private String userName;
    private String pwd;
    private Timestamp loginTmie;
    private String logoutTime;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public Timestamp getLoginTmie() {
        return loginTmie;
    }

    public void setLoginTmie(Timestamp loginTmie) {
        this.loginTmie = loginTmie;
    }

    public String getLogoutTime() {
        return logoutTime;
    }

    public void setLogoutTime(String logoutTime) {
        this.logoutTime = logoutTime;
    }
}
