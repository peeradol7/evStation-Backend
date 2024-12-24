package com.itsci.projectev.controllers;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.itsci.projectev.models.Review;
import com.itsci.projectev.services.ReviewService;

@RestController
@RequestMapping("/reviews")
public class ReviewController {
    @Autowired
    private ReviewService reviewService;

    @PostMapping("/list")
    public ResponseEntity getListReview(){
        try {
            List<Review> reviews = reviewService.getAllReview();
            return new ResponseEntity(reviews, HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/add")
    public ResponseEntity addReview(@RequestBody Map<String, String> map){
        try {
            Review review = reviewService.addReview(map);
            return new ResponseEntity(review, HttpStatus.OK);
        }catch (Exception e){
            e.printStackTrace();
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/getReviewById/{reviewId}")
    public ResponseEntity getReviewById(@PathVariable("reviewId") String reviewId) throws IllegalAccessError{
        try{
            Review review = reviewService.getReviewById(reviewId);
            return new ResponseEntity(review, HttpStatus.OK);
        }catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/delete/{reviewId}")
    public ResponseEntity dodeleteReview(@PathVariable("reviewId") String reviewId){
        try{
            reviewService.deleteReview(reviewId);
            return new ResponseEntity<>("Review ID : " + reviewId + "was delete!", HttpStatus.OK);
        }catch (Exception e){
            e.printStackTrace();
            return new ResponseEntity<>("Failed to delete!", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
