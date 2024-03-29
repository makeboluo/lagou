package com.lagou.dao;

import com.lagou.pojo.User;

import java.util.List;

public interface IUserDao {

    //查询所有用户
    public List<User> findAll() throws Exception;


    //根据条件进行用户查询
    public User findByCondition(User user) throws Exception;

    //添加用户
    Integer add(User user);
    //根据id更新用户
    Integer updateById(User user);
    //根据id删除用户
    Integer deleteById(User user);
}
