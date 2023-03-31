package com.tapan.movieBookingSystem.Entities;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Set;

@Entity
@Data
public class City {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int cityId;

    @Column(nullable = false, length = 50)
    private String cityName;


    @OneToMany(mappedBy = "city", fetch = FetchType.EAGER)

    Set<Theatre> theaters;

    public City(String cityName) {
        this.cityName = cityName;
    }

    public City(int cityId, String cityName) {
        this.cityId = cityId;
        this.cityName = cityName;
    }

}
