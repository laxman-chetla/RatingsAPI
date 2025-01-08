package com.Model;
import javax.persistence.*;
import java.time.LocalDateTime;
@Entity
public class Rating {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "volunteer_id")
    private Volunteer volunteer;

    @ManyToOne
    @JoinColumn(name = "organization_id")
    private Organization organization;

    private int rating; // 1-5
    private String review;
    private LocalDateTime createdAt = LocalDateTime.now();

    // Getters and Setters
}