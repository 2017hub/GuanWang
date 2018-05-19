package test;

import com.guanwang.dao.mapper.UserMapper;
import com.guanwang.entity.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.InputStream;

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

}
