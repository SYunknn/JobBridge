package com.ceo.jobbridge.repository;


import com.ceo.jobbridge.model.Tag;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by Administrator on 2017/7/24 0024.
 */
public interface TagRepository extends JpaRepository<Tag,Integer> {
    Tag findByTagId(Integer tagId);   //通过tagId找到标签实体
    Tag findByName(String name);
//    void addTag(Tag tag);
}
