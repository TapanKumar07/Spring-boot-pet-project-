package com.tapan.movieBookingSystem.services.Implementations;

import com.tapan.movieBookingSystem.Entities.City;
import com.tapan.movieBookingSystem.dao.CityDao;
import com.tapan.movieBookingSystem.dao.MovieDao;
import com.tapan.movieBookingSystem.dao.UserDao;
import com.tapan.movieBookingSystem.services.initService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class initServiceImpl implements initService {

    @Autowired
    private MovieDao _moviedao;

    @Autowired
    private CityDao _citydao;

    @Autowired
    private UserDao _userdao;
    @Override
    public void init() {
        /**
         * Add Cities
         */

        List<City> cities = new ArrayList<>();
        cities.add(new City("Delhi"));
        cities.add(new City("Mumbai"));
        cities.add(new City("Chennai"));
        cities.add(new City("Kolkata"));

        cities.forEach((city) -> _citydao.save(city));



    }
}
