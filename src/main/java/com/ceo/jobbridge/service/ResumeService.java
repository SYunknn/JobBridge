package com.ceo.jobbridge.service;

import com.ceo.jobbridge.model.Resume;
import com.ceo.jobbridge.repository.ResumeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.io.IOException;
import java.io.Reader;

/**
 * Created by SYunk on 2017/7/21.
 */

@Service
public class ResumeService {

    @Autowired
    private ResumeRepository resumeRepository;

    /**
     * 添加简历
     * */
    @Transactional
    public void addResume(Resume resume){
        try {
            resumeRepository.save(resume);
        } catch (Exception e) {
            System.out.println(e.getLocalizedMessage());
        }
    }

    /**
     * 修改简历
     * */
    @Transactional
    @Modifying
    public void updateResume(Resume resume){
        Resume oldResume = resumeRepository.findByResumeId(resume.getResumeId());
        if(oldResume == null){
            System.out.println("要修改的简历不存在");
        }else{
            resumeRepository.save(resume);
        }
    }

/*    private SqlSessionFactory sessionFactory;
    private SqlSession session;
    public ResumeService() {
        String resource = "mybatisConf.xml";
        try {
            Reader reader = Resources.getResourceAsReader(resource);
            sessionFactory = new SqlSessionFactoryBuilder().build(reader);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Long findResumeIdByStudentId(Long studentId){
        String statement = "resumeMapper.findResumeIdByStudentId";
        Long resumeId = null;
        try{
            session = sessionFactory.openSession();
            resumeId = session.selectOne(statement,studentId);
        }catch(Exception e){
            e.printStackTrace();
        }finally {
            session.close();
        }
        return resumeId;
    }

    @Override
    public Resume findResumeByResumeId(Long resumeId) {
        String statement = "resumeMapper.findResumeByResumeId";
        Object object = SqlSessionUtil.selectOp(statement,resumeId,sessionFactory);
        if(object instanceof Resume){
            return (Resume)object;
        }else{
            return null;
        }

    }

    public void addResume(Resume resume){
        String statement = "resumeMapper.addResume";
        try{
            session = sessionFactory.openSession();
            int result = session.insert(statement,resume);
            session.commit();  //一定要记得commit
            if(result > 0){
                System.out.println("学生对应简历添加成功");
            }else{
                System.out.println("学生对应简历添加失败");
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            session.close();
        }
    }*/
}
