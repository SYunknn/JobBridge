package com.ceo.jobbridge.repository;

import com.ceo.jobbridge.model.Deliver;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Map;

/**
 * Created by HanrAx on 2017/7/21.
 */
public interface DeliverRepository extends JpaRepository<Deliver, Long>{
    /**
     * 通过简历ID、公司ID、查找所有的投递信息
     * @param map
     * @return
     */
    List<Deliver> findByResumeIdAndEnterpriseId(Long resumeId, Long enterpriseId);

    //公司查找所有收到的投递信息，并可以根据其中的简历查看该学生的简历
    List<Deliver> findByEnterpriseId(Long enterpriseId);

    //根据投递号查询投递信息
    Deliver findByDeliverId(Long deliverId);

    //根据简历号查询投递信息
    List<Deliver> findByResumeId(Long resumeId);

    //根据投递号修改字段
    //void updateHaveDeleteByDeliverId(Long deliverId);

    //新建投递信息
    //void addDeliver(Deliver deliver);

}
