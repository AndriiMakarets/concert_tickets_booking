package com.example.concertservice.mappers;

import com.example.concertservice.dto.EventDTO;
import com.example.concertservice.models.Event;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class EventMapperImpl implements EventMapper {
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
}
