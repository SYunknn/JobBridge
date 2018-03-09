package com.ceo.jobbridge.repository;

import com.ceo.jobbridge.model.RecruitInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Map;

/**
 * Created by SYunk on 2017/7/21.
 */
public interface RecruitInfoRepository extends JpaRepository<RecruitInfo,Long> {
    RecruitInfo findByRecruitInfoId(Long recruitInfoId);

    List<RecruitInfo> findByEnterpriseId(Long enterpriseId);

    // RecruitInfo findLastRecruitInfoByEnterpriseId(Long enterpriseId);
    //@Query("select r_i from recruit_info r_i where r_i.enterprise_id = :enterpriseId and r_i.date_time >= all(select ri.date_time from recruit_info ri where ri.enterprise_id = :enterpriseId)")
    @Query(value = "select * from recruit_info where enterprise_id = :enterpriseId and date_time >= all( select date_time from recruit_info where enterprise_id = :enterpriseId )", nativeQuery = true)
    RecruitInfo findLastRecruitInfoByEnterpriseId(@Param("enterpriseId") Long enterpriseId);

    List<RecruitInfo> findByLocation(String location);

    // void updateHaveDeleteById(Long recruitInfoId);

    // int findNumOfRecruitInfo();
    long count();


    //@Query("select r_i from recruit_info r_i where r_i.have_delete = false  order by r_i.date_time desc limit :offset, :limit")
    //List<RecruitInfo> findRecruitInfoOrderByTime(Map<String,Object> map);
    //@Query("select r_i from recruit_info r_i where r_i.have_delete = false order by date_time desc limit #{offset},#{limit}")
    // TODO: 需要测试
    @Query(value = "select * from recruit_info where have_delete = false order by date_time desc limit :offset, :limit", nativeQuery = true)
    List<RecruitInfo> findRecruitInfoOrderByTime(@Param("offset") Integer offset, @Param("limit") Integer limit); // Map<String,Object> map

    // void addRecruitInfo(RecruitInfo recruitInfo);

    // void updateRecruitInfoById(Map<String,Object> map);

    // void deleteRecruitInfoById(Long recruitInfoId);
}
