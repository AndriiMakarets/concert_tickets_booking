package com.example.ticketservice.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

    import jakarta.persistence.*;
    import java.math.BigDecimal;
    import java.util.Date;

    @Entity
    @Table(name = "tickets")
    public class Ticket {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        @ManyToOne(fetch = FetchType.LAZY)
        @JoinColumn(name = "seat_id")
        private Long seat;

        @ManyToOne(fetch = FetchType.LAZY)
        @JoinColumn(name = "event_id", nullable = false)
        private Event event;

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

        public Ticket() {
        }

        public Ticket(Long id, Event event, String category, BigDecimal price, String seatNumber, int quantityAvailable,
                      int quantitySold, Date saleStartDate, Date saleEndDate, Date createdAt, Date updatedAt) {
            this.id = id;
            this.event = event;
            this.category = category;
            this.price = price;
            this.seatNumber = seatNumber;
            this.quantityAvailable = quantityAvailable;
            this.quantitySold = quantitySold;
            this.saleStartDate = saleStartDate;
            this.saleEndDate = saleEndDate;
            this.createdAt = createdAt;
            this.updatedAt = updatedAt;
        }

        public Long getId() {
            return id;
        }

        public void setId(Long id) {
            this.id = id;
        }

        public Event getEvent() {
            return event;
        }

        public void setEvent(Event event) {
            this.event = event;
        }

        public String getCategory() {
            return category;
        }

        public void setCategory(String category) {
            this.category = category;
        }

        public BigDecimal getPrice() {
            return price;
        }

        public void setPrice(BigDecimal price) {
            this.price = price;
        }

        public String getSeatNumber() {
            return seatNumber;
        }

        public void setSeatNumber(String seatNumber) {
            this.seatNumber = seatNumber;
        }

        public int getQuantityAvailable() {
            return quantityAvailable;
        }

        public void setQuantityAvailable(int quantityAvailable) {
            this.quantityAvailable = quantityAvailable;
        }

        public int getQuantitySold() {
            return quantitySold;
        }

        public void setQuantitySold(int quantitySold) {
            this.quantitySold = quantitySold;
        }

        public Date getSaleStartDate() {
            return saleStartDate;
        }

        public void setSaleStartDate(Date saleStartDate) {
            this.saleStartDate = saleStartDate;
        }

        public Date getSaleEndDate() {
            return saleEndDate;
        }

        public void setSaleEndDate(Date saleEndDate) {
            this.saleEndDate = saleEndDate;
        }

        public Date getCreatedAt() {
            return createdAt;
        }

        public void setCreatedAt(Date createdAt) {
            this.createdAt = createdAt;
        }

        public Date getUpdatedAt() {
            return updatedAt;
        }

        public void setUpdatedAt(Date updatedAt) {
            this.updatedAt = updatedAt;
        }
    }
}
