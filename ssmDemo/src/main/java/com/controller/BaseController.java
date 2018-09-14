/**
 * Copyright (C), 2015-2018, XXX有限公司
 * FileName: BaseController
 * Author:   Administrator
 * Date:     2018/8/17 16:28
 * Description: controller基础类
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.controller;

import com.entity.User;
import com.service.IUserService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

/**
 * 〈一句话功能简述〉<br>
 * 〈controller基础类〉
 *
 * @author Administrator
 * @create 2018/8/17
 * @since 1.0.0
 */
@Controller
@RequestMapping("/api/test")
public class BaseController {

    protected final Logger logger = Logger.getLogger(this.getClass());

    @Autowired
    private IUserService useService;


    @RequestMapping("/testPage")
    public String testPage(Model model, HttpServletRequest request) {
        return "/testPage";
    }

    @RequestMapping("/userInfo")
    public String testUser(Model model, HttpServletRequest request){
        User user =useService.getUserInfo(1);
        String result = user.toString();
        model.addAttribute("userInfo",result);
        return "/testPage";
    }

    @RequestMapping("/userList")
    public String testUserAll(Model model, HttpServletRequest request){
        List<User> list = useService.selectAllUserInfo();
        model.addAttribute("userList",list);
        return "/testPage";
    }

    @RequestMapping("/login")
    public String testUserLogin(Model model, HttpServletRequest request){
        String loginName = request.getParameter("userName");
        String passWord = request.getParameter("passWord");
        List<User> list = useService.selectAllUserInfo();
        for(User temp : list){
            if(temp.getName().equals(loginName)){
                model.addAttribute("userList",temp);
            }
//            logger.info(temp.getName()+"_"+temp.getId()+"_"+temp.getAge());
        }
        return "index";
    }

}