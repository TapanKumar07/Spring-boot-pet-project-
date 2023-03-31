package com.tapan.movieBookingSystem.Entities;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Data
public class Movie {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int movieId;

    @Column(length = 50, nullable = false, unique = true, name = "movie_ka_naam")
    private String movieName;

    @Column(length = 500, nullable = false)
    private String movieDescription;

    @Column(nullable = false)
    private LocalDateTime releaseDate;

    @Column(nullable = false)
    private int duration;

    @Column(length = 500, nullable = false)
    private String coverPhotoUrl;

    @Column(length = 500, nullable = false)
    private String trailerUrl;

    @JoinTable(name = "MovTh", joinColumns = @JoinColumn(name = "movie_id"),
    inverseJoinColumns = @JoinColumn(name ="theatre_id"))
    @ManyToMany
    private List<Theatre> theaters;

}
