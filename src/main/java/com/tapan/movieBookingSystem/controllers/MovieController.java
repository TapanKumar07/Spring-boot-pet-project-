package com.tapan.movieBookingSystem.controllers;


import com.tapan.movieBookingSystem.Entities.Movie;
import com.tapan.movieBookingSystem.Exceptions.movieNotFoundException;
import com.tapan.movieBookingSystem.converters.MovieConvertor;
import com.tapan.movieBookingSystem.dto.MovieDto;
import com.tapan.movieBookingSystem.services.movieService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.print.attribute.standard.Media;
import java.util.ArrayList;
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

    @Autowired
    private movieService _movieService;

    @GetMapping("/greetings")
    public ResponseEntity<String> Greet() {
        return new ResponseEntity<String>("Hello People", HttpStatus.OK);
    }

    @GetMapping("/getAllMovies")
    public ResponseEntity<List<MovieDto>> getAll() {
        return new ResponseEntity<List<MovieDto>>(_movieService.getMoviesList(), HttpStatus.OK);
    }

    @GetMapping("/{movieId}")
    public ResponseEntity<MovieDto> getById(@PathVariable(name = "movieId") int movieId) throws movieNotFoundException {
          return new ResponseEntity<MovieDto>(_movieService.getMovieDetails(movieId), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<MovieDto> createMovie(@RequestBody MovieDto movieDTO) {
           return new ResponseEntity<MovieDto>(_movieService.saveMovieDetails(movieDTO), HttpStatus.CREATED);
    }

    @PutMapping(value = "/{movieId}")
    public ResponseEntity<MovieDto> updateDetails(@PathVariable(name = "movieId") int movieId,@RequestBody MovieDto MovieDTO) throws movieNotFoundException{
        return new ResponseEntity<>(_movieService.updateMovieDetails(MovieDTO, movieId), HttpStatus.ACCEPTED);
    }

    @DeleteMapping(value = "/{movieId}")
    public ResponseEntity<Boolean> deleteMovie(@PathVariable(name = "movieId") int id) throws movieNotFoundException {
        return new ResponseEntity<Boolean>(_movieService.deleteMovieDetails(id), HttpStatus.OK);
    }

}
