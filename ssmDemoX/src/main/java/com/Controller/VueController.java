package com.Controller;

import com.Constant.Constant;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/vue")
public class VueController extends BaseController{

    protected final Logger logger = Logger.getLogger(Constant.PROJECT_LOG);

    @RequestMapping(value = "/loginPage",method = RequestMethod.GET)
    public String loginPage(Model model, HttpServletRequest request) {
        logger.info("进入登录页面...");
        model.addAttribute("pageTitle","登录");
        return "vue";
    }
}
