package com.Controller;
import com.RatingsAPI.Rating.model.Rating;
import com.RatingsAPI.Rating.service.RatingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;
@RestController
@RequestMapping("/api/ratings")
public class RatingController {

    @Autowired
    private RatingService ratingService;

    @PostMapping("/rate-volunteer")
    public ResponseEntity<String> rateVolunteer(@RequestBody Rating rating) {
        ratingService.saveRating(rating);
        return ResponseEntity.ok("Rating submitted successfully.");
    }

    @GetMapping("/view-ratings/{volunteerId}")
    public List<Rating> viewRatings(@PathVariable Long volunteerId) {
        return ratingService.getRatingsForVolunteer(volunteerId);
    }

    @PutMapping("/update-rating/{id}")
    public ResponseEntity<String> updateRating(@PathVariable Long id, @RequestBody Rating rating) {
        Optional<Rating> updatedRating = ratingService.updateRating(id, rating);
        if (updatedRating.isPresent()) {
            return ResponseEntity.ok("Rating updated successfully.");
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/remove-rating/{id}")
    public ResponseEntity<String> removeRating(@PathVariable Long id) {
        ratingService.deleteRating(id);
        return ResponseEntity.ok("Rating deleted successfully.");
    }
}