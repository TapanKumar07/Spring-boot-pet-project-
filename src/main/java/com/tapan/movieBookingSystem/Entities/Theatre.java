package com.tapan.movieBookingSystem.Entities;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
public class Theatre {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int theatreId;

    @Column(length = 100, nullable = false, unique = true)
    private String theatreName;

    @Column(nullable = false)
    private float ticketPrice = 150.00f;

    @ManyToOne
    private City city;

    @ManyToMany(mappedBy = "theaters")
    private List<Movie> movies;

}
