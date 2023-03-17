package com.tapan.movieBookingSystem.dao;

import com.tapan.movieBookingSystem.Entities.City;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CityDao extends JpaRepository<City,Integer> {

    public List<City> findByCityName(String city);

}
