package com.example.concertservice.mappers;

import com.example.concertservice.dto.EventCreationDTO;
import com.example.concertservice.dto.EventDTO;
import com.example.concertservice.models.Event;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface EventMapper {
    Event toEvent(EventDTO eventDTO);
    EventDTO toDTO(Event event);
    List<EventDTO> listToDTO(List<Event> events);

}
