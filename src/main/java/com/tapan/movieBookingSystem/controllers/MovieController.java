package com.tapan.movieBookingSystem.controllers;


import com.tapan.movieBookingSystem.Entities.Movie;
import com.tapan.movieBookingSystem.services.movieService;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
/**
 * 1. @Component
 * 2. Give hint to Spring, that whenever a REST call comes, make sure this call
 *    intercepts/informed
 */
@RequestMapping("/movies")
/**
 * Movie Controller will take care of /movies
 */
public class MovieController {

    private movieService _movieService;
    @GetMapping("/greetings")
    public ResponseEntity Greet() {
        return new ResponseEntity("Hello People", HttpStatus.OK);
    }

    @GetMapping("/getAllMovies")
    public ResponseEntity getAll() {
        List<Movie> movies = _movieService.getMoviesList();

        return new ResponseEntity(, HttpStatus.OK);
    }
}
