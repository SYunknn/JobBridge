package com.ceo.jobbridge.service;

import com.ceo.jobbridge.model.Review;
import com.ceo.jobbridge.repository.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;


/**
 * Created by HanrAx on 2017/7/20.
 */

@Service
public class ReviewService {

    @Autowired
    private ReviewRepository reviewRepository;

    /**
     * 新增评论
     * */
    @Transactional
    public void addReview(Review review){
        try {
            reviewRepository.save(review);
        } catch (Exception e) {
            System.out.println(e.getLocalizedMessage());
        }
    }

    /**
     * 删除评论
     * */
    @Transactional
    @Modifying
    public void deleteReview(Long studentId, Long enterpriseId){
        Review review = reviewRepository.findByStudentIdAndEnterpriseId(studentId, enterpriseId);
        if(review == null){
            System.out.println("没找到要删除的评论");
        }else{
            reviewRepository.delete(review);
        }
    }

    /*private SqlSessionFactory sessionFactory;
    private SqlSession session;
    public ReviewService() {
        String resource = "mybatisConf.xml";
        try {
            Reader reader = Resources.getResourceAsReader(resource);
            sessionFactory = new SqlSessionFactoryBuilder().build(reader);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Review> findReviewByStudentId(Long studentId) {
        String statement = "reviewMapper.findReviewByStudentId";
        List<Review> list = null;
        try{
            session = sessionFactory.openSession();
            list = session.selectList(statement,studentId);
        }catch(Exception e){
            e.printStackTrace();
        }finally {
            session.close();
        }
        return list;
    }

    @Override
    public List<Review> findReviewByEnterpriseId(Long enterpriseId) {
        String statement = "reviewMapper.findReviewByEnterpriseId";
        List<Review> list = null;
        try{
            session = sessionFactory.openSession();
            list = session.selectList(statement,enterpriseId);
        }catch(Exception e){
            e.printStackTrace();
        }finally {
            session.close();
        }
        return list;
    }

    @Override
    public void addReview(Review review) {
        String statement = "reviewMapper.addReview";
        try{
            session = sessionFactory.openSession();
            int result = session.insert(statement,review);
            session.commit();  //一定要记得commit
            if(result > 0){
                System.out.println("评论成功");
            }else{
                System.out.println("评论失败，请重试");
            }
        }catch(Exception e){
            e.printStackTrace();
        }finally {
            session.close();
        }
    }

    @Override
    public void deleteReviewById(Map<String,Object> map) {
        String statement = "reviewMapper.deleteReviewById";
        try{
            session = sessionFactory.openSession();
            int result = session.delete(statement, map);
            session.commit();  //一定要记得commit
            if(result > 0){
                System.out.println("删除评论成功");
            }else{
                System.out.println("删除评论失败");
            }
        }catch(Exception e){
            e.printStackTrace();
        }finally {
            session.close();
        }
    }*/
}
