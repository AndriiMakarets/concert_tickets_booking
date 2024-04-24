package com.example.ticketservice.mappers;

import com.example.ticketservice.dto.BookingDTO;
import com.example.ticketservice.models.Booking;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring")
public interface BookingMapper {

    @Mappings({
            @Mapping(target = "ticketIds", source = "tickets"),
            @Mapping(target = "quantity", source = "quantity"),
            @Mapping(target = "totalPrice", source = "totalPrice"),
            @Mapping(target = "status", source = "status"),
            @Mapping(target = "bookingDate", source = "bookingDate"),
            @Mapping(target = "createdAt", source = "createdAt"),
            @Mapping(target = "updatedAt", source = "updatedAt")
    })
    BookingDTO toDTO(Booking booking);

    List<BookingDTO> listToDTO(List<Booking> bookings);

    @Mappings({
            @Mapping(target = "tickets", source = "ticketIds"),
            @Mapping(target = "quantity", source = "quantity"),
            @Mapping(target = "totalPrice", source = "totalPrice"),
            @Mapping(target = "status", source = "status"),
            @Mapping(target = "bookingDate", source = "bookingDate"),
            @Mapping(target = "createdAt", source = "createdAt"),
            @Mapping(target = "updatedAt", source = "updatedAt")
    })
    Booking toEntity(BookingDTO bookingDTO);
}
