package com.tapan.movieBookingSystem;

import com.tapan.movieBookingSystem.Entities.Movie;
import com.tapan.movieBookingSystem.dao.MovieDao;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.time.LocalDateTime;
import java.util.List;

@SpringBootApplication
public class MovieBookingSystemApplication {

	public static void main(String[] args) {

		ApplicationContext ctx = SpringApplication.run(MovieBookingSystemApplication.class, args);

		MovieDao movieDao = ctx.getBean(MovieDao.class);
		Movie m = new Movie();
		m.setDuration(150);
		m.setCoverPhotoUrl("Cover-photo-url");
		m.setTrailerUrl("trailer - rel");
		m.setMovieName("John wick 5");
		m.setReleaseDate(LocalDateTime.of(2022, 2,12,12,12));
		m.setMovieDescription("This is dog lover movie");
		Movie mk = movieDao.save(m);
		System.out.println(mk);

//
		Movie m1 = new Movie();
		m1.setMovieId(5);
		m1.setDuration(100);
		m1.setCoverPhotoUrl("Cover-photo-url");
		m1.setTrailerUrl("trailer - rel");
		m1.setMovieName("Tatya Bichuu");
		m1.setReleaseDate(LocalDateTime.of(2022, 2,12,12,12));
		m1.setMovieDescription("This is tatya");
		movieDao.save(m1);

//
		Movie m2 = new Movie();
		m2.setMovieId(3);
		m2.setDuration(50);
		m2.setCoverPhotoUrl("Cover-photo-url");
		m2.setTrailerUrl("trailer - rel");
		m2.setMovieName("Elon musk");
		m2.setReleaseDate(LocalDateTime.of(2022, 2,12,12,12));
		m2.setMovieDescription("This is elon");
		movieDao.save(m2);



		List<Movie> ans = movieDao.findByDurationLessThan(200);
        ans.forEach((e) -> System.out.println(e));

		//movieDao.delete(m11);
		System.out.println("Hello Spring!");
	}

}
