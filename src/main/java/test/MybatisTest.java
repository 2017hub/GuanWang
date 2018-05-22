package test;

import com.guanwang.dao.mapper.EmployeeMapper;
import com.guanwang.dao.mapper.UserMapper;
import com.guanwang.entity.Dept;
import com.guanwang.entity.Employee;
import com.guanwang.entity.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.InputStream;

import java.sql.Timestamp;
import java.util.*;

public class MybatisTest {
    /**
     *（1）根据配置文件创建一个sqlSessionFactory对象
     * @throws IOException
     */
//    @Test
//   public  void testMybatis() {
//
//        String resource = "mybatis-config.xml";
//        InputStream inputStream = null;
//
//        try {
//            inputStream = Resources.getResourceAsStream(resource);
//            SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
//
//            //获取sqlSession实例
//             SqlSession sqlSession=sqlSessionFactory.openSession();
//            User user =sqlSession.selectOne("com.guanwang.entity.selectUser","1233242343232");
//            System.out.println("------------"+user.getUserName()+"-----"+user.getLoginTmie());
//        } catch (IOException e) {
//            e.printStackTrace();
//        }finally {
////            sqlSession.close();
//        }
//
//
//   }

    /**
     * 测试接口方式查询
     */
    @Test
    public void testInterface() throws IOException {
        //（1）获取sqlsessionFactory对象
        String resource = "mybatis-config.xml";
        InputStream inputStream = null;

            inputStream = Resources.getResourceAsStream(resource);
            SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
            //(2)获取sqlsession对象
            SqlSession sqlSession =sqlSessionFactory.openSession();
        try {
            UserMapper userMapper =sqlSession.getMapper(UserMapper.class);
           User user=userMapper.selectUserById("1233242343232");
            System.out.println("interface------"+user.getUserName()+"----"+user.getLoginTmie());
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            sqlSession.close();
        }



    }
    @Test
    public void testEmployeeMapper() throws IOException {
        //（1）获取sqlsessionFactory对象
        String resource = "mybatis-config.xml";
        InputStream inputStream = null;

        inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        //(2)获取sqlsession对象
        SqlSession sqlSession =sqlSessionFactory.openSession();
        try {
            EmployeeMapper employeeMapper =sqlSession.getMapper(EmployeeMapper.class);
            Employee employee =employeeMapper.selectEmployeeById(1);
            System.out.println("interface------"+employee.getUsername()+"---"+employee.getJobDate());
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            sqlSession.close();
        }
    }


    /**
     * 测试增删改
     */
    @Test
    public void testEmpMapper() throws IOException {
       //(1)获取sqlSessionFactory对象
       String resource="mybatis-config.xml" ;
        InputStream inputStream=Resources.getResourceAsStream(resource);
       SqlSessionFactory sqlSessionFactory= new SqlSessionFactoryBuilder().build(inputStream);

       //(2)获取sqlSession对象(sqlsession不带参数的不能自动提交事务，需要手动添加)
        SqlSession sqlSession=sqlSessionFactory.openSession();
        try {


        //（3）获取代理对象
        EmployeeMapper employeeMapper=sqlSession.getMapper(EmployeeMapper.class);

        //new Employee类
        Employee employee=new Employee();
      //  employee.seteId(3);
        employee.setUsername("hapyy");
        employee.setPwd("123456");
        employee.setIphone("15287990999");
        employee.setEmaile("happy@qq.com");
        String date="2018-04-20 09:10:03";
        Timestamp timestamp=Timestamp.valueOf(date);
        employee.setJobDate(timestamp);
        employee.setAddress("贵阳市会展城会展南路89号");
        //调用增加方法
            employeeMapper.addEmployee(employee);
            System.out.println("-----获取自增主键------"+employee.geteId());
            //调用修改方法
       // employeeMapper.updateEmplyee(employee);
            //调用删除方法
          //  employeeMapper.delEmployee(3);
        //(4)提交事务
        sqlSession.commit();

        }finally {
            sqlSession.close();
        }
    }

    /**
     * 测试转入参数不是数据模型，而是转入map集合参数
     */

    @Test
    public void testEmpMap() throws IOException {
        //(1)获取sqlSessionFactory对象
        String resource="mybatis-config.xml" ;
        InputStream inputStream=Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory= new SqlSessionFactoryBuilder().build(inputStream);

        //(2)获取sqlSession对象(sqlsession不带参数的不能自动提交事务，需要手动添加)
        SqlSession sqlSession=sqlSessionFactory.openSession();
        try {


            //（3）获取代理对象
            EmployeeMapper employeeMapper=sqlSession.getMapper(EmployeeMapper.class);

            //转入的是一个集合map
            Map<String,Object> map=new HashMap<String ,Object>();
                                map.put("eId",1);
                                map.put("username","wenjie");
                                map.put("iphone","15285678970");

            //调用方法
            Employee employee=employeeMapper.selectEmpMap(map);
            System.out.println("-----map------"+employee.geteId()+"名字："+employee.getUsername());
            //调用修改方法
            // employeeMapper.updateEmplyee(employee);
            //调用删除方法
            //  employeeMapper.delEmployee(3);
            //(4)提交事务
            sqlSession.commit();

        }finally {
            sqlSession.close();
        }
    }


    /**
     * 测试查询返回list集合
     */

    @Test
    public void testEmpList() throws IOException {
        //(1)获取sqlSessionFactory对象
        String resource="mybatis-config.xml" ;
        InputStream inputStream=Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory= new SqlSessionFactoryBuilder().build(inputStream);

        //(2)获取sqlSession对象(sqlsession不带参数的不能自动提交事务，需要手动添加)
        SqlSession sqlSession=sqlSessionFactory.openSession();
        try {


            //（3）获取代理对象
            EmployeeMapper employeeMapper=sqlSession.getMapper(EmployeeMapper.class);


            String name="%w%";
            //调用方法
           List<Employee> list=employeeMapper.getEmpListByName(name);
            for (Employee em:list) {
                System.out.println("______"+em.getUsername());
            }
            //调用修改方法
            // employeeMapper.updateEmplyee(employee);
            //调用删除方法
            //  employeeMapper.delEmployee(3);
            //(4)提交事务
            sqlSession.commit();

        }finally {
            sqlSession.close();
        }
    }


    //测试查询返回值Map集合
    @Test
    public void testEmpployeeMap() throws IOException {
        //(1)获取sqlSessionFactory对象
        String resource="mybatis-config.xml" ;
        InputStream inputStream=Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory= new SqlSessionFactoryBuilder().build(inputStream);

        //(2)获取sqlSession对象(sqlsession不带参数的不能自动提交事务，需要手动添加)
        SqlSession sqlSession=sqlSessionFactory.openSession();
        try {

            //（3）获取代理对象
            EmployeeMapper employeeMapper=sqlSession.getMapper(EmployeeMapper.class);
                  Map<String,Object> map = employeeMapper.getEmpMapById(1);
                  System.out.println("-----mapById-----"+map);


            //(4)提交事务
            sqlSession.commit();

        }finally {
            sqlSession.close();
        }
    }


    //测试查询返回多条Map集合
    @Test
    public void testEmpByName() throws IOException {
        //(1)获取sqlSessionFactory对象
        String resource="mybatis-config.xml" ;
        InputStream inputStream=Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory= new SqlSessionFactoryBuilder().build(inputStream);

        //(2)获取sqlSession对象(sqlsession不带参数的不能自动提交事务，需要手动添加)
        SqlSession sqlSession=sqlSessionFactory.openSession();
        try {

            //（3）获取代理对象
            EmployeeMapper employeeMapper=sqlSession.getMapper(EmployeeMapper.class);

            Map<Integer,Employee> mapByName =employeeMapper.getEmpMapByName("%w%");
            System.out.println("----------------"+mapByName);
            //(4)提交事务
            sqlSession.commit();

        }finally {
            sqlSession.close();
        }
    }

//测试自定义返回值
@Test
public void testEmpResultMap() throws IOException {
    //(1)获取sqlSessionFactory对象
    String resource = "mybatis-config.xml";
    InputStream inputStream = Resources.getResourceAsStream(resource);
    SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

    //(2)获取sqlSession对象(sqlsession不带参数的不能自动提交事务，需要手动添加)
    SqlSession sqlSession = sqlSessionFactory.openSession();
    try {

        //（3）获取代理对象
        EmployeeMapper employeeMapper = sqlSession.getMapper(EmployeeMapper.class);

        Employee employee = employeeMapper.selectEmpById(1);
        System.out.println("-----------------" + employee.getUsername());
        //(4)提交事务
        sqlSession.commit();

    } finally {
        sqlSession.close();
    }
}

    //测试联合查询
    @Test
    public void testEmpAndDept() throws IOException {
        //(1)获取sqlSessionFactory对象
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        //(2)获取sqlSession对象(sqlsession不带参数的不能自动提交事务，需要手动添加)
        SqlSession sqlSession = sqlSessionFactory.openSession();
        try {

            //（3）获取代理对象
            EmployeeMapper employeeMapper = sqlSession.getMapper(EmployeeMapper.class);

            //联合查询
            Employee employee=employeeMapper.getEmpAndDeptById(1);
            System.out.println("-------------->"+employee.getUsername());
            System.out.println("---------------->"+employee.getDept().getdId()+"====="+employee.getDept().getdName());
            //(4)提交事务
            sqlSession.commit();

        } finally {
            sqlSession.close();
        }
    }


    //测试联合查询的另一种方式
    @Test
    public void testEmployeeAndDept() throws IOException {
        //(1)获取sqlSessionFactory对象
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        //(2)获取sqlSession对象(sqlsession不带参数的不能自动提交事务，需要手动添加)
        SqlSession sqlSession = sqlSessionFactory.openSession();
        try {

            //（3）获取代理对象
            EmployeeMapper employeeMapper = sqlSession.getMapper(EmployeeMapper.class);

            //联合查询
            Employee employee=employeeMapper.getEmployeeAndDeptById(1);
            System.out.println("-------------->"+employee.getUsername());
            System.out.println("---------------->"+employee.getDept().getdId()+"====="+employee.getDept().getdName());
            //(4)提交事务
            sqlSession.commit();

        } finally {
            sqlSession.close();
        }
    }


    //测试分步查询
    @Test
    public void testEmpByStep() throws IOException {
        //(1)获取sqlSessionFactory对象
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        //(2)获取sqlSession对象(sqlsession不带参数的不能自动提交事务，需要手动添加)
        SqlSession sqlSession = sqlSessionFactory.openSession();
        try {

            //（3）获取代理对象
            EmployeeMapper employeeMapper = sqlSession.getMapper(EmployeeMapper.class);

            //分步查询
           Employee employee=employeeMapper.getEmpByStep(2);
            System.out.println("------------->"+employee.getUsername()+"---->"+employee.getDept().getdName());
            //(4)提交事务
            sqlSession.commit();

        } finally {
            sqlSession.close();
        }
    }

//测试根据部门Id查询部门对应的所有的员工
@Test
public void testEmpBydeptId() throws IOException {
    //(1)获取sqlSessionFactory对象
    String resource = "mybatis-config.xml";
    InputStream inputStream = Resources.getResourceAsStream(resource);
    SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

    //(2)获取sqlSession对象(sqlsession不带参数的不能自动提交事务，需要手动添加)
    SqlSession sqlSession = sqlSessionFactory.openSession();
    try {

        //（3）获取代理对象
        EmployeeMapper employeeMapper = sqlSession.getMapper(EmployeeMapper.class);

        List<Employee> list=employeeMapper.getEmpByDeptId(1);

        for (int i = 0; i < list.size(); i++) {
            System.out.println("--------->"+list.get(i).getUsername());
        }
        //(4)提交事务
        sqlSession.commit();

    } finally {
        sqlSession.close();
    }
}


    //测试动态SQl查询条件choose
    @Test
    public void testChoose() throws IOException {
        //(1)获取sqlSessionFactory对象
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        //(2)获取sqlSession对象(sqlsession不带参数的不能自动提交事务，需要手动添加)
        SqlSession sqlSession = sqlSessionFactory.openSession();
        try {

            //（3）获取代理对象
            EmployeeMapper employeeMapper = sqlSession.getMapper(EmployeeMapper.class);
                Employee employee=new Employee();
               // employee.seteId(0);
                employee.setUsername("wenjie");
                employee.setIphone("15285678970");
                Employee emps=employeeMapper.selectEmployees(employee);
                System.out.println("-------->"+emps.getUsername());
            //(4)提交事务
            sqlSession.commit();

        } finally {
            sqlSession.close();
        }
    }



    //测试动态SQl增加员工
    @Test
    public void testAddEmp() throws IOException {
        //(1)获取sqlSessionFactory对象
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        //(2)获取sqlSession对象(sqlsession不带参数的不能自动提交事务，需要手动添加)
        SqlSession sqlSession = sqlSessionFactory.openSession();
        try {

            //（3）获取代理对象
            EmployeeMapper employeeMapper = sqlSession.getMapper(EmployeeMapper.class);
            Employee employee=new Employee();
            employee.seteId(7);
            employee.setUsername("setHello");
            employee.setIphone("15285678111");
            employeeMapper.addEmpsById(employee);

            //(4)提交事务
            sqlSession.commit();

        } finally {
            sqlSession.close();
        }
    }


    //测试动态SQl批量添加
    @Test
    public void testAddEmployees() throws IOException {
        //(1)获取sqlSessionFactory对象
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        //(2)获取sqlSession对象(sqlsession不带参数的不能自动提交事务，需要手动添加)
        SqlSession sqlSession = sqlSessionFactory.openSession();
        try {

            //（3）获取代理对象
            EmployeeMapper employeeMapper = sqlSession.getMapper(EmployeeMapper.class);
            Employee employee=new Employee();
            employee.setUsername("jerry");
            employee.setIphone("15285678111");
            employee.setPwd("123456");
            employee.setEmaile("123456@qq.com");
            String date="2018-05-09 13:34:00";
            Timestamp timestamp=Timestamp.valueOf(date);
            employee.setJobDate(timestamp);
            employee.setAddress("贵阳市云岩区22号");
            Dept dept=new Dept();
            dept.setdId(1);
            employee.setDept(dept);

            Employee employee1=new Employee();
            employee1.setUsername("wang");
            employee1.setIphone("15285670099");
            employee1.setPwd("123456");
            employee1.setEmaile("123456@qq.com");
            String date1="2018-05-09 13:34:00";
            Timestamp timestamp1=Timestamp.valueOf(date1);
            employee1.setJobDate(timestamp1);
            employee1.setAddress("贵阳市云岩区26号");
            Dept dept1=new Dept();
            dept1.setdId(1);
            employee1.setDept(dept1);

            List<Employee> epms=new ArrayList<>();
            epms.add(employee);
            epms.add(employee1);
            employeeMapper.addEmployees(epms);

            //(4)提交事务
            sqlSession.commit();

        } finally {
            sqlSession.close();
        }
    }
}
