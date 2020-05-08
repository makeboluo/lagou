package com.lagou.dao;

import com.lagou.entity.User;

public interface UserDao {
    int add(User user);
    int updateById(User user);
    int deleteById(int id);
}
