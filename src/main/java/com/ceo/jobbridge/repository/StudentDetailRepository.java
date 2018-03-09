package com.ceo.jobbridge.repository;


import com.ceo.jobbridge.model.StudentDetail;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by SYunk on 2017/7/20.
 */
public interface StudentDetailRepository extends JpaRepository<StudentDetail,Long> {

    StudentDetail findByStudentId(Long studentId);

    /*void addStudentDetail(StudentDetail studentDetail);
    void deleteStudentDetailByStudentId(Long studentId);
    void updateStudentDetailValidationByStudentId(Long studentId);//通过学生id，修改学生验证位*/

}
