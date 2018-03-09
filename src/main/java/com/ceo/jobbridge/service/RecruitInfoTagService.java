package com.ceo.jobbridge.service;

import com.ceo.jobbridge.repository.RecruitInfoTagRepository;
import com.ceo.jobbridge.model.RecruitInfoTag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by SYunk on 2017/7/25.
 */
@Service
public class RecruitInfoTagService {

    @Autowired
    private RecruitInfoTagRepository recruitInfoTagRepository;

    /**
     * 添加
     * */
    @Transactional
    public void addRecruitInfoTag(RecruitInfoTag recruitInfoTag){
        try {
            recruitInfoTagRepository.save(recruitInfoTag);
        } catch (Exception e) {
            System.out.println(e.getLocalizedMessage());
        }
    }

    /**
     * 删除该招聘信息对应的所有标签
     */
    @Transactional
    @Modifying
    public void deleteRecruitInfoTagByRecruitInfoId(Long recruitInfoId){
        List<RecruitInfoTag> recruitInfoTagList =
                recruitInfoTagRepository.findByRecruitInfoId(recruitInfoId);
        for(RecruitInfoTag recruitInfoTag : recruitInfoTagList){
            recruitInfoTagRepository.delete(recruitInfoTag);
        }
    }


/*    private SqlSessionFactory sessionFactory;
    private SqlSession session;
    public RecruitInfoTagService() {
        sessionFactory = SqlSessionUtil.sqlSessionFactoryBuild();
    }

    public List<RecruitInfoTag> findRecruitInfoTagByRecruitInfoId(Long recruitInfoId){
        String statement = "recruitInfoTagMapper.findRecruitInfoTagByRecruitInfoId";
        List<Object> list = SqlSessionUtil.selectListOp(statement,recruitInfoId,sessionFactory);
        if(list == null || list.isEmpty()){
            return null;
        }else{
            List<RecruitInfoTag> recruitInfoTagList = new ArrayList<>();
            for(Object object:list){
                recruitInfoTagList.add((RecruitInfoTag)object);
            }
            return recruitInfoTagList;
        }
    }
    public List<RecruitInfoTag> findRecruitInfoTagByTagId(Integer tagId){
        String statement = "recruitInfoTagMapper.findRecruitInfoTagByTagId";
        List<Object> list = SqlSessionUtil.selectListOp(statement,tagId,sessionFactory);
        if(list == null || list.isEmpty()){
            return null;
        }else{
            List<RecruitInfoTag> recruitInfoTagList = new ArrayList<>();
            for(Object object:list){
                recruitInfoTagList.add((RecruitInfoTag)object);
            }
            return recruitInfoTagList;
        }
    }
    public void addRecruitInfoTag(RecruitInfoTag recruitInfoTag){
        String statement = "recruitInfoTagMapper.addRecruitInfoTag";
        SqlSessionUtil.insertOp(statement,recruitInfoTag,sessionFactory);
    }
    public void deleteRecruitInfoTagByRecruitInfoId(Long recruitInfoId){
        String statement = "recruitInfoTagMapper.deleteRecruitInfoTagByRecruitInfoId";
        try{
            session = sessionFactory.openSession();
            int result = session.delete(statement,recruitInfoId);
            session.commit();
            if(result > 0){
                System.out.println("招聘信息标签删除成功：" + recruitInfoId);
            }else{
                System.out.println("招聘信息标签删除失败：" + recruitInfoId);
            }
        }catch(Exception e){
            e.printStackTrace();
        }finally {
            session.close();
        }
    }*/
}
