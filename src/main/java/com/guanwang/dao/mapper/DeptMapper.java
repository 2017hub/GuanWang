package com.guanwang.dao.mapper;

import com.guanwang.entity.Dept;

public interface DeptMapper {
    //查询
    public Dept getDeptById(int dId);

    //关联查询，查询部门时候，需要查询部门下面的所有员工
    public Dept getDeptAndEmpById(int dId);

    //分步查询部门对应的所有员工
    public Dept getDeptAndEmpByStep(int dId);
}
