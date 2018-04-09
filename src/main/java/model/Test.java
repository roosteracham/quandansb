package model;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.InputStream;

public class Test {
    public static void main(String[] args) throws Exception{
        InputStream inputStream = Resources.getResourceAsStream("mybatis-config.xml");
        System.out.println("..");
        SqlSessionFactory sqlSessionFactory =
                new SqlSessionFactoryBuilder().build(inputStream);

        SqlSession sqlSession = sqlSessionFactory.openSession();
        //sqlSession.selectList("mybatis.UserMapper.select");
        User user = new User();
        user.setAge(20);
        user.setGender("male");
        user.setName("LiLy");
        sqlSession.insert("mybatis.UserMapper.save", user);
        sqlSession.commit();
        sqlSession.close();;
    }
}
