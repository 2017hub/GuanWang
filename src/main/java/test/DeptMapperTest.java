package test;

import com.guanwang.dao.mapper.DeptMapper;
import com.guanwang.entity.Dept;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.InputStream;

public class DeptMapperTest {
    @Test
    public void testSelectDeptById() throws IOException {
        //（1）获取sqlsessionFactory对象
        String resource = "mybatis-config.xml";
        InputStream inputStream = null;

        inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        //(2)获取sqlsession对象
        SqlSession sqlSession =sqlSessionFactory.openSession();
        try {
            DeptMapper deptMapper =sqlSession.getMapper(DeptMapper.class);
            Dept dept = deptMapper.getDeptById(2);
            System.out.println("----------->"+dept.getdName());
            sqlSession.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            sqlSession.close();
        }


    }

    //测试关联查询，查询部门的同时查询对应所有员工
    @Test
    public void testDeptAndEmpById() throws IOException {
        //（1）获取sqlsessionFactory对象
        String resource = "mybatis-config.xml";
        InputStream inputStream = null;

        inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        //(2)获取sqlsession对象
        SqlSession sqlSession =sqlSessionFactory.openSession();
        try {
            DeptMapper deptMapper =sqlSession.getMapper(DeptMapper.class);

           Dept dept= deptMapper.getDeptAndEmpById(1);
            System.out.println("-------------->"+dept.getdName()+"-----"+dept.getEmps());
            //(3)、事务提交
            sqlSession.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            sqlSession.close();
        }


    }
}
