package com.ceo.jobbridge.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * Created by SYunk on 2017/7/20.
 */

@Entity
public class Tag {
    @Id
    @GeneratedValue
    private Integer tagId;

    private String name;

    public Tag(){

    }

    public Tag(Integer tagId, String name) {
        this.tagId = tagId;
        this.name = name;
    }

    public Integer getTagId() {
        return tagId;
    }

    public String getName() {
        return name;
    }

    public void setTagId(Integer tagId) {
        this.tagId = tagId;
    }

    public void setName(String name) {
        this.name = name;
    }
}
