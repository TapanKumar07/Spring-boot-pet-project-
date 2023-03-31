package com.tapan.movieBookingSystem.services.Implementations;

import com.tapan.movieBookingSystem.Entities.Movie;
import com.tapan.movieBookingSystem.Exceptions.movieNotFoundException;
import com.tapan.movieBookingSystem.converters.MovieConvertor;
import com.tapan.movieBookingSystem.dao.MovieDao;
import com.tapan.movieBookingSystem.dto.MovieDto;
import com.tapan.movieBookingSystem.services.movieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class movieImpl implements movieService {

    @Autowired
    private MovieDao _moviedao;

    @Autowired
    private MovieConvertor _convertor;
    @Override
    public MovieDto saveMovieDetails(MovieDto movieDTO) {
        //set object here
        Movie m = _convertor.ConvertToMovie(movieDTO);
        Movie saved_movie = _moviedao.save(m);
        return _convertor.ConvertToMovieDto(saved_movie);
    }

    @Override
    public MovieDto getMovieDetails(int id) throws movieNotFoundException {

        Movie m = _moviedao.findById(id).orElseThrow(() -> new movieNotFoundException("Movie Details not found!"));
        return _convertor.ConvertToMovieDto(m);
    }

    @Override
    public MovieDto updateMovieDetails(MovieDto movie, int id) throws movieNotFoundException {
        Movie retrived_movie = _moviedao.findById(id).orElseThrow(() -> new movieNotFoundException("Movie not found for updation"));

        if(movie.getMovieName() != null) retrived_movie.setMovieName(movie.getMovieName());

        if(movie.getMovieDescription() != null) retrived_movie.setMovieDescription(movie.getMovieDescription());

        if(movie.getTrailerUrl() != null) retrived_movie.setTrailerUrl(movie.getTrailerUrl());

        if(movie.getReleaseDate() != null) retrived_movie.setReleaseDate(movie.getReleaseDate());

        if(isNotNullOrZero(movie.getDuration())) retrived_movie.setDuration(movie.getDuration());

        if(isNotNullOrZero(movie.getCoverPhotoUrl())) retrived_movie.setCoverPhotoUrl(movie.getCoverPhotoUrl());

        Movie saved_response = _moviedao.save(retrived_movie);
        return _convertor.ConvertToMovieDto(saved_response);
    }

    @Override
    public List<MovieDto> getMoviesList() {
        List<Movie> movies = _moviedao.findAll();
        List<MovieDto> movieDtos = new ArrayList<>();
        for(Movie m : movies) {
            movieDtos.add(_convertor.ConvertToMovieDto(m));
        }
        return movieDtos;
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
