package com.example.concertservice.mappers;

import com.example.concertservice.dto.EventCreationDTO;
import com.example.concertservice.dto.EventDTO;
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
        return null;
    }

    @Override
    public EventDTO toDTO(Event event) {
        return null;
    }

    @Override
    public List<EventDTO> listToDTO(List<Event> events) {
        return null;
    }

    @Override
    public Event toEvent(EventCreationDTO eventDTO) {
        EventTypes eventType = eventTypeService.getEventTypeByID(eventDTO.getEventTypeID());
        List<Seat> seats = seatService.createSeats(eventDTO.getSeatsAmount());
        Venue venue = venueService.getVenueByID(eventDTO.getVenueID());
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
}
