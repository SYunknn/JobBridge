package com.ceo.jobbridge.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;
import com.ceo.jobbridge.multiKeysClasses.CollectTagMultiKeysClass;

/**
 * Created by GeniusHe on 2017/7/20.
 * 收藏工作大标签类
 */

@Entity
@Table(name = "collect_enterprise")
@IdClass(CollectTagMultiKeysClass.class)
public class CollectTag {
    private Long studentId;     //发起收藏请求的学生ID
    private Integer tagId;      //被收藏的标签ID

    public CollectTag(Long studentId, Integer tagId) {
        this.studentId = studentId;
        this.tagId = tagId;
    }

    @Id
    public Long getStudentId() {
        return studentId;
    }

    public void setStudentId(Long studentId) {
        this.studentId = studentId;
    }

    @Id
    public Integer getTagId() {
        return tagId;
    }

    public void setTagId(Integer tagId) {
        this.tagId = tagId;
    }
}
