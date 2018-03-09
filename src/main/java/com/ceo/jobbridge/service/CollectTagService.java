package com.ceo.jobbridge.service;

import com.ceo.jobbridge.multiKeysClasses.CollectTagMultiKeysClass;
import com.ceo.jobbridge.model.CollectTag;
import com.ceo.jobbridge.repository.CollectTagRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Service;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Map;

/**
 * Created by HanrAx on 2017/7/21.
 */
@Service
public class CollectTagService {
    @Autowired
    @PersistenceContext
    private EntityManager entityManager;

    @Autowired
    private CollectTagRepository collectTagRepository;

    /**
     * 添加
     * */
    @Transactional
    public void addCollectTag(CollectTag collectTag){
        try {
            collectTagRepository.save(collectTag);
        } catch (Exception e) {
            System.out.println(e.getLocalizedMessage());
        }
    }

    /**
     * 删除该学生收藏的所有标签
     * */
    @Transactional
    @Modifying
    public void deleteCollectTagByStudentId(Long studentId){
        List<CollectTag> collectTagList = collectTagRepository.findByStudentId(studentId);
        for (CollectTag collectTag : collectTagList){
            collectTagRepository.delete(collectTag);
        }
    }

    /**
     * 删除学生收藏的某个标签
     * */
    @Transactional
    @Modifying
    public void deleteCollectTagById(Map<String, Object> map){
        Long studentId = (Long)map.get("studentId");
        Integer tagId = (Integer)map.get("tagId");

        CollectTagMultiKeysClass collectTagMultiKeysClass =
                new CollectTagMultiKeysClass(studentId, tagId);

        CollectTag collectTag = entityManager.find(CollectTag.class, collectTagMultiKeysClass);
        if(collectTag == null){
            System.out.println("没有找到要删除的CollectEnterprise对象");
        }else{
            collectTagRepository.delete(collectTag);
        }

    }

    /*private SqlSessionFactory sessionFactory;
    public CollectTagService() {
        sessionFactory = SqlSessionUtil.sqlSessionFactoryBuild();
    }

    @Override
    public List<CollectTag> findCollectTagByStudentId(Long studentId) {
        String statement = "collectTagMapper.findCollectTagByStudentId";
        List<Object> list = SqlSessionUtil.selectListOp(statement,studentId,sessionFactory);
        if(list == null || list.isEmpty()){
            return null;
        }
        else{
            List<CollectTag> collectTagList = new ArrayList<>();
            for(Object object:list){
                collectTagList.add((CollectTag)object);
            }
            return collectTagList;
        }
    }

    @Override
    public void addCollectTag(CollectTag collectTag) {
        String statement = "collectTagMapper.addCollectTag";
        SqlSessionUtil.insertOp(statement,collectTag,sessionFactory);
    }

    @Override
    public void deleteCollectTagByStudentId(Long studentId){
        String statement = "collectTagMapper.deleteCollectTagByStudentId";
        SqlSessionUtil.deleteOp(statement,studentId,sessionFactory);
    }

    @Override
    public void deleteCollectTagById(Map<String,Object> map) {
        String statement = "collectTagMapper.deleteCollectTagById";
        SqlSessionUtil.deleteOp(statement,map,sessionFactory);
    }*/

}
