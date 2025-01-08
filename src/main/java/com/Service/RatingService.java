package com.Service;
import com.RatingsAPI.Rating.model.Rating;
import com.RatingsAPI.Rating.repository.RatingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RatingService {

    @Autowired
    private RatingRepository ratingRepository;

    public Rating saveRating(Rating rating) {
        return ratingRepository.save(rating);
    }

    public List<Rating> getRatingsForVolunteer(Long volunteerId) {
        return ratingRepository.findByVolunteerId(volunteerId);
    }

    public Optional<Rating> updateRating(Long id, Rating updatedRating) {
        return ratingRepository.findById(id).map(rating -> {
            rating.setRating(updatedRating.getRating());
            rating.setReview(updatedRating.getReview());
            return ratingRepository.save(rating);
        });
    }

    public void deleteRating(Long id) {
        ratingRepository.deleteById(id);
    }
}