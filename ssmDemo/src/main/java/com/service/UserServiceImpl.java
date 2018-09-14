package com.service;

import com.dao.UserMapper;
import com.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl implements IUserService{

    @Autowired
    private UserMapper userDao;

    @Override
    public User getUserInfo(int userId) {
        User userInfo = userDao.selectByPrimaryKey(userId);
        return userInfo;
    }

    @Override
    public List<User> selectAllUserInfo(){

        List<User> list = userDao.selectAllUserInfo();
        if(list == null){
            return null;
        }
        return list;
    }

}
