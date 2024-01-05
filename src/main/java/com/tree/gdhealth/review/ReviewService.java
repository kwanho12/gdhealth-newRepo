package com.tree.gdhealth.review;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tree.gdhealth.vo.Review;

@Service
@Transactional
public class ReviewService {
	@Autowired ReviewMapper reviewMapper;
	
	//리스트
	public List<Review> reviewList(){
		List<Review> resultReviewList = reviewMapper.reviewList();
		return resultReviewList;
	}
	//상세
	public Review reviewOne(int reviewNo) {
		Review resultReviewOne = reviewMapper.reviewOne(reviewNo);
		System.out.println("resultReviewOne: " + resultReviewOne);
		
		return resultReviewOne;
	}
	//추가
	public int addreview(Review review) {
		// TODO Auto-generated method stub
		return 0;
	}
	public int deleteReview(Review review) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	//수정
	
	//삭제
}


