package com.example.ticketservice.mappers;

import com.example.ticketservice.dto.BookingDTO;
import com.example.ticketservice.exceptions.ResourceNotFoundException;
import com.example.ticketservice.models.Booking;
import com.example.ticketservice.models.Ticket;
import com.example.ticketservice.services.TicketService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
@RequiredArgsConstructor
@Component
public class BookingMapperImpl implements  BookingMapper{
    private final TicketService ticketService;
    @Override
    public Booking toBooking(BookingDTO bookingDTO) {
       // List<Long> sitsId = new ArrayList<>();
         // bookingDTO.getSeatsId().forEach(id -> sitsId.add(
               //  ticketService .getById(id)
                 //       .orElseThrow(()-> new ResourceNotFoundException("Ticket does not exist with id: " + id))));
        return Booking
                .builder()
                .seatsId(bookingDTO.getSeatsId())
                .bookingDate(bookingDTO.getBookingDate())
               // .tickets(tickets)
                .quantity(bookingDTO.getQuantity())
                .status(Booking.BookingStatus.RESERVED)
                .totalPrice(bookingDTO.getTotalPrice())
                .build();
    }

    @Override
    public BookingDTO toDTO(Booking booking) {
        return null;
    }

    @Override
    public List<BookingDTO> listToDTO(List<Booking> bookings) {
        return null;
    }
}
