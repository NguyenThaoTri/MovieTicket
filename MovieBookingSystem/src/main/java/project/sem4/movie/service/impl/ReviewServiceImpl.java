package project.sem4.movie.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import project.sem4.movie.entities.Reviews;
import project.sem4.movie.repository.ReviewRepository;
import project.sem4.movie.service.ReviewService;

import java.util.List;
import java.util.Optional;

@Service
public class ReviewServiceImpl implements ReviewService {

    private final ReviewRepository reviewRepository;

    @Autowired
    public ReviewServiceImpl(ReviewRepository reviewRepository) {
        this.reviewRepository = reviewRepository;
    }

    @Override
    public List<Reviews> getAllReviews() {
        return reviewRepository.findAll();
    }

    @Override
    public Reviews getReviewyId(int reviewId) {
        Optional<Reviews> optionalReview = reviewRepository.findById(reviewId);
        return optionalReview.orElse(null);
    }

    @Override
    public Reviews pushReview(Reviews newReview) {
        return reviewRepository.save(newReview);
    }

    @Override
    public Reviews updateReview(Reviews updateReview, int reviewId) {
        Optional<Reviews> optionalReview = reviewRepository.findById(reviewId);
        if (optionalReview.isPresent()) {
            Reviews existingReview = optionalReview.get();
            existingReview.setRating(updateReview.getRating());
            existingReview.setComment(updateReview.getComment());
            existingReview.setReviewDate(updateReview.getReviewDate());
            // Update other attributes as needed

            return reviewRepository.save(existingReview);
        }
        return null; // Review with given ID not found
    }

    @Override
    public void deleteReviewById(int reviewId) {
        reviewRepository.deleteById(reviewId);
    }
}
