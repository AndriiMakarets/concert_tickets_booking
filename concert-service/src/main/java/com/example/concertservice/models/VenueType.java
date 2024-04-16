package com.example.concertservice.models;

import jakarta.persistence.*;

@Entity
@Table(name = "venue_types")
public class VenueType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String name;

    @Column(length = 500)
    private String description;

}