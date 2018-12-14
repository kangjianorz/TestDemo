package com.dao.impl;

import com.dao.UserDao;
import com.entity.User;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserDaoImpl implements UserDao {


    @Override
    public User selectByPrimaryKey(Integer id) {
        return null;
    }

    @Override
    public List<User> selectAllUserInfo() {
        return null;
    }
}
