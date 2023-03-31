package com.tapan.movieBookingSystem.Entities;

import jakarta.persistence.*;
import lombok.Data;
import org.springframework.cglib.core.Local;

import java.time.LocalDateTime;
import java.util.Set;

@Entity
@Table(name = "Customer")
@Data
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int userId;

    private String firstName;

    private String lastName;

    private String username;

    private String password;

    private LocalDateTime dateOfBirth;

    @ElementCollection
    @CollectionTable(name  = "user_contact_number",
     joinColumns = @JoinColumn(name = "user_id")
    )
    @Column(name = "mobile_number", nullable = false)
    private Set<Integer> phoneNumbers;

}
