package com.tapan.movieBookingSystem.services;

import com.tapan.movieBookingSystem.Entities.Movie;
import com.tapan.movieBookingSystem.Exceptions.movieNotFoundException;

import java.util.List;

public interface movieService {
    /**
     *  Movie Save
     */
    public Movie saveMovieDetails(Movie movie);

    /**
     *  Get movie from Id
     */
    public Movie getMovieDetails(int id) throws movieNotFoundException;

    /**
     * Update a movie
     */
    public Movie updateMovieDetails(Movie movie, int id) throws movieNotFoundException;

    /**
     * Get List of movies
     */
    public List<Movie> getMoviesList();

    /**
     * Delete a movie
     */
    public Boolean deleteMovieDetails(int id) throws movieNotFoundException;
}
