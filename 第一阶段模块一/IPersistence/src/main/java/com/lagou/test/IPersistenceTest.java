package com.lagou.test;

import com.lagou.dao.UserDao;
import com.lagou.entity.User;
import com.lagou.io.Resources;
import com.lagou.sqlSession.SqlSession;
import com.lagou.sqlSession.SqlSessionFactory;
import com.lagou.sqlSession.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.InputStream;

public class IPersistenceTest {

    @Test
    public void userDaoTest() throws Exception {
        InputStream resourceAsSteam = Resources.getResourceAsSteam("sqlMapConfig.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsSteam);
        SqlSession sqlSession = sqlSessionFactory.openSession();


        UserDao userDao = sqlSession.getMapper(UserDao.class);
        User user = new User();
        user.setId(1);
        user.setUsername("张三");
        user.setPassword("123456");
        user.setBirthday("01/01");
        //添加
        userDao.add(user);

        //更新
        user.setPassword("123456789");
        userDao.updateById(user);
        //删除
         userDao.deleteById(user.getId());
    }
}
