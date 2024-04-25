package com.example.concertservice.mappers;

import com.example.concertservice.dto.EventCreationDTO;
import com.example.concertservice.dto.EventDTO;
import com.example.concertservice.dto.EventResponseDTO;
import com.example.concertservice.exceptions.*;

import com.example.concertservice.models.*;

import com.example.concertservice.services.EventTypeService;
import com.example.concertservice.services.SeatService;
import com.example.concertservice.services.VenueService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@RequiredArgsConstructor
public class EventMapperImpl implements EventMapper {

    private final EventTypeService eventTypeService;
    private final SeatService seatService;
    private final VenueService venueService;

    @Override
    public Event toEvent(EventDTO eventDTO) {

       EventTypes eventType = eventTypeService
                .getEventTypeById(eventDTO.getEventTypeID())
                .orElseThrow(()-> new ResourceNotFoundException("event type does not exist"));
            Venue venue = venueService
                    .getVenueById(eventDTO.getVenueID())
                    .orElseThrow(()-> new ResourceNotFoundException("venue does not exist"));
        List<Seat> seats = seatService.createSeats(eventDTO.getSeatsAmount(), eventDTO.getRows(), eventDTO.getColumns());

        return Event
                .builder()
                .eventDate(eventDTO.getEventDate())
                .description(eventDTO.getDescription())
                .name(eventDTO.getName())
                .saleEndDate(eventDTO.getSaleEndDate())
                .saleStartDate(eventDTO.getSaleStartDate())
                .seats(seats)
                .venue(venue)
                .eventType(eventType)
                .build();
    }

    @Override
    public EventResponseDTO toDTO(Event event) {
        return EventResponseDTO
                .builder()
                .id(event.getId())
                .eventTypeID(event.getEventType().getId())
                .seatsAmount(event.getVenue().getCapacity())
                .venueID(event.getVenue().getId())
                .eventDate(event.getEventDate())
                .description(event.getDescription())
                .name(event.getName())
                .saleEndDate(event.getSaleEndDate())
                .saleStartDate(event.getSaleStartDate())
                .build();
    }

    @Override
    public List<EventResponseDTO> listToDTO(List<Event> events) {
        List<EventResponseDTO> responseDTOS = new ArrayList<>();
        events.forEach(event -> responseDTOS.add(toDTO(event)));
        return responseDTOS;
    }


}
