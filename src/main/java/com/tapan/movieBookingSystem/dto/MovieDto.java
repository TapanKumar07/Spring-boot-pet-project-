package com.tapan.movieBookingSystem.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class MovieDto {
   public int movieId;
   public String movieName;
   private String movieDescription;
   private LocalDateTime releaseDate;
   private int duration;
   private String coverPhotoUrl;
   private String trailerUrl;

}
