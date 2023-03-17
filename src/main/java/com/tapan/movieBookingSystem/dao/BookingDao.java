package com.tapan.movieBookingSystem.dao;

import com.tapan.movieBookingSystem.Entities.Booking;
import org.springframework.data.jpa.repository.JpaRepository;

import java.awt.print.Book;
import java.time.LocalDateTime;
import java.util.List;

public interface BookingDao extends JpaRepository<Booking ,Integer> {
    public List<Booking> findByBookingDateLessThan(LocalDateTime date);

    public List<Booking> findByBookingDateGreaterThan(LocalDateTime date);

    public List<Booking> findByNoOfSeatsGreaterThan(int bookingSeats);
}
