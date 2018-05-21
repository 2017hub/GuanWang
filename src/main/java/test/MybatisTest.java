package test;

import com.guanwang.dao.mapper.EmployeeMapper;
import com.guanwang.dao.mapper.UserMapper;
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
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

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
                                map.put("eId",2);

            //调用增加方法
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


}
