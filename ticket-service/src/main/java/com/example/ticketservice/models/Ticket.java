package com.example.ticketservice.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

    import jakarta.persistence.*;
import org.antlr.v4.runtime.misc.NotNull;
import org.hibernate.annotations.CollectionId;

import java.math.BigDecimal;
    import java.util.Date;

    @Data
    @Entity
    @Table(name = "tickets")
    public class Ticket {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

//        @OneToOne(fetch = FetchType.LAZY)
//        @JoinColumn(name = "seat_id")
        @Column(name = "seat_id", nullable = false)
        private Long seat;

//        @ManyToOne(fetch = FetchType.LAZY)
//        @JoinColumn(name = "event_id", nullable = false)
        @Column(name = "event_id", nullable = false)
        private Long eventId;

        @Column(nullable = false)
        private String category; // e.g., General Admission, VIP, etc.

        @Column(nullable = false)
        private BigDecimal price;

        @Column(name = "seat_number")
        private String seatNumber;

        @Column(nullable = false)
        private int quantityAvailable;

        @Column(nullable = false)
        private int quantitySold;

        @Column(name = "sale_start_date", nullable = false)
        @Temporal(TemporalType.TIMESTAMP)
        private Date saleStartDate;

        @Column(name = "sale_end_date", nullable = false)
        @Temporal(TemporalType.TIMESTAMP)
        private Date saleEndDate;

        @Column(name = "created_at", nullable = false, updatable = false)
        @Temporal(TemporalType.TIMESTAMP)
        private Date createdAt;

        @Column(name = "updated_at")
        @Temporal(TemporalType.TIMESTAMP)
        private Date updatedAt;

        @PrePersist
        protected void onCreate() {
            createdAt = new Date();
        }

        @PreUpdate
        protected void onUpdate() {
            updatedAt = new Date();
        }
}
