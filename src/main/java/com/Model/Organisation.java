package com.Model;
import javax.persistence.*;
        import java.util.List;
@Entity
public class Organization {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    @OneToMany(mappedBy = "organization", cascade = CascadeType.ALL)
    private List<Rating> ratings;

    // Getters and Setters
}