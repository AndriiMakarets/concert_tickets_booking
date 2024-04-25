package com.example.ticketservice.controllers;


import com.example.ticketservice.dto.BookingDTO;
import com.example.ticketservice.models.Booking;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

import com.example.ticketservice.exceptions.ResourceNotFoundException;
import com.example.ticketservice.mappers.BookingMapper;
import com.example.ticketservice.services.BookingService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;


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

    //External user can create only booking with status "CREATED"
    @PostMapping()
    public ResponseEntity<Booking> createBooking(@RequestBody BookingDTO bookingDTO) {
        Booking booking = bookingMapper.toBooking(bookingDTO);
        Booking createdBooking = bookingService.createBooking(booking);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdBooking);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Booking> updateBooking(@PathVariable Long id, @RequestBody BookingDTO bookingDTO) {
        Booking booking = bookingMapper.toBooking(bookingDTO);
        booking.setId(id);
        Booking updatedBooking = bookingService.updateBooking(booking);
        return ResponseEntity.ok().body(updatedBooking);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteBooking(@PathVariable Long id) {
        bookingService.deleteBooking(id);
        return ResponseEntity.ok().body("Booking deleted successfully");
    }

}

