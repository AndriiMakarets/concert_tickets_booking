package com.example.ticketservice.mappers;

import com.example.ticketservice.dto.BookingDTO;
import com.example.ticketservice.models.Booking;

import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface BookingMapper {
    Booking toBooking(BookingDTO bookingDTO);
    BookingDTO toDTO(Booking booking);
    List<BookingDTO> listToDTO(List<Booking> bookings);
}
