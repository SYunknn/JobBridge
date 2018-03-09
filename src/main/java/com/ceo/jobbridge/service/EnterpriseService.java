package com.ceo.jobbridge.service;

import com.ceo.jobbridge.model.Enterprise;
import com.ceo.jobbridge.repository.EnterpriseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;



/**
 * Created by SYunk on 2017/7/20.
 */
@Service
public class EnterpriseService {

    @Autowired
    private EnterpriseRepository enterpriseRepository;

    /**
     * 添加
     * */
    @Transactional
    public void addEnterprise(Enterprise enterprise){
        try {
            enterpriseRepository.save(enterprise);
        } catch (Exception e) {
            System.out.println(e.getLocalizedMessage());
        }
    }

/*    private SqlSessionFactory sessionFactory;

    public EnterpriseService() {
        sessionFactory = SqlSessionUtil.sqlSessionFactoryBuild();
    }

    public Enterprise findEnterpriseById(Long enterpriseId){
        String statement = "enterpriseMapper.findEnterpriseById";
        Object object = SqlSessionUtil.selectOp(statement,enterpriseId,sessionFactory);
        if(object instanceof Enterprise){
            return (Enterprise)object;
        }else{
            return null;
        }
    }
    public Enterprise findEnterpriseByUserName(String userName){
        String statement = "enterpriseMapper.findEnterpriseByUserName";
        Object object = SqlSessionUtil.selectOp(statement,userName,sessionFactory);
        if(object instanceof Enterprise){
            return (Enterprise)object;
        }else{
            return null;
        }
    }
    public Enterprise findEnterpriseByMailbox(String mailbox){
        String statement = "enterpriseMapper.findEnterpriseByMailbox";
        Object object = SqlSessionUtil.selectOp(statement,mailbox,sessionFactory);
        if(object instanceof Enterprise){
            return (Enterprise)object;
        }else{
            return null;
        }
    }
    public void addEnterprise(Enterprise enterprise) {
        String statement = "enterpriseMapper.addEnterprise";
        SqlSessionUtil.insertOp(statement,enterprise,sessionFactory);
    }*/
}
