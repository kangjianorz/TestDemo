package com.service;

import com.entity.User;

import java.util.List;

public interface IUserService {
    public User getUserInfo(int userId);

    public List<User> selectAllUserInfo();
}
