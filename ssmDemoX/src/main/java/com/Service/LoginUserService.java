package com.Service;

import com.Constant.Constant;
import com.Dao.LoginUserMapper;
import com.Entity.LoginUser;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.Map;

@Service
@Transactional
public class LoginUserService {

    protected final Logger logger = Logger.getLogger(Constant.PROJECT_LOG);

    @Autowired
    private LoginUserMapper loginUserDao;


    public LoginUser getUser(Integer id){
        LoginUser user = loginUserDao.selectByPrimaryKey(id);
        return user;
    }

    /**
     * 根据用户名、密码确认用户
     * @param userName
     * @param passWord
     * @return
     */
    public LoginUser getUserNameAndPassword(String userName, String passWord){
        logger.info("根据用户名，密码查询用户信息"+"userName = "+userName+",passWord= "+passWord);
//        LoginUser user = loginUserDao.selecByUserNameAndPassword(userName, password);
        Map<String,String> hashMap = new HashMap<String, String>();
        hashMap.put("userName",userName);
        hashMap.put("passWord",passWord);
        LoginUser user = loginUserDao.selecByUserNameAndPassword(hashMap);
        logger.info("查询结果为："+user.toString());
        return user;
    }

//    public LoginUser getUserByuser(LoginUser loginUser){
//        LoginUser user = loginUserDao.selectByUser(loginUser);
//        return user;
//    }
}
