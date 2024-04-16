package com.example.ticketservice.models;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table(name = "bookings")
public class Booking {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    //@ManyToOne(fetch = FetchType.LAZY)
    //@JoinColumn(name = "user_id", nullable = false)
    //private User user;

    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "ticket_id", nullable = false)
    private List<Ticket> tickets;

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

    public Booking() {
    }

    public Booking(Long id, User user, Ticket ticket, int quantity, BigDecimal totalPrice, BookingStatus status,
                   Date bookingDate, Date createdAt, Date updatedAt) {
        this.id = id;
        this.user = user;
        this.ticket = ticket;
        this.quantity = quantity;
        this.totalPrice = totalPrice;
        this.status = status;
        this.bookingDate = bookingDate;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Ticket getTicket() {
        return ticket;
    }

    public void setTicket(Ticket ticket) {
        this.ticket = ticket;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public BigDecimal getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(BigDecimal totalPrice) {
        this.totalPrice = totalPrice;
    }

    public BookingStatus getStatus() {
        return status;
    }

    public void setStatus(BookingStatus status) {
        this.status = status;
    }

    public Date getBookingDate() {
        return bookingDate;
    }

    public void setBookingDate(Date bookingDate) {
        this.bookingDate = bookingDate;
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