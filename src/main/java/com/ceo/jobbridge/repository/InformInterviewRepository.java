package com.ceo.jobbridge.repository;

import com.ceo.jobbridge.model.InformInterview;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by HanrAx on 2017/7/20.
 */
public interface InformInterviewRepository extends JpaRepository<InformInterview,Long> {
    InformInterview findByInformInterviewId(Long interviewId);                    //通过通知的ID来查找该通知
    List<InformInterview> findByEnterpriseId(Long enterpriseId);  //通过公司ID来查找所有公司发过的面试通知
    List<InformInterview> findByStudentId(Long studentId);        //通过学生ID来查找所有学生收到的面试通知
    // void addInterview(InformInterview informInterview);                     //新增一个面试请求，通过传入InformInterview实体
    // void deleteInterviewById(Long informInterviewId);                       //通过面试ID删除该面试请求
}
