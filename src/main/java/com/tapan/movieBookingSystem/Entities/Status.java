package com.tapan.movieBookingSystem.Entities;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Status {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int statusId;

    @Column(nullable = false, length = 100, unique = true)
    private String statusName;

}
