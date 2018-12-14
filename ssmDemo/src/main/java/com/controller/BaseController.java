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

import com.alibaba.fastjson.JSON;
import com.entity.User;
import com.service.IUserService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 〈一句话功能简述〉<br>
 * 〈controller基础类〉
 *
 * @author Administrator
 * @create 2018/8/17
 * @since 1.0.0
 */
@Controller
@RequestMapping("/test")
public class BaseController {

    protected final Logger logger = Logger.getLogger(this.getClass());

    @Autowired
    private IUserService useService;


    @RequestMapping("/testPage")
    public String testPage(Model model, HttpServletRequest request) {
        model.addAttribute("key","value");
        request.getParameter("key");
        return "/testPage";
    }

    @RequestMapping("/userInfo")
    public String testUser(Model model, HttpServletRequest request) {
        User user = useService.getUserInfo(1);
        String result = user.toString();
        model.addAttribute("userInfo", result);
        return "/testPage";
    }

    @RequestMapping("/userList")
    public String testUserAll(Model model, HttpServletRequest request) {
        List<User> list = useService.selectAllUserInfo();
        model.addAttribute("userList", list);
        return "/testPage";
    }

    @RequestMapping(value = "/login",method = RequestMethod.GET)
    public String init(Model model, HttpServletRequest request) {
        return "login";
    }

    @RequestMapping(value = "/doLogin", method = RequestMethod.POST)
    public void testUserLogin(Model model, HttpServletRequest request, HttpServletResponse response) {
        Map<String,String> result = new HashMap<String,String>();
        String loginName = request.getParameter("userName");
        String passWord = request.getParameter("passWord");
        logger.info("loginName:" + loginName + ",password:" + passWord);
        List<User> list = useService.selectAllUserInfo();
        for (User temp : list) {
            if (temp.getUserName().equals(loginName)) {
                model.addAttribute("user", temp);
            }
            logger.info(temp.getUserName()+"_"+temp.getId()+"_"+temp.getPassword());
        }
        result.put("result","success");
        setResponse(result,response);
        return;
    }

    @RequestMapping(value = "/indexPage",method = RequestMethod.GET)
    public String indexPage(Model model, HttpServletRequest request){
        model.addAttribute("pageTitle","登陆主页");
        return "indexPage";
    }

    public void setResponse(Object obj,HttpServletResponse response){
        try {
            response.setContentType("test/json;charset=utf-8");
            String str = JSON.toJSONString(obj);
            PrintWriter writer = response.getWriter();
            writer.print(str);
            writer.flush();
            writer.close();
        } catch (Exception e) {
            logger.error("应答出错",e);
        }
    }
}