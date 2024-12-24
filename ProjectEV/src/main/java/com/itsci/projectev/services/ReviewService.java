package com.itsci.projectev.services;

import com.itsci.projectev.models.Review;

import java.util.List;
import java.util.Map;

public interface ReviewService {
    List<Review> getAllReview();
    Review addReview(Map<String, String> map);
    Review getReviewById(String reviewId);
    void deleteReview(String reviewId);
}
