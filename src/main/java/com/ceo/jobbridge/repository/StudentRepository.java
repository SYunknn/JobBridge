package com.ceo.jobbridge.repository;

import com.ceo.jobbridge.model.Student;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by SYunk on 2017/7/19.
 */
public interface StudentRepository extends JpaRepository<Student,Long> {
    Student findByUserName(String userName); //根据用户名查找学生
    Student findByStudentId(Long studentId);  //通过学生ID查找学生
    Student findByMailbox(String mailbox); //根据邮箱查找学生
//    void addStudent(Student student);  //新增注册的学生账号
}
