package com.example.ticketservice.controllers;


import com.example.ticketservice.dto.BookingDTO;
import com.example.ticketservice.models.Booking;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;


import com.example.ticketservice.dto.BookingDTO;
import com.example.ticketservice.exceptions.ResourceNotFoundException;
import com.example.ticketservice.mappers.BookingMapper;
import com.example.ticketservice.models.Booking;
import com.example.ticketservice.services.BookingService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController("api/v1/ticket-booking/bookings")
@RequiredArgsConstructor
public class BookingController {

    private final BookingService bookingService;
    private final BookingMapper bookingMapper;

    @GetMapping()
    public ResponseEntity<List<BookingDTO>> getAllBookings() {
        List<Booking> bookings = bookingService.getAllBookings();
        List<BookingDTO> bookingDTOs = bookingMapper.listToDTO(bookings);
        return ResponseEntity.ok().body(bookingDTOs);
    }


    @GetMapping("/{id}")
    public ResponseEntity<BookingDTO> getBookingById(@PathVariable Long id) {
        Booking booking = bookingService.getBookingById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Booking not found with id: " + id));
        BookingDTO bookingDTO = bookingMapper.toDTO(booking);
        return ResponseEntity.ok().body(bookingDTO);
    }

    @PostMapping()
    public ResponseEntity<BookingDTO> createBooking(@RequestBody BookingDTO bookingDTO) {
        Booking booking = bookingMapper.toEntity(bookingDTO);
        Booking createdBooking = bookingService.createBooking(booking);
        BookingDTO createdBookingDTO = bookingMapper.toDTO(createdBooking);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdBookingDTO);
    }

    @PutMapping("/{id}")
    public ResponseEntity<BookingDTO> updateBooking(@PathVariable Long id, @RequestBody BookingDTO bookingDTO) {
        Booking booking = bookingMapper.toEntity(bookingDTO);
        booking.setId(id);
        Booking updatedBooking = bookingService.updateBooking(booking);
        BookingDTO updatedBookingDTO = bookingMapper.toDTO(updatedBooking);
        return ResponseEntity.ok().body(updatedBookingDTO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteBooking(@PathVariable Long id) {
        bookingService.deleteBooking(id);
        return ResponseEntity.ok().body("Booking deleted successfully");
    }

}

