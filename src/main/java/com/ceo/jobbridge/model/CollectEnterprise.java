package com.ceo.jobbridge.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

import com.ceo.jobbridge.multiKeysClasses.CollectEnterpriseMultiKeysClass;

/**
 * Created by GeniusHe on 2017/7/20.
 * 收藏公司
 */

@Entity
@Table(name = "collect_enterprise")
@IdClass(CollectEnterpriseMultiKeysClass.class)
public class CollectEnterprise {
    private Long enterpriseId;  //被收藏的公司ID
    private Long studentId;     //发起收藏请求的学生ID

    public CollectEnterprise(Long enterpriseId, Long studentId) {
        this.enterpriseId = enterpriseId;
        this.studentId = studentId;
    }

    @Id
    public Long getEnterpriseId() {
        return enterpriseId;
    }

    public void setEnterpriseId(Long enterpriseId) {
        this.enterpriseId = enterpriseId;
    }

    @Id
    public Long getStudentId() {
        return studentId;
    }

    public void setStudentId(Long studentId) {
        this.studentId = studentId;
    }
}
