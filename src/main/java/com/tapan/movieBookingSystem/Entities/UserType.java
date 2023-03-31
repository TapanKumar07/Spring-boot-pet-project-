package com.tapan.movieBookingSystem.Entities;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class UserType {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int userTypeId;

    @Column(length = 20, unique = true)
    private String userTypeName = "Customer";

    public UserType(String userTypeName) {
        this.userTypeName = userTypeName;
    }
}
