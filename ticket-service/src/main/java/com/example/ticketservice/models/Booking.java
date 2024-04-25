package com.example.ticketservice.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.lang.reflect.Array;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "bookings")
public class Booking {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    //@ManyToOne(fetch = FetchType.LAZY)
    //@JoinColumn(name = "user_id", nullable = false)
    //private User user;

    @Column(name = "ticket_id", nullable = false)
    private int userEmail;

    //@OneToMany(fetch = FetchType.LAZY)
    //@JoinColumn(name = "ticket_id", nullable = false)
    //private List<Ticket> tickets;

    @ElementCollection
    private List<Long> seatsId;

    @Column(nullable = false)
    private int quantity; // Number of tickets booked

    @Column(nullable = false)
    private BigDecimal totalPrice; // Total price for the booked tickets

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private BookingStatus status; // e.g., RESERVED, PAID, CANCELED

    @Column(name = "booking_date", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date bookingDate;

    @Column(name = "created_at", nullable = false, updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt;

    @Column(name = "updated_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date updatedAt;

    public enum BookingStatus {
        RESERVED,
        PAID,
        CANCELED
    }

    @PrePersist
    protected void onCreate() {
        createdAt = new Date();
        bookingDate = new Date(); // Assuming booking date is set to the current date when created
    }

    @PreUpdate
    protected void onUpdate() {
        updatedAt = new Date();
    }


}