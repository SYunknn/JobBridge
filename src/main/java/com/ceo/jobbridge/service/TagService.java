package com.ceo.jobbridge.service;

import com.ceo.jobbridge.model.Tag;
import com.ceo.jobbridge.repository.TagRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

/**
 * Created by Administrator on 2017/7/24 0024.
 */

@Service
public class TagService {

    @Autowired
    private TagRepository tagRepository;

    @Transactional
    public void addTag(Tag tag){
        try {
            tagRepository.save(tag);
        } catch (Exception e) {
            System.out.println(e.getLocalizedMessage());
        }
    }


   /* private SqlSessionFactory sessionFactory;

    public TagService(){
        sessionFactory = SqlSessionUtil.sqlSessionFactoryBuild();
    }

    @Override
    public Tag findTagByName(String name){
        String statement = "tagMapper.findTagByName";
        Object object = SqlSessionUtil.selectOp(statement,name,sessionFactory);
        if(object instanceof Tag){
            return (Tag) object;
        }else{
            return null;
        }
    }

    @Override
    public Tag findTagByTagId(Integer tagId) {
        String statement = "tagMapper.findTagByTagId";
        Tag tag = (Tag)SqlSessionUtil.selectOp(statement,tagId,sessionFactory);
        return tag;
    }

    @Override
    public void addTag(Tag tag){
        String statement = "tagMapper.addTag";
        SqlSessionUtil.insertOp(statement,tag,sessionFactory);
    }*/
}
