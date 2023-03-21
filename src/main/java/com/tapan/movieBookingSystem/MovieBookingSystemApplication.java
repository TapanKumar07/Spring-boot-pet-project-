package com.tapan.movieBookingSystem;

import com.tapan.movieBookingSystem.Entities.Movie;
import com.tapan.movieBookingSystem.Entities.User;
import com.tapan.movieBookingSystem.Exceptions.UserNameAlreadyExists;
import com.tapan.movieBookingSystem.Exceptions.movieNotFoundException;
import com.tapan.movieBookingSystem.dao.MovieDao;
import com.tapan.movieBookingSystem.services.UserService;
import com.tapan.movieBookingSystem.services.initService;
import com.tapan.movieBookingSystem.services.movieService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

import java.time.LocalDateTime;
import java.util.List;

@SpringBootApplication
public class MovieBookingSystemApplication {

	public static void main(String[] args) {

		ApplicationContext ctx = SpringApplication.run(MovieBookingSystemApplication.class, args);

		//MovieDao movieDao = ctx.getBean(MovieDao.class);
		movieService _movieService = ctx.getBean(movieService.class);
		Movie m = new Movie();
		m.setDuration(150);
		m.setCoverPhotoUrl("Cover-photo-url");
		m.setTrailerUrl("trailer - rel");
		m.setMovieName("John wick 5");
		m.setReleaseDate(LocalDateTime.of(2022, 2,12,12,12));
		m.setMovieDescription("This is dog lover movie");
//		Movie mk = movieDao.save(m);
		//System.out.println(mk);
		_movieService.saveMovieDetails(m);


//
		Movie m1 = new Movie();
		m1.setMovieId(5);
		m1.setDuration(100);
		m1.setCoverPhotoUrl("Cover-photo-url");
		m1.setTrailerUrl("trailer - rel");
		m1.setMovieName("Tatya Bichuu");
		m1.setReleaseDate(LocalDateTime.of(2022, 2,12,12,12));
		m1.setMovieDescription("This is tatya");
//		movieDao.save(m1);
		_movieService.saveMovieDetails(m1);

		Movie m2 = new Movie();
		m2.setMovieId(5);
		m2.setDuration(100);
		m2.setCoverPhotoUrl("Tanjiroo");
		m2.setTrailerUrl("trailer - rel");
		m2.setMovieName("Demon Slayer");
		m2.setReleaseDate(LocalDateTime.of(2022, 2,12,12,12));
		m2.setMovieDescription("Sword and Battle");


		try {
			_movieService.updateMovieDetails(m2 , 2);
		} catch (movieNotFoundException e) {
			System.out.println(e);
		}

		System.out.println(_movieService.getMoviesList());
//
//		Movie m2 = new Movie();
//		m2.setMovieId(3);
//		m2.setDuration(50);
//		m2.setCoverPhotoUrl("Cover-photo-url");
//		m2.setTrailerUrl("trailer - rel");
//		m2.setMovieName("Elon musk");
//		m2.setReleaseDate(LocalDateTime.of(2022, 2,12,12,12));
//		m2.setMovieDescription("This is elon");
//		movieDao.save(m2);
//
//
//
//		List<Movie> ans = movieDao.findByDurationLessThan(200);
//        ans.forEach((e) -> System.out.println(e));

		//movieDao.delete(m11);


		UserService _userService = ctx.getBean(UserService.class);

		User u1 = new User();
		u1.setLastName("kumar");
		u1.setUsername("sigmarek");
		u1.setFirstName("Tapan");
		u1.setUserId(1);
		u1.setDateOfBirth(LocalDateTime.of(2022,03, 22, 12, 12));
        u1.setPassword("hello");


		User u2 = new User();
		u2.setLastName("kumar");
		u2.setUsername("sigmarek22");
		u2.setFirstName("Vijay");
		u2.setUserId(2);
		u2.setDateOfBirth(LocalDateTime.of(2022,03, 22, 12, 12));
		u2.setPassword("hello");
		try {
			_userService.saveUserDetails(u1);
		} catch (Exception e) {
			System.out.println(e);
		}


		try {
			_userService.saveUserDetails(u2);
		} catch (Exception e) {
			System.out.println(e);
		}

		User u3 = new User();
		u3.setLastName("kumar");
		u3.setUsername("sigmarek21");
		u3.setFirstName("Keshav");
		u3.setUserId(3);
		u3.setDateOfBirth(LocalDateTime.of(2022,03, 22, 12, 12));
		u3.setPassword("hello");
		System.out.println("Hello Spring!");

		try{
			User u = _userService.updateUserDetails(1,u3);
			System.out.println(u);
		} catch(Exception e) {
			System.out.println(e);
		}
	}
	@Bean
	CommandLineRunner init(initService initService) {
		return args -> {
			initService.init();
		};
	}

}
