package com.lagou.test;

import com.lagou.dao.IUserDao;
import com.lagou.io.Resources;
import com.lagou.pojo.User;
import com.lagou.sqlSession.SqlSession;
import com.lagou.sqlSession.SqlSessionFactory;
import com.lagou.sqlSession.SqlSessionFactoryBuilder;
import org.dom4j.DocumentException;
import org.junit.Test;

import java.beans.PropertyVetoException;
import java.io.InputStream;
import java.util.List;

public class IPersistenceTest {
    private SqlSession getSqlSession(){
        InputStream resourceAsSteam = Resources.getResourceAsSteam("sqlMapConfig.xml");
        SqlSessionFactory sqlSessionFactory = null;
        try {
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsSteam);
        } catch (DocumentException e) {
            e.printStackTrace();
        } catch (PropertyVetoException e) {
            e.printStackTrace();
        }
        SqlSession sqlSession = sqlSessionFactory.openSession();
        return sqlSession;
    }

    @Test
    public void test() throws Exception {
        InputStream resourceAsSteam = Resources.getResourceAsSteam("sqlMapConfig.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsSteam);
        SqlSession sqlSession = sqlSessionFactory.openSession();

        //调用
        User user = new User();
        user.setId(1);
        user.setUsername("张三");
        IUserDao userDao = sqlSession.getMapper(IUserDao.class);

        User user2 = userDao.findByCondition(user);
        System.out.println("findByCondition=="+user2);

        List<User> all = userDao.findAll();
        for (User user1 : all) {
            System.out.println(user1);
        }


    }

    @Test
    public void addUser() {
        SqlSession sqlSession = getSqlSession();
        IUserDao userDao = sqlSession.getMapper(IUserDao.class);
        User user = new User();
        user.setUsername("李四");
        int result = userDao.add(user);
        System.out.println("add==="+result);
    }


    @Test
    public void updateUserById(){
        SqlSession sqlSession = getSqlSession();
        IUserDao userDao = sqlSession.getMapper(IUserDao.class);
        User user = new User();
        user.setId(2);
        user.setUsername("王五");
        int result = userDao.updateById(user);
        System.out.println("update==="+result);
    }

    @Test
    public void deleteUserById(){
        SqlSession sqlSession = getSqlSession();
        IUserDao userDao = sqlSession.getMapper(IUserDao.class);
        User user = new User();
        user.setId(2);
        int result = userDao.deleteById(user);
        System.out.println("delete==="+result);
    }

}
