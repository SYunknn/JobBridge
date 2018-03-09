package com.ceo.jobbridge.service;

import com.ceo.jobbridge.model.CollectEnterprise;
import com.ceo.jobbridge.multiKeysClasses.CollectEnterpriseMultiKeysClass;
import com.ceo.jobbridge.repository.CollectEnterpriseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.Map;

/**
 * Created by HanrAx on 2017/7/20.
 */
@Service
public class CollectEnterpriseService{

    @Autowired
    @PersistenceContext
    private EntityManager entityManager;

    @Autowired
    private CollectEnterpriseRepository collectEnterpriseRepository;

    /**
     * 添加
     * */
    @Transactional
    void save(CollectEnterprise collectEnterprise){
        try {
            collectEnterpriseRepository.save(collectEnterprise);
        } catch (Exception e) {
            System.out.println(e.getLocalizedMessage());
        }
    }

    /**
     * 删除
     * <"student_id",12>
     * <"enterprise_id",11>
     * */
    @Transactional
    @Modifying
    void deleteById(Map<String, Object> map){
        Long enterpriseId = (Long)map.get("enterpriseId");
        Long studentId = (Long)map.get("studentId");

        CollectEnterpriseMultiKeysClass collectEnterpriseMultiKeysClass =
                new CollectEnterpriseMultiKeysClass(enterpriseId, studentId);
        CollectEnterprise collectEnterprise =
                entityManager.find(CollectEnterprise.class, collectEnterpriseMultiKeysClass);
        if(collectEnterprise == null){
            System.out.println("没有找到要删除的CollectEnterprise对象");
        }else{
            collectEnterpriseRepository.delete(collectEnterprise);
        }
    }
    /*@Override
    @Transactional
    public void
    private SqlSessionFactory sessionFactory;

    public CollectEnterpriseService() {
        sessionFactory = SqlSessionUtil.sqlSessionFactoryBuild();
    }

    @Override
    public List<CollectEnterprise> findCollectEnterpriseByStudentId(Long studentId) {
        String statement = "collectEnterpriseMapper.findCollectEnterpriseByStudentId";
        List<Object> list = SqlSessionUtil.selectListOp(statement,studentId,sessionFactory);
        if(list == null || list.isEmpty()){
            return null;
        }
        else{
            List<CollectEnterprise> collectEnterpriseList = new ArrayList<>();
            for(Object object:list){
                collectEnterpriseList.add((CollectEnterprise)object);
            }
            return collectEnterpriseList;
        }
    }

    @Override
    public void CollectEnterpriseRepository(CollectEnterprise collectEnterprise) {
        String statement = "collectEnterpriseMapper.CollectEnterpriseRepository";
        SqlSessionUtil.insertOp(statement,collectEnterprise,sessionFactory);
    }

    @Override
    public void deleteCollectEnterpriseById(Map<String,Object> map) {
        String statement = "collectEnterpriseMapper.deleteCollectEnterpriseById";
        SqlSessionUtil.deleteOp(statement,map,sessionFactory);
    }*/

}
