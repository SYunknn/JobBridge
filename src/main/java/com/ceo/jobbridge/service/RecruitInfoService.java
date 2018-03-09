package com.ceo.jobbridge.service;

import com.ceo.jobbridge.model.RecruitInfo;
import com.ceo.jobbridge.repository.RecruitInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Map;


/**
 * Created by SYunk on 2017/7/21.
 */
@Service
public class RecruitInfoService {

    @Autowired
    private RecruitInfoRepository recruitInfoRepository;


    /**
     * 更新haveDelete
     * */
    @Transactional
    @Modifying
    public void updateHaveDeleteById(Long recruitInfoId){
        RecruitInfo recruitInfo = recruitInfoRepository.findByRecruitInfoId(recruitInfoId);
        if(recruitInfo == null){
            System.out.println("没找到需要更新的RecruitInfo");
        }else{
            recruitInfo.setHaveDelete(true);
            recruitInfoRepository.save(recruitInfo);
        }
    }


    /**
     * 添加
     * */
    @Transactional
    public void addRecruitInfo(RecruitInfo recruitInfo){
        try {
            recruitInfoRepository.save(recruitInfo);
        } catch (Exception e) {
            System.out.println(e.getLocalizedMessage());
        }
    }


    /**
     * 更新
     * */
    @Transactional
    @Modifying
    public void updateRecruitInfoById(Map<String,Object> map){

        Long recruitInfoId = (Long)map.get("recruitInfoId");
        String jobName = (String)map.get("jobName");
        String jobDescribe = (String)map.get("jobDescribe");
        String jobRequire = (String)map.get("jobRequire");
        String location = (String)map.get("location");
        Integer lowSalary = (Integer)map.get("lowSalary");
        Integer highSalary = (Integer)map.get("highSalary");
        String deadline = (String) map.get("deadline");

        RecruitInfo recruitInfo = recruitInfoRepository.findByRecruitInfoId(recruitInfoId);
        if(recruitInfo == null){
            System.out.println("需要更新的RecruitInfo不存在");
        }else{
            recruitInfo.setJobName(jobName);
            recruitInfo.setJobDescribe(jobDescribe);
            recruitInfo.setJobRequire(jobRequire);
            recruitInfo.setLocation(location);
            recruitInfo.setLowSalary(lowSalary);
            recruitInfo.setHighSalary(highSalary);
            recruitInfo.setDeadline(deadline);

            recruitInfoRepository.save(recruitInfo);
        }

    }

    /**
     * 根据id删除
     * */
    @Transactional
    @Modifying
    public void deleteRecruitInfoById(Long recruitInfoId){
        RecruitInfo recruitInfo = recruitInfoRepository.findByRecruitInfoId(recruitInfoId);
        if(recruitInfo == null){
            System.out.println("要删除的RecruitInfo不存在");
        }else{
            recruitInfoRepository.delete(recruitInfo);
        }
    }



    /*private SqlSessionFactory sessionFactory;
    private SqlSession session;
    public RecruitInfoService() {
        sessionFactory = SqlSessionUtil.sqlSessionFactoryBuild();
    }

    public RecruitInfo findRecruitInfoById(Long recruitInfoId){
        String statement = "recruitInfoMapper.findRecruitInfoById";
        RecruitInfo recruitInfo = null;
        try{
            session = sessionFactory.openSession();
            recruitInfo = session.selectOne(statement,recruitInfoId);
        }catch(Exception e){
            e.printStackTrace();
        }finally {
            session.close();
        }
        return recruitInfo;
    }
    public List<RecruitInfo> findRecruitInfoByEnterpriseId(Long enterpriseId){
        String statement = "recruitInfoMapper.findRecruitInfoByEnterpriseId";
        List<Object> list = SqlSessionUtil.selectListOp(statement,enterpriseId,sessionFactory);
        if(list.isEmpty()){
            return null;
        }else{
            List<RecruitInfo> recruitInfoList = new ArrayList<>();
            for(Object object:list){
                recruitInfoList.add((RecruitInfo) object);
            }
            return recruitInfoList;
        }
    }
    public RecruitInfo findLastRecruitInfoByEnterpriseId(Long enterpriseId){
        String statement = "recruitInfoMapper.findLastRecruitInfoByEnterpriseId";
        Object object = SqlSessionUtil.selectOp(statement,enterpriseId,sessionFactory);
        if(object instanceof RecruitInfo){
            return (RecruitInfo)object;
        }else{
            return null;
        }
    }
    public List<RecruitInfo> findRecruitInfoByLocation(String location){
        String statement = "recruitInfoMapper.findRecruitInfoByLocation";
        List<Object> list = SqlSessionUtil.selectListOp(statement,location,sessionFactory);
        if(list == null || list.isEmpty()){
            return null;
        }else{
            List<RecruitInfo> recruitInfoList = new ArrayList<>();
            for(Object object:list) {
                recruitInfoList.add((RecruitInfo)object);
            }
            return recruitInfoList;
        }
    }
    public void updateHaveDeleteById(Long recruitInfoId){
        String statement = "recruitInfoMapper.updateHaveDeleteById";
        try{
            session = sessionFactory.openSession();
            int result = session.update(statement,recruitInfoId);
            session.commit();  //一定要记得commit
            if(result > 0){
                System.out.println("修改成功");
            }else{
                System.out.println("修改失败");
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            session.close();
        }
    }
    public int findNumOfRecruitInfo(){
        String statement = "recruitInfoMapper.findNumOfRecruitInfo";
        int number = 0;
        try{
            session = sessionFactory.openSession();
            number = session.selectOne(statement);
        }catch(Exception e){
            e.printStackTrace();
        }finally {
            session.close();
        }
        return number;
    }
    public List<RecruitInfo> findRecruitInfoOrderByTime(Map<String,Object> map){
        String statement = "recruitInfoMapper.findRecruitInfoOrderByTime";
        List<Object> list = SqlSessionUtil.selectListOp(statement,map,sessionFactory);
        if(list == null || list.isEmpty()){
            return null;
        }else{
            List<RecruitInfo> recruitInfoIdList = new ArrayList<>();
            for(Object object:list){
                recruitInfoIdList.add((RecruitInfo)object);
            }
            return recruitInfoIdList;
        }
    }
    public void addRecruitInfo(RecruitInfo recruitInfo){
        String statement = "recruitInfoMapper.addRecruitInfo";
        try{
            session = sessionFactory.openSession();
            int result = session.insert(statement,recruitInfo);
            session.commit();  //一定要记得commit
            if(result > 0){
                System.out.println("招聘信息添加成功");
            }else{
                System.out.println("招聘信息添加失败");
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            session.close();
        }
    }
    public void updateRecruitInfoById(Map<String,Object> map){
        String statement = "recruitInfoMapper.updateRecruitInfoById";
        try{
            session = sessionFactory.openSession();
            int result = session.update(statement,map);
            session.commit();  //一定要记得commit
            if(result > 0){
                System.out.println("招聘信息修改成功");
            }else{
                System.out.println("招聘信息修改失败");
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            session.close();
        }
    }
    public void deleteRecruitInfoById(Long recruitInfoId){
        String statement = "recruitInfoMapper.deleteRecruitInfoById";
        try{
            session = sessionFactory.openSession();
            int result = session.delete(statement,recruitInfoId);
            session.commit();
            if(result > 0){
                System.out.println("招聘信息删除成功：" + recruitInfoId);
            }else{
                System.out.println("招聘信息删除失败：" + recruitInfoId);
            }
        }catch(Exception e){
            e.printStackTrace();
        }finally {
            session.close();
        }
    }*/
}
