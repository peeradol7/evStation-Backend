package com.itsci.projectev.services;

import com.itsci.projectev.models.Reserve;
import com.itsci.projectev.models.Review;
import com.itsci.projectev.repositories.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Service
public class ReviewServiceImpl implements ReviewService{

    @Autowired
    private ReviewRepository reviewRepository;

    @Override
    public List<Review> getAllReview() {
        return reviewRepository.findAll();
    }

    @Override
    public Review addReview(Map<String, String> map) {
        int reviewid;
        double score;
        try{
            reviewid = Integer.parseInt(map.get("reviewId"));
            score = Double.parseDouble(map.get("score"));
        }catch (NumberFormatException e){
            return null;
        }
        String comment = map.get("comment");
        SimpleDateFormat dateTimeFormat = new SimpleDateFormat("dd/MM/yyyy");
        Date reviewDate;
        try{
            reviewDate = dateTimeFormat.parse(map.get("reviewDate"));
        }catch (ParseException e){
            e.printStackTrace();
            return null;
        }

        Reserve reserve = reviewRepository.findById(map.get("reserveId")).orElse(null).getReserve();
        Review review = new Review(reviewid, score, comment, reviewDate, reserve);
        return reviewRepository.save(review);
    }

    @Override
    public Review getReviewById(String reviewId) {
        return reviewRepository.getReferenceById(reviewId);
    }

    @Override
    public void deleteReview(String reviewId) {
        Review review = reviewRepository.getReferenceById(reviewId);
        reviewRepository.delete(review);
    }
}
