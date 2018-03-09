package com.ceo.jobbridge.controller;

import com.ceo.jobbridge.model.Enterprise;
import com.ceo.jobbridge.model.Manager;
import com.ceo.jobbridge.model.Student;
import com.ceo.jobbridge.repository.EnterpriseRepository;
import com.ceo.jobbridge.repository.ManagerRepository;
import com.ceo.jobbridge.repository.StudentRepository;
import com.ceo.jobbridge.service.StudentService;
import com.ceo.jobbridge.util.Crypto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import java.util.Map;

/**
 * Created by SYunk on 2017/7/19.
 */
@Controller
public class LoginController {

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private EnterpriseRepository enterpriseRepository;

    @Autowired
    private ManagerRepository managerRepository;

    @Autowired
    private StudentService studentService;

    @RequestMapping(value = "/forLogin/com",method = RequestMethod.GET)
    public String comForLogin(HttpServletRequest request, HttpServletResponse response) {
        response.setHeader("Access-Control-Allow-Origin", "*");
        String timestamp = Long.toString(System.currentTimeMillis());
        request.getSession().setAttribute("timestamp",timestamp);
        return "comlogin";
    }

    @RequestMapping(value = "/forLogin/stu",method = RequestMethod.GET)
    public String stuForLogin(HttpServletRequest request, HttpServletResponse response) {
        response.setHeader("Access-Control-Allow-Origin", "*");
        String timestamp = Long.toString(System.currentTimeMillis());
        request.getSession().setAttribute("timestamp",timestamp);
        return "stulogin";
    }

    @RequestMapping(value = "/forLogin/admin",method = RequestMethod.GET)
    public String adminForLogin(HttpServletRequest request, HttpServletResponse response) {
        response.setHeader("Access-Control-Allow-Origin", "*");
        String timestamp = Long.toString(System.currentTimeMillis());
        request.getSession().setAttribute("timestamp",timestamp);
        return "admlogin";
    }

    /**
    * 学生登录处理
    * */
    @RequestMapping(value = "/login/student",method = RequestMethod.POST)
    public void stuLogin(HttpServletRequest request, HttpServletResponse response,@RequestParam Map<String,String> map) throws Exception{
        String result = "";
        response.setHeader("Access-Control-Allow-Origin", "*");
        /*String loginName = map.get("userName");
        String password = map.get("passWord");*/
        String loginName = request.getParameter("userName");
        String password = request.getParameter("passWord");
        System.out.println("这里是学生在登录");
        Student student = null;
        if(loginName.contains("@")){
            student = studentRepository.findByMailbox(loginName);
        }else{
            student = studentRepository.findByUserName(loginName);
        }
        if(student == null){
            result = "{\"ok\":\"false\",\"reason\":\"用户不存在或密码错误\"}";     //用户不存在
        }else if(!Crypto.validPassword(password,student.getPassword())){
            result = "{\"ok\":\"false\",\"reason\":\"用户不存在或密码错误\"}";     //密码错误
        }else {
            result = "{\"ok\":\"true\"}";
            request.getSession().setAttribute("loginUser",student);
        }
        response.setContentType("application/json;charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.print(result);
        out.flush();
        out.close();
    }

    /**
    * 公司登录处理
    * */
    @RequestMapping(value = "/login/enterprise",method = RequestMethod.POST)
    public void comLogin(HttpServletRequest request, HttpServletResponse response) throws Exception{
        String result = "";
        response.setHeader("Access-Control-Allow-Origin", "*");
        String loginName = request.getParameter("userName");
        String password = request.getParameter("passWord");
        System.out.println("这里是公司在登录");
        Enterprise enterprise = null;
        if(loginName.contains("@")){
            enterprise = enterpriseRepository.findByMailbox(loginName);
        }else{
            enterprise = enterpriseRepository.findByUserName(loginName);
        }
        if(enterprise == null){
            result = "{\"ok\":\"false\",\"reason\":\"用户不存在或密码错误\"}";     //用户不存在
        }else if(!Crypto.validPassword(password,enterprise.getPassword())){
            result = "{\"ok\":\"false\",\"reason\":\"用户不存在或密码错误\"}";     //密码错误
        }else {
            result = "{\"ok\":\"true\"}";
            request.getSession().setAttribute("loginUser",enterprise);
        }
        response.setContentType("application/json;charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.print(result);
        out.flush();
        out.close();
    }

    /**
    * 管理员登录处理
    * */
    @RequestMapping(value = "/login/admin",method = RequestMethod.POST)
    public void managerLogin(HttpServletRequest request, HttpServletResponse response) throws Exception{
        String result = "";
        response.setHeader("Access-Control-Allow-Origin", "*");
        String loginName = request.getParameter("userName");
        String password = request.getParameter("passWord");
        System.out.println("这里是管理员在登录");
        Manager manager = null;
        manager = managerRepository.findByUserName(loginName);
        if(manager == null){
            result = "{\"ok\":\"false\",\"reason\":\"用户不存在或密码错误\"}";     //用户不存在
        }else if(!Crypto.validPassword(password,manager.getPassword())){
            result = "{\"ok\":\"false\",\"reason\":\"用户不存在或密码错误\"}";     //密码错误
        }else {
            result = "{\"ok\":\"true\"}";
            request.getSession().setAttribute("loginUser",manager);
        }
        response.setContentType("application/json;charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.print(result);
        out.flush();
        out.close();
    }
}
