/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package project.sem4.movie.service;

import java.util.List;
import project.sem4.movie.entities.Reviews;

/**
 *
 * @author NTT
 */
public interface ReviewService {
    List<Reviews> getAllReviews();
    
    Reviews getReviewyId(int cinema_id);
    
    Reviews pushReview(Reviews newReview);
    
    Reviews updateReview(Reviews updateReview, int review_id);
    
    void deleteReviewById(int review_id);
}
