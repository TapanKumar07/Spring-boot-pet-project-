package com.tapan.movieBookingSystem.Entities;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Language {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int languageId;

    @Column(length = 50, nullable = false, unique = true)
    private String languageName;

}
