package com.ceo.jobbridge.service;

import com.ceo.jobbridge.repository.ICollectEnterpriseDao;
import com.ceo.jobbridge.model.CollectEnterprise;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
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
    private ICollectEnterpriseDao iCollectEnterpriseDao;

    @Override
    @Transactional
    public void
    /*private SqlSessionFactory sessionFactory;

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
    public void ICollectEnterpriseDao(CollectEnterprise collectEnterprise) {
        String statement = "collectEnterpriseMapper.ICollectEnterpriseDao";
        SqlSessionUtil.insertOp(statement,collectEnterprise,sessionFactory);
    }

    @Override
    public void deleteCollectEnterpriseById(Map<String,Object> map) {
        String statement = "collectEnterpriseMapper.deleteCollectEnterpriseById";
        SqlSessionUtil.deleteOp(statement,map,sessionFactory);
    }*/

}
