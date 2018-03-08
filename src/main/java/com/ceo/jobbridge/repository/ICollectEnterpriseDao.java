package com.ceo.jobbridge.repository;

import com.ceo.jobbridge.model.CollectEnterprise;
import com.ceo.jobbridge.multiKeysClasses.CollectEnterpriseMultiKeysClass;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Map;

/**
 * Created by HanrAx on 2017/7/20.
 * Created by HuangZhenyang on 2018/3/7.
 */
public interface ICollectEnterpriseDao extends JpaRepository<CollectEnterprise, CollectEnterpriseMultiKeysClass> {

    List<CollectEnterprise> findByStudentId(Long studentId);          //学生查询自己收藏的所有公司

    //addCollectEnterprise(CollectEnterprise collectEnterprise);   //学生添加一个新的收藏

    //deleteById(Map<String, Object> map);         //通过传入学生ID与公司ID
}
