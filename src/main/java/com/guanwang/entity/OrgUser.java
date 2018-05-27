package com.guanwang.entity;


import org.hibernate.validator.constraints.Email;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Pattern;

public class OrgUser {
    @Pattern(regexp="[\\u4e00-\\u9fa5]{4,10}",message = "* 昵称，为4~10个汉字！")
    private String nick;//昵称

    @Pattern(regexp = "\\w{3,6}",message = "* 密码为3~6个数字")
    private String password;//密码

    @Pattern(regexp = "1[3578]\\d{9}",message = "* 请输入正确的手机号！")
    private String phone;//手机号

    @Email
    private String emaile;//邮箱

    @Min(value = 1,message = "最小为1岁")
    @Max(value = 150,message = "最大为150岁")
    private Integer age;//年龄

    public OrgUser() {
    }

    public String getNick() {
        return nick;
    }

    public void setNick(String nick) {
        this.nick = nick;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmaile() {
        return emaile;
    }

    public void setEmaile(String emaile) {
        this.emaile = emaile;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "OrgUser{" +
                "nick='" + nick + '\'' +
                ", password='" + password + '\'' +
                ", phonr='" + phone+ '\'' +
                ", emaile='" + emaile + '\'' +
                ", age=" + age +
                '}';
    }
}
