package com.Model;
import javax.persistence.*;
import java.util.List;
@Entity
public class Volunteer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    @OneToMany(mappedBy = "volunteer", cascade = CascadeType.ALL)
    private List<Rating> ratings;

    // Getters and Setters
}