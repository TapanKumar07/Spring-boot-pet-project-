package com.tapan.movieBookingSystem.converters;

import com.tapan.movieBookingSystem.Entities.Movie;
import com.tapan.movieBookingSystem.dto.MovieDto;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MovieConvertor {
    @Autowired
    private ModelMapper _modalmapper;

    public MovieDto ConvertToMovieDto(Movie movie) {
        return _modalmapper.map(movie, MovieDto.class);
    }

    public Movie ConvertToMovie(MovieDto movieDto) {
        return _modalmapper.map(movieDto, Movie.class);
    }
}
