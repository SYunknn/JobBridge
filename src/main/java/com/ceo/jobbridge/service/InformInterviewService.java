package com.ceo.jobbridge.service;

import com.ceo.jobbridge.model.InformInterview;
import com.ceo.jobbridge.repository.InformInterviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;


/**
 * Created by HanrAx on 2017/7/20.
 */
@Service
public class InformInterviewService {
    @Autowired
    private InformInterviewRepository informInterviewRepository;

    /**
     * 添加
     * */
    @Transactional
    void add(InformInterview informInterview){
        try {
            informInterviewRepository.save(informInterview);
        } catch (Exception e) {
            System.out.println(e.getLocalizedMessage());
        }
    }

    /**
     * 根据informInterviewId 
     * */
    @Transactional
    @Modifying
    void deleteInterviewById(Long informInterviewId){
        try {
            InformInterview informInterview =
                    informInterviewRepository.findByInformInterviewId(informInterviewId);
            if(informInterview == null){
                System.out.println("要删除的InformInterview对象不存在");
            }else{
                informInterviewRepository.delete(informInterview);
            }

        } catch (Exception e) {
            System.out.println(e.getLocalizedMessage());
        }
    }

    /*private SqlSessionFactory sessionFactory;
    private SqlSession session;
    public InformInterviewService() {
        String resource = "mybatisConf.xml";
        try {
            Reader reader = Resources.getResourceAsReader(resource);
            sessionFactory = new SqlSessionFactoryBuilder().build(reader);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public InformInterview findInterviewById(Long interviewId) {
        String statement = "informInterviewMapper.findInterviewById";
        InformInterview informInterview = null;
        try{
            session = sessionFactory.openSession();
            informInterview = session.selectOne(statement,interviewId);
        }catch(Exception e){
            e.printStackTrace();
        }finally {
            session.close();
        }
        return informInterview;
    }

    @Override
    public List<InformInterview> findInterviewsByEnterpriseId(Long enterpriseId) {
        String statement = "informInterviewMapper.findInterviewsByEnterpriseId";
        List<InformInterview> list = null;
        try{
            session = sessionFactory.openSession();
            list = session.selectList(statement,enterpriseId);
        }catch(Exception e){
            e.printStackTrace();
        }finally {
            session.close();
        }
        return list;
    }

    @Override
    public List<InformInterview> findInterviewsByStudentId(Long studentId) {
        String statement = "informInterviewMapper.findInterviewsByStudentId";
        List<InformInterview> list = null;
        try{
            session = sessionFactory.openSession();
            list = session.selectList(statement,studentId);
        }catch(Exception e){
            e.printStackTrace();
        }finally {
            session.close();
        }
        return list;
    }

    @Override
    public void addInterview(InformInterview informInterview) {
        String statement = "informInterviewMapper.addInterview";
        try{
            session = sessionFactory.openSession();
            int result = session.insert(statement,informInterview);
            session.commit();  //一定要记得commit
            if(result > 0){
                System.out.println("新增面试成功");
            }else{
                System.out.println("新增面试失败");
            }
        }catch(Exception e){
            e.printStackTrace();
        }finally {
            session.close();
        }
    }

    @Override
    public void deleteInterviewById(Long informInterviewId) {
        String statement = "informInterviewMapper.deleteInterviewById";
        try{
            session = sessionFactory.openSession();
            int result = session.delete(statement,informInterviewId);
            session.commit();  //一定要记得commit
            if(result > 0){
                System.out.println("删除面试成功");
            }else{
                System.out.println("删除面试失败");
            }
        }catch(Exception e){
            e.printStackTrace();
        }finally {
            session.close();
        }
    }*/
}
