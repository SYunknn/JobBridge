package com.ceo.jobbridge.service;


import com.ceo.jobbridge.model.Manager;
import com.ceo.jobbridge.repository.ManagerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;

/**
 * Created by HanrAx on 2017/7/20.
 */
@Service
public class ManagerService{

    @Autowired
    private ManagerRepository managerRepository;

    @Transactional
    public void addManager(Manager manager){
        try {
            managerRepository.save(manager);
        } catch (Exception e) {
            System.out.println(e.getLocalizedMessage());
        }
    }


    /*private SqlSessionFactory sessionFactory;

    public ManagerService() {
        sessionFactory = SqlSessionUtil.sqlSessionFactoryBuild();
    }

    @Override
    public Manager findManagerById(Integer managerId) {
        String statement = "managerMapper.findManagerById";
        Object object = SqlSessionUtil.selectOp(statement,managerId,sessionFactory);
        if(object instanceof Manager){
            return (Manager)object;
        }else{
            return null;
        }
    }
    @Override
    public Manager findManagerByUserName(String userName) {
        String statement = "managerMapper.findManagerByUserName";
        Object object = SqlSessionUtil.selectOp(statement,userName,sessionFactory);
        if(object instanceof Manager){
            return (Manager)object;
        }else{
            return null;
        }
    }
    @Override
    public void addManager(Manager manager) {
        String statement = "managerMapper.addManager";
        SqlSessionUtil.insertOp(statement,manager,sessionFactory);
    }*/
}
