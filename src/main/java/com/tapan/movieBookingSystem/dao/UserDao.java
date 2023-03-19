package com.tapan.movieBookingSystem.dao;

import com.tapan.movieBookingSystem.Entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.List;

public interface UserDao extends JpaRepository<User,Integer> {
    public List<User> findByFirstName(String firstName);

    public List<User> findByLastName(String lastName);

    public List<User> findByDateOfBirth(LocalDateTime date);

    public User findByUsername(String username);
}
