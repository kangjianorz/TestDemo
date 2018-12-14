package com.Dao;

import com.Entity.LoginUser;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public interface LoginUserMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(LoginUser record);

    int insertSelective(LoginUser record);

    LoginUser selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(LoginUser record);

    int updateByPrimaryKey(LoginUser record);

//    LoginUser selectByUser(LoginUser user);

    LoginUser selecByUserNameAndPassword(Map<String,String> hashMap);
}