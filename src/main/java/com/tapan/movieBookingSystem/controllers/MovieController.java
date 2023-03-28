package com.tapan.movieBookingSystem.controllers;


import com.tapan.movieBookingSystem.Entities.Movie;
import com.tapan.movieBookingSystem.Exceptions.movieNotFoundException;
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

    @Autowired
    private ModelMapper _modalmapper;
    @GetMapping("/greetings")
    public ResponseEntity Greet() {
        return new ResponseEntity("Hello People", HttpStatus.OK);
    }

    @GetMapping("/getAllMovies")
    public ResponseEntity getAll() {
        List<Movie> movies = _movieService.getMoviesList();

        List<MovieDto> movieDtos = new ArrayList<>();
        for(Movie m : movies) {
             movieDtos.add(covertToMovieDto(m));
        }

        return new ResponseEntity(movieDtos, HttpStatus.OK);
    }

    @GetMapping("/{movieId}")
    public ResponseEntity getById(@PathVariable(name = "movieId") int movieId) throws movieNotFoundException {
          Movie movie = _movieService.getMovieDetails(movieId);
          MovieDto mv = covertToMovieDto(movie);
          return new ResponseEntity(mv, HttpStatus.OK);
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE,
    produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity createMovie(@RequestBody MovieDto movieDTO) {

           Movie movie = _modalmapper.map(movieDTO, Movie.class);
           _movieService.saveMovieDetails(movie);
           MovieDto myMovie = covertToMovieDto(movie);
           return new ResponseEntity(myMovie, HttpStatus.CREATED);
    }

    @PutMapping(value = "/{movieId}", consumes = MediaType.APPLICATION_JSON_VALUE,
    produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity updateDetails(@PathVariable(name = "movieId") int movieId,@RequestBody MovieDto MovieDTO) throws movieNotFoundException{
        Movie movie = _movieService.getMovieDetails(movieId);

        Movie to_be_updated_with = _modalmapper.map(MovieDTO, Movie.class);
        Movie responsee = _movieService.updateMovieDetails(to_be_updated_with, movieId);
        MovieDto savedResponse = covertToMovieDto(responsee);

        return new ResponseEntity(savedResponse, HttpStatus.ACCEPTED);
    }

    @DeleteMapping(value = "/{movieId}")
    public ResponseEntity deleteMovie(@PathVariable(name = "movieId") int id) throws movieNotFoundException {
        _movieService.deleteMovieDetails(id);

        return new ResponseEntity("DELETED!", HttpStatus.OK);
    }

    public MovieDto covertToMovieDto(Movie movie) {
        MovieDto moviedto = _modalmapper.map(movie, MovieDto.class);
        return moviedto;
    }
}
