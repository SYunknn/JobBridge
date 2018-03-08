package com.ceo.jobbridge.model;

import com.ceo.jobbridge.multiKeysClasses.RecruitInfoTagMultiKeysClass;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

/**
 * Created by SYunk on 2017/7/25.
 */

@Entity
@Table(name = "collect_enterprise")
@IdClass(RecruitInfoTagMultiKeysClass.class)
public class RecruitInfoTag {
    private Long recruitInfoId;
    private Integer tagId;

    public RecruitInfoTag(Long recruitInfoId, Integer tagId) {
        this.recruitInfoId = recruitInfoId;
        this.tagId = tagId;
    }

    public Long getRecruitInfoId() {
        return recruitInfoId;
    }
    public Integer getTagId() {
        return tagId;
    }

    @Id
    public void setRecruitInfoId(Long recruitInfoId) {
        this.recruitInfoId = recruitInfoId;
    }

    @Id
    public void setTagId(Integer tagId) {
        this.tagId = tagId;
    }
}
