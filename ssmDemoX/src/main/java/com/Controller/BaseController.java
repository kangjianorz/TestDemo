package com.Controller;

import com.Constant.Constant;
import com.alibaba.fastjson.JSON;
import org.apache.log4j.Logger;

import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;

public class BaseController {

    protected final Logger logger = Logger.getLogger(Constant.PROJECT_LOG);

    public void setResponse(Object obj, HttpServletResponse response) {
        try {
            response.setContentType("test/json;charset=utf-8");
            String str = JSON.toJSONString(obj);
            PrintWriter writer = response.getWriter();
            writer.print(str);
            writer.flush();
            writer.close();
        } catch (Exception e) {
            logger.error("应答出错"+e);
        }
    }
}
