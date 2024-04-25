package com.example.ticketservice.dto;

import com.example.ticketservice.models.Booking.BookingStatus;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

public class BookingDTO {

    private Long id;
    private List<Long> ticketIds;
    private int quantity;
    private BigDecimal totalPrice;
//    private BookingStatus status;
    private List<Long> seatsId;
    private Date bookingDate;
    private Date createdAt;
    private Date updatedAt;

    // Constructors
    public BookingDTO() {
    }

    public BookingDTO(Long id, Date updatedAt, Date createdAt, List<Long> seatsId, BigDecimal totalPrice, int quantity, List<Long> ticketIds, Date bookingDate) {
        this.id = id;
        this.updatedAt = updatedAt;
        this.createdAt = createdAt;
        this.seatsId = seatsId;
        this.totalPrice = totalPrice;
        this.quantity = quantity;
        this.ticketIds = ticketIds;
        this.bookingDate = bookingDate;
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

   // public List<Long> getTicketIds() {
   //     return ticketIds;
   // }

    // public void setTicketIds(List<Long> ticketIds) {
   //     this.ticketIds = ticketIds;
   // }

    public List<Long> getTicketIds() {
        return ticketIds;
    }

    public void setTicketIds(List<Long> ticketIds) {
        this.ticketIds = ticketIds;
    }

    public List<Long> getSeatsId() {
        return seatsId;
    }

    public void setSeatsId(List<Long> seatsId) {
        this.seatsId = seatsId;
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

//    public BookingStatus getStatus() {
//        return status;
//    }
//
//    public void setStatus(BookingStatus status) {
//        this.status = status;
//    }

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
