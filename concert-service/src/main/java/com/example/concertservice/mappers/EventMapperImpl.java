package com.example.concertservice.mappers;

import com.example.concertservice.dto.EventCreationDTO;
import com.example.concertservice.dto.EventDTO;
import com.example.concertservice.exceptions.ResourceNotFoundException;
import com.example.concertservice.models.Event;
import com.example.concertservice.models.EventTypes;
import com.example.concertservice.models.Seat;
import com.example.concertservice.models.Venue;
import com.example.concertservice.services.EventTypeService;
import com.example.concertservice.services.SeatService;
import com.example.concertservice.services.VenueService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

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
        List<Seat> seats = seatService.createSeats(eventDTO.getSeatsAmount());
        Venue venue = venueService
                .getVenueById(eventDTO.getVenueID())
                .orElseThrow(()-> new ResourceNotFoundException("venue does not exist"));;
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
    public EventDTO toDTO(Event event) {
        return null;
    }

    @Override
    public List<EventDTO> listToDTO(List<Event> events) {
        return null;
    }


}
