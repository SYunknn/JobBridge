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
@Table(name = "recruit_info_tag")
@IdClass(RecruitInfoTagMultiKeysClass.class)
public class RecruitInfoTag {
    private Long recruitInfoId;
    private Integer tagId;

    public RecruitInfoTag(){

    }

    public RecruitInfoTag(Long recruitInfoId, Integer tagId) {
        this.recruitInfoId = recruitInfoId;
        this.tagId = tagId;
    }

    @Id
    public Long getRecruitInfoId() {
        return recruitInfoId;
    }

    @Id
    public Integer getTagId() {
        return tagId;
    }

    public void setRecruitInfoId(Long recruitInfoId) {
        this.recruitInfoId = recruitInfoId;
    }

    public void setTagId(Integer tagId) {
        this.tagId = tagId;
    }
}
