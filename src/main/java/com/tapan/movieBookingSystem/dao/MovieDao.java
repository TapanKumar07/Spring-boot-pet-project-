package com.tapan.movieBookingSystem.dao;

import com.tapan.movieBookingSystem.Entities.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.List;

public interface MovieDao extends JpaRepository<Movie, Integer> {

    public List<Movie> findByDurationGreaterThan(int duration);

    public List<Movie> findByDurationLessThan(int duration);

    public Movie findByDurationAndMovieName(int duration, String name);

    public List<Movie> findByReleaseDateLessThan(LocalDateTime date);
    public List<Movie> findByReleaseDateGreaterThan(LocalDateTime date);




}
