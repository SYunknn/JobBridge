package com.ceo.jobbridge.service;

import com.ceo.jobbridge.model.Deliver;
import com.ceo.jobbridge.repository.DeliverRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by HanrAx on 2017/7/21.
 */
@Service
public class DeliverService {

    @Autowired
    private DeliverRepository deliverRepository;

    /**
     * 更新
     * */
    @Transactional
    @Modifying
    void updateHaveDeleteByDeliverId(Long deliverId){
        Deliver deliver = deliverRepository.findByDeliverId(deliverId);
        if(deliver == null){
            System.out.println("该deliver不存在");
        }else{
            deliver.setHaveDelete(true);
            deliverRepository.save(deliver);
        }
    }

    /**
     * 添加
     * */
    @Transactional
    void addDeliver(Deliver deliver){
        try {
            deliverRepository.save(deliver);
        } catch (Exception e) {
            System.out.println(e.getLocalizedMessage());
        }
    }
    /*private SqlSessionFactory sessionFactory;
    private SqlSession session;
    public DeliverService() {
       sessionFactory = SqlSessionUtil.sqlSessionFactoryBuild();
    }

    @Override
    public List<Deliver> findDeliverByResumeIdAndEnterpriseId(Map<String, Object> map) {
            String statement = "deliverMapper.findDeliverByResumeIdAndEnterpriseId";
            List<Object> list = SqlSessionUtil.selectListOp(statement,map,sessionFactory);
            if(list == null || list.isEmpty()){
                return null;
            }else{
                List<Deliver> deliverList = new ArrayList<>();
                for(Object object:list){
                    deliverList.add((Deliver) object);
                }
                return deliverList;
            }

    }

    @Override
    public List<Deliver> findDeliverByEnterpriseId(Long enterpriseId) {
        String statement = "deliverMapper.findDeliverByEnterpriseId";
//        SqlSessionUtil.selectListOp(statement,enterpriseId,sessionFactory);
        List<Deliver> list = null;
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
    public  Deliver findDeliverById(Long deliverId){
        String statement = "deliverMapper.findDeliverById";
        Object object = SqlSessionUtil.selectOp(statement,deliverId,sessionFactory);
        if(object instanceof  Deliver){
            return (Deliver)object;
        }else{
            return null;
        }
    }

    @Override
    public List<Deliver> findDeliverByResumeId(Long resumeId){
        String statement = "deliverMapper.findDeliverByResumeId";
//        SqlSessionUtil.selectListOp(statement,enterpriseId,sessionFactory);
        List<Deliver> list = null;
        try{
            session = sessionFactory.openSession();
            list = session.selectList(statement,resumeId);
        }catch(Exception e){
            e.printStackTrace();
        }finally {
            session.close();
        }
        return list;
    }

    @Override
    public void updateHaveDeleteByDeliverId(Long deliverId){
        String statement = "deliverMapper.updateHaveDeleteByDeliverId";
        SqlSessionUtil.updateOp(statement,deliverId,sessionFactory);
    }

    @Override
    public void addDeliver(Deliver deliver) {
        String statement = "deliverMapper.addDeliver";
        SqlSessionUtil.insertOp(statement,deliver,sessionFactory);
    }*/
}
