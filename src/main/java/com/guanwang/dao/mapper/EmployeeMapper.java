package com.guanwang.dao.mapper;

import com.guanwang.entity.Employee;
import org.apache.ibatis.annotations.MapKey;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface EmployeeMapper {

    //动态SQL语句的批量插入
    public void addEmployees(@Param("epms") List<Employee> epms);

    //动态SQL语句添加员工
    public void addEmpsById(Employee employee);

    //动态sql查询员工
    public Employee selectEmployees(Employee employee);

    //根据部门id查询部门下的所有员工
    public List<Employee> getEmpByDeptId(int dId);
    //分步查询
    public Employee getEmpByStep(int eId);

    //联合查询的另一种方式
    public Employee getEmployeeAndDeptById(int eId);

    //联合查询员工信息和与之对应的部门信息
    public Employee getEmpAndDeptById(int eId);

    //测试自定义返回值
    public Employee selectEmpById(int eId);

    //返回一个对条记录的map,Map<Integer,Employee> 主键值作为Integer,需要在方法上面添加@MapKey("id")
    @MapKey("eId")
    public Map<Integer,Employee> getEmpMapByName(String name);

    //返回一条记录map,key为列名，值就是对应的值
    public Map<String ,Object> getEmpMapById(int  eId);

    /**
     * 查询返回类型为List集合
     */

    public List<Employee> getEmpListByName(String name);

    /**
     * 数据不是业务模型的，直接转入一个map
     * @param eId
     * @return
     */
    public Employee selectEmpMap(Map<String ,Object> map);

    //查询
    public Employee selectEmployeeById(int eId);

    //增加
    public void addEmployee(Employee employee);

    //删除
    public void delEmployee(int eId);

    //修改
    public void updateEmplyee(Employee employee);
}
