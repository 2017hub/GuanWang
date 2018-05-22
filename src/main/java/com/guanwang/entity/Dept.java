package com.guanwang.entity;

import java.util.List;

public class Dept {
    private int dId;
    private String dName;
    //查询部门时候，把部门下的所有员工查询出来
    private List<Employee> emps;

    public Dept() {
    }

    public List<Employee> getEmps() {
        return emps;
    }

    public void setEmps(List<Employee> emps) {
        this.emps = emps;
    }

    public int getdId() {
        return dId;
    }

    public void setdId(int dId) {
        this.dId = dId;
    }

    public String getdName() {
        return dName;
    }

    public void setdName(String dName) {
        this.dName = dName;
    }
}
