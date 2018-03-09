package com.ceo.jobbridge.controller;

import com.ceo.jobbridge.model.Enterprise;
import com.ceo.jobbridge.model.Manager;
import com.ceo.jobbridge.model.Student;
import com.ceo.jobbridge.repository.EnterpriseRepository;
import com.ceo.jobbridge.repository.ManagerRepository;
import com.ceo.jobbridge.repository.ResumeRepository;
import com.ceo.jobbridge.repository.StudentRepository;
import com.ceo.jobbridge.service.EnterpriseService;
import com.ceo.jobbridge.service.ManagerService;
import com.ceo.jobbridge.service.StudentService;
import com.ceo.jobbridge.util.Crypto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;

/**
 * Created by SYunk on 2017/7/19.
 */
@Controller
public class RegisterController {

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private ManagerRepository managerRepository;

    @Autowired
    private EnterpriseRepository enterpriseRepository;

    @Autowired
    private ResumeRepository resumeRepository;

    @Autowired
    private StudentService studentService;

    @Autowired
    private ManagerService managerService;

    @Autowired
    private EnterpriseService enterpriseService;

    /**
    * 请求学生注册页面
    * */
    @RequestMapping(value = "/forRegister",method = RequestMethod.GET)
    public String forRegister(HttpServletResponse response) {
        response.setHeader("Access-Control-Allow-Origin", "*");
        return "sturegister";
    }

    /**
    * 学生注册处理
    * */
    @RequestMapping(value = "/register/student",method = RequestMethod.POST)
    public void studentRegister(HttpServletRequest request, HttpServletResponse response) throws Exception{
        String result = "";
        response.setHeader("Access-Control-Allow-Origin", "*");
        String userName = request.getParameter("userName");
        String mailbox = request.getParameter("email");
        String password = request.getParameter("passWord");
        Student student = null;
        if((student = studentRepository.findByUserName(userName)) != null){
            result = "{\"ok\":\"false\",\"reason\":\"该用户名已被其他人注册\"}";
        }else if((student = studentRepository.findByMailbox(mailbox)) != null){
            result = "{\"ok\":\"false\",\"reason\":\"该邮箱已被其他人注册\"}";
        }else{
            String cryptoPassword = Crypto.getEncryptedPwd(password);
            Student newStudent = new Student(new Long(0),userName,mailbox,cryptoPassword);
            studentService.addStudent(newStudent);
            result = "{\"ok\":\"true\"}";
        }

       /* Student justStudent = studentService.findStudentByMailbox(mailbox);
        Resume resume = new Resume(Long.parseLong("0"),justStudent.getStudentId());
        resumeService.addResume(resume);*/

        response.setContentType("application/json;charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.print(result);
        out.flush();
        out.close();
    }

    /**
    * 管理员添加处理
    * */
    @RequestMapping(value = "/register/admin",method = RequestMethod.POST)
    public void adminRegister(HttpServletRequest request, HttpServletResponse response) throws Exception{
        String result = "";
        response.setHeader("Access-Control-Allow-Origin", "*");
        String userName = request.getParameter("userName");
        String password = request.getParameter("passWord");
        Manager manager = null;
        if((manager = managerRepository.findByUserName(userName)) != null){
            result = "{\"ok\":\"false\",\"reason\":\"该用户名已被其他人注册\"}";
        }else{
            String cryptoPassword = Crypto.getEncryptedPwd(password);
            Manager newManager = new Manager(0,userName,cryptoPassword);
            managerService.addManager(newManager);
            result = "{\"ok\":\"true\"}";
        }
        response.setContentType("application/json;charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.print(result);
        out.flush();
        out.close();
    }

    /**
    * 公司企业注册处理
    * */
    @RequestMapping(value = "/register/enterprise",method = RequestMethod.POST)
    public void enterpriseRegister(HttpServletRequest request, HttpServletResponse response) throws Exception{
        String result = "";
        response.setHeader("Access-Control-Allow-Origin", "*");
        String userName = request.getParameter("userName");
        String name = request.getParameter("name");
        String mailbox = request.getParameter("mailbox");
        String phoneNum = request.getParameter("phoneNum");
        String password = request.getParameter("password");
        String enterpriseIntroduction = request.getParameter("enterpriseIntroduction");
        Enterprise enterprise = null;
        if((enterprise = enterpriseRepository.findByUserName(userName)) != null){
            result = "{\"ok\":\"false\",\"reason\":\"该用户名已被其他人注册\"}";
        }else if((enterprise = enterpriseRepository.findByMailbox(mailbox)) != null){
            result = "{\"ok\":\"false\",\"reason\":\"该邮箱已被其他人注册\"}";
        }else{
            String cryptoPassword = Crypto.getEncryptedPwd(password);
            Enterprise newEnterprise = new Enterprise(Long.parseLong("0"),userName,name,mailbox, phoneNum,cryptoPassword,enterpriseIntroduction,"");
            enterpriseService.addEnterprise(newEnterprise);
            result = "{\"ok\":\"true\"}";
        }
        response.setContentType("application/json;charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.print(result);
        out.flush();
        out.close();
    }
}
