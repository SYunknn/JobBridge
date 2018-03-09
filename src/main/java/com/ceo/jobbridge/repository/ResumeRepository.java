package com.ceo.jobbridge.repository;

import com.ceo.jobbridge.model.Resume;
import org.springframework.data.jpa.repository.JpaRepository;


/**
 * Created by SYunk on 2017/7/21.
 */
public interface ResumeRepository extends JpaRepository<Resume,Long> {
    Resume findByStudentId(Long studentId);
    Resume findByResumeId(Long resumeId); //通过resumeID找到resume实例
//    void addResume(Resume resume);
}
