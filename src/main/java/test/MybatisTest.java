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
        employee.seteId(3);
        employee.setUsername("hott");
        employee.setPwd("123456");
        employee.setIphone("15287990000");
        employee.setEmaile("hoot@qq.com");
        String date="2018-05-20 13:10:03";
        Timestamp timestamp=Timestamp.valueOf(date);
        employee.setJobDate(timestamp);
        employee.setAddress("贵阳市会展城中华中路25号");
        //调用增加方法
      // employeeMapper.addEmployee(employee);
            //调用修改方法
       // employeeMapper.updateEmplyee(employee);
            //调用删除方法
            employeeMapper.delEmployee(3);
        //(4)提交事务
        sqlSession.commit();
        }finally {
            sqlSession.close();
        }
    }

}
