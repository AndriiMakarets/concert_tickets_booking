package com.example.ticketservice.dto;

import jakarta.persistence.Column;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.Date;
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class TicketDTO {

    private Long seat_id;

    private Long eventId;

    private String category; // e.g., General Admission, VIP, etc.

    private BigDecimal price;

    private String seatNumber;

}
