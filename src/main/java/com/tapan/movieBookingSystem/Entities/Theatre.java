package com.tapan.movieBookingSystem.Entities;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Theatre {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int theatreId;

    @Column(length = 100, nullable = false, unique = true)
    private String theatreName;

    @Column(nullable = false)
    private float ticketPrice = 150.00f;


    @ManyToOne
    private City city;

    @ManyToMany(mappedBy = "theaters")
    private List<Movie> movies;
    public int getTheatreId() {
        return theatreId;
    }

    public void setTheatreId(int theatreId) {
        this.theatreId = theatreId;
    }

    public String getTheatreName() {
        return theatreName;
    }

    public void setTheatreName(String theatreName) {
        this.theatreName = theatreName;
    }

    public float getTicketPrice() {
        return ticketPrice;
    }

    public void setTicketPrice(float ticketPrice) {
        this.ticketPrice = ticketPrice;
    }

    @Override
    public String toString() {
        return "Theatre{" +
                "theatreId=" + theatreId +
                ", theatreName='" + theatreName + '\'' +
                ", ticketPrice=" + ticketPrice +
                '}';
    }
}
