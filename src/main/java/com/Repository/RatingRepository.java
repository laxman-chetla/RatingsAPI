package com.Repository;
import com.RatingsAPI.Rating.model.Rating;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
public interface RatingRepository extends JpaRepository<Rating, Long> {
    List<Rating> findByVolunteerId(Long volunteerId);
}