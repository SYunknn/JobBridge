package com.ceo.jobbridge.service;

import com.ceo.jobbridge.model.Student;
import com.ceo.jobbridge.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;


/**
 * Created by SYunk on 2017/7/19.
 */

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    /**
     * 新增注册的学生账号
     * */
    @Transactional
    void addStudent(Student student){
        try {
            studentRepository.save(student);
        } catch (Exception e) {
            System.out.println(e.getLocalizedMessage());
        }
    }


    /*private SqlSessionFactory sessionFactory;
    public StudentService() {
        sessionFactory = SqlSessionUtil.sqlSessionFactoryBuild();
    }

    public Student findStudentByUserName(String userName){
        String statement = "studentMapper.findStudentByUserName";
        Object object = SqlSessionUtil.selectOp(statement,userName,sessionFactory);
        if(object instanceof Student){
            return (Student)object;
        }else{
            return null;
        }
    }
    @Override
    public Student findStudentByStudentId(Long studentId) {
        String statement = "studentMapper.findStudentByStudentId";
        Object object = SqlSessionUtil.selectOp(statement,studentId,sessionFactory);
        if(object instanceof Student){
            return (Student)object;
        }else{
            return null;
        }
    }
    public Student findStudentByMailbox(String mailbox){
        String statement = "studentMapper.findStudentByMailbox";
        Object object = SqlSessionUtil.selectOp(statement,mailbox,sessionFactory);
        if(object instanceof Student){
            return (Student)object;
        }else{
            return null;
        }
    }
    public void addStudent(Student student) {
        String statement = "studentMapper.addStudent";
        SqlSessionUtil.insertOp(statement,student,sessionFactory);
    }*/
}
