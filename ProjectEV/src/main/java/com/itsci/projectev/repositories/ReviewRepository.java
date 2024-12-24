package com.itsci.projectev.repositories;

import com.itsci.projectev.models.Review;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReviewRepository extends JpaRepository<Review, String> {
}
