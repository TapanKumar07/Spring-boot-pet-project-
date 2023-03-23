package com.tapan.movieBookingSystem.services.Implementations;

import com.tapan.movieBookingSystem.Entities.Movie;
import com.tapan.movieBookingSystem.Exceptions.movieNotFoundException;
import com.tapan.movieBookingSystem.dao.MovieDao;
import com.tapan.movieBookingSystem.services.movieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class movieImpl implements movieService {

    @Autowired
    private MovieDao _moviedao;
    @Override
    public Movie saveMovieDetails(Movie movie) {
        //set object here
        return _moviedao.save(movie);
    }

    @Override
    public Movie getMovieDetails(int id) throws movieNotFoundException {
        return _moviedao.findById(id).orElseThrow(() -> new movieNotFoundException("Movie Details not found!"));
    }

    @Override
    public Movie updateMovieDetails(Movie movie, int id) throws movieNotFoundException {
        Movie retrived_movie = _moviedao.findById(id).orElseThrow(() -> new movieNotFoundException("Movie not found for updation"));

        if(movie.getMovieName() != null) retrived_movie.setMovieName(movie.getMovieName());

        if(movie.getMovieDescription() != null) retrived_movie.setMovieDescription(movie.getMovieDescription());

        if(movie.getTrailerUrl() != null) retrived_movie.setTrailerUrl(movie.getTrailerUrl());

        if(movie.getReleaseDate() != null) retrived_movie.setReleaseDate(movie.getReleaseDate());

        if(isNotNullOrZero(movie.getDuration())) retrived_movie.setDuration(movie.getDuration());

        if(isNotNullOrZero(movie.getCoverPhotoUrl())) retrived_movie.setCoverPhotoUrl(movie.getCoverPhotoUrl());

        return _moviedao.save(retrived_movie);
    }

    @Override
    public List<Movie> getMoviesList() {
        return _moviedao.findAll();
    }

    @Override
    public Boolean deleteMovieDetails(int id) throws movieNotFoundException {
        Movie to_be_deleted = _moviedao.findById(id).orElseThrow(() -> new movieNotFoundException("Nahi milit delete krne ko"));
        _moviedao.delete(to_be_deleted);
        return true;
    }

    public Boolean isNotNullOrZero(Object o) {
        return o != null;
    }

}
