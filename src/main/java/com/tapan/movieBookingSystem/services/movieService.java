package com.tapan.movieBookingSystem.services;

import com.tapan.movieBookingSystem.Entities.Movie;
import com.tapan.movieBookingSystem.Exceptions.movieNotFoundException;
import com.tapan.movieBookingSystem.dto.MovieDto;

import java.util.List;

public interface movieService {
    /**
     *  Movie Save
     */
    public MovieDto saveMovieDetails(MovieDto movie);

    /**
     *  Get movie from Id
     */
    public MovieDto getMovieDetails(int id) throws movieNotFoundException;

    /**
     * Update a movie
     */
    public MovieDto updateMovieDetails(MovieDto movieDto, int id) throws movieNotFoundException;

    /**
     * Get List of movies
     */
    public List<MovieDto> getMoviesList();

    /**
     * Delete a movie
     */
    public Boolean deleteMovieDetails(int id) throws movieNotFoundException;

}
