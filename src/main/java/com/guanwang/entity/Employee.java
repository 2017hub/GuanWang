package com.guanwang.entity;

import java.sql.Timestamp;

public class Employee {
    private int eId;
    private String username;
    private String pwd;
    private String iphone;
    private String emaile;
    private Timestamp jobDate;
    private String address;
    private Dept dept;

    public Employee() {
    }

    public Dept getDept() {
        return dept;
    }

    public void setDept(Dept dept) {
        this.dept = dept;
    }

    public int geteId() {
        return eId;
    }

    public void seteId(int eId) {
        this.eId = eId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public String getIphone() {
        return iphone;
    }

    public void setIphone(String iphone) {
        this.iphone = iphone;
    }

    public String getEmaile() {
        return emaile;
    }

    public void setEmaile(String emaile) {
        this.emaile = emaile;
    }

    public Timestamp getJobDate() {
        return jobDate;
    }

    public void setJobDate(Timestamp jobDate) {
        this.jobDate = jobDate;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
