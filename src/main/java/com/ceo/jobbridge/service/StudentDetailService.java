package com.ceo.jobbridge.service;

import com.ceo.jobbridge.model.StudentDetail;
import com.ceo.jobbridge.repository.StudentDetailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

/**
 * Created by SYunk on 2017/7/20.
 */

@Service
public class StudentDetailService {

    @Autowired
    private StudentDetailRepository studentDetailRepository;

    /**
     * 添加学生详细信息
     * */
    @Transactional
    public void addStudentDetail(StudentDetail studentDetail){
        try {
            studentDetailRepository.save(studentDetail);
        } catch (Exception e) {
            System.out.println(e.getLocalizedMessage());
        }
    }

    /**
     * 删除学生详细信息
     * */
    @Transactional
    @Modifying
    public void deleteByStudentId(Long studentId){
        StudentDetail studentDetail = studentDetailRepository.findByStudentId(studentId);
        if(studentDetail != null){
            studentDetailRepository.delete(studentDetail);
        }
    }

    /**
     * 通过学生id，修改学生验证位
     * */
    @Transactional
    @Modifying
    public void updateStudentDetailValidationByStudentId(Long studentId){
        StudentDetail studentDetail = studentDetailRepository.findByStudentId(studentId);
        if(studentDetail == null){
            System.out.println("该学生不存在");
        }else{
            studentDetail.setValidation(true);
            studentDetailRepository.save(studentDetail);
        }
    }

    /*private SqlSessionFactory sessionFactory;

    public StudentDetailService() {
        sessionFactory = SqlSessionUtil.sqlSessionFactoryBuild();
    }

    public StudentDetail findStudentDetailByStudentId(Long studentId){
        String statement = "studentDetailMapper.findStudentDetailByStudentId";
        Object object = SqlSessionUtil.selectOp(statement,studentId,sessionFactory);
        if(object instanceof StudentDetail){
            return (StudentDetail)object;
        }else{
            return null;
        }
    }
    public void addStudentDetail(StudentDetail studentDetail){
        String statement = "studentDetailMapper.addStudentDetail";
        SqlSessionUtil.insertOp(statement,studentDetail,sessionFactory);
    }
    public void deleteStudentDetailByStudentId(Long studentId){
        String statement = "studentDetailMapper.deleteStudentDetailByStudentId";
        SqlSessionUtil.deleteOp(statement,studentId,sessionFactory);
    }

    @Override
    public void updateStudentDetailValidationByStudentId(Long studentId) {
        String statement = "studentDetailMapper.updateStudentDetailValidationByStudentId";
        SqlSessionUtil.updateOp(statement,studentId,sessionFactory);
    }*/

}
