package com.ceo.jobbridge.controller;
import com.ceo.jobbridge.model.Enterprise;
import com.ceo.jobbridge.model.Student;
import com.ceo.jobbridge.util.SendInfo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by SYunk on 2017/7/25.
 */
@Controller
public class UserNameController {
    /**
     * 请求用户名
     * */
    @RequestMapping(value = "/username",method = RequestMethod.GET)
    public void enterpriseForRecruitInfo(HttpServletRequest request, HttpServletResponse response) throws Exception {
        response.setHeader("Access-Control-Allow-Origin", "*");
        Object loginUser = request.getSession().getAttribute("loginUser");
        if(loginUser == null){
            response.sendRedirect("/");
            return;
        }
        String userName;
        if(loginUser instanceof Student){
            userName = ((Student) loginUser).getUserName();
        }else if(loginUser instanceof Enterprise){
            userName = ((Enterprise)loginUser).getUserName();
        }else{
            userName = "";
        }
        String result = "{\"username\":\"" + userName + "\"}";
        SendInfo.render(result,"text/json",response);
    }

    /**
     * 登出
     * */
    @RequestMapping(value = "/exit",method = RequestMethod.GET)
    public void exit(HttpServletRequest request, HttpServletResponse response) throws Exception {
        response.setHeader("Access-Control-Allow-Origin", "*");
        Object loginUser = request.getSession().getAttribute("loginUser");
        if(loginUser == null){
            response.sendRedirect("/");
            return;
        }
        request.getSession().removeAttribute("loginUser");
        response.sendRedirect("/");
    }
}
