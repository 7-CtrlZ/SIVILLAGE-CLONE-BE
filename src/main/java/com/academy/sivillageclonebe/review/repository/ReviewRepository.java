package com.academy.sivillageclonebe.review.repository;


import com.academy.sivillageclonebe.review.entity.Review;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ReviewRepository extends JpaRepository<Review, Long> {

    Optional<Review> findByReviewUuid(String reviewUuid);

}
