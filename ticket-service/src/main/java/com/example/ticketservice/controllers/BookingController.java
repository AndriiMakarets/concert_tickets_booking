package com.example.ticketservice.controllers;

import com.example.ticketservice.dto.BookTicketsDTO;
import com.example.ticketservice.models.Ticket;
import com.example.ticketservice.services.TicketService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController("api/v1/ticket-booking/bookings")
@RequiredArgsConstructor
public class BookingController {

    private final TicketService ticketService;

}
