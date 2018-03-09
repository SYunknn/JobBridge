package com.ceo.jobbridge.repository;

import com.ceo.jobbridge.model.RecruitInfoTag;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by SYunk on 2017/7/25.
 */
public interface RecruitInfoTagRepository extends JpaRepository<RecruitInfoTag,Long> {
    List<RecruitInfoTag> findByRecruitInfoId(Long recruitInfoId);
    List<RecruitInfoTag> findByTagId(Integer tagId);
    //void addRecruitInfoTag(RecruitInfoTag recruitInfoTag);
    //void deleteRecruitInfoTagByRecruitInfoId(Long recruitInfoId);
}
