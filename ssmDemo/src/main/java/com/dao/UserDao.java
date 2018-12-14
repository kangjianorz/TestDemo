package com.dao;

import com.entity.User;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface UserDao {

    User selectByPrimaryKey(Integer id);

    List<User>  selectAllUserInfo();

}