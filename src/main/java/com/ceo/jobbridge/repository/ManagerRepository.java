package com.ceo.jobbridge.repository;


import com.ceo.jobbridge.model.Manager;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by HanrAx on 2017/7/20.
 * 与数据库查询关联的接口
 */
public interface ManagerRepository extends JpaRepository<Manager,Integer> {
    Manager findByManagerId(Integer managerId);     //通过管理员id获取管理员
    Manager findByUserName(String userName); //通过管理员账号获取管理员
    // void addManager(Manager manager);               //添加管理员账号

}
