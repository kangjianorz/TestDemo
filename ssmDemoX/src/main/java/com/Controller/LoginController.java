package com.Controller;

import com.Constant.Constant;
import com.Entity.LoginUser;
import com.Service.LoginUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/login")
public class LoginController extends BaseController {

    @Autowired
    private LoginUserService loginUserService;

    @RequestMapping(value = "/loginPage",method = RequestMethod.GET)
    public String loginPage(Model model, HttpServletRequest request) {
        logger.info("进入登录页面...");
        model.addAttribute("pageTitle","登录");
        return "loginPage";
    }

    @RequestMapping(value = "/doLogin",method = RequestMethod.POST)
    public void doLogin(Model model, HttpServletRequest request, HttpServletResponse response){
        Map<String,String> result = new HashMap<String,String>();
        String userName = request.getParameter(Constant.USER_NAME);
        String passWord = request.getParameter(Constant.PASSWORD);
        logger.info("用户输入信息====>userName:" + userName + ",password:" + passWord);

        LoginUser user = loginUserService.getUserNameAndPassword(userName,passWord);

        if(null == user){
            result.put("result","fail");
            setResponse(result,response);
            return;
        }
        result.put("result","success");
        model.addAttribute("pageTitle","登录成功");
        model.addAttribute(Constant.LOGIN_USER, user);
        request.getSession().setAttribute(Constant.LOGIN_USER, user);
        setResponse(result,response);
        return;
    }

    @RequestMapping(value = "/indexPage",method = RequestMethod.GET)
    public String indexPage(Model model, HttpServletRequest request) {
        logger.info("进入首页...");
        model.addAttribute("pageTitle","首页");
        LoginUser loginUser = (LoginUser)request.getSession().getAttribute(Constant.LOGIN_USER);
        model.addAttribute(Constant.LOGIN_USER, loginUser);
        return "indexPage";
    }

}
