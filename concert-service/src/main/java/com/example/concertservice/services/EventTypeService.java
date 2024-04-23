package com.example.concertservice.services;
import com.example.concertservice.exceptions.ResourceNotFoundException;
import com.example.concertservice.models.EventTypes;
import com.example.concertservice.repositories.EventTypeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class EventTypeService {

    private final EventTypeRepository eventTypeRepository;

    public EventTypes createEventType(EventTypes eventType) {
        return eventTypeRepository.save(eventType);
    }

    public List<EventTypes> getAllEventTypes() {
        return eventTypeRepository.findAll();
    }

    public Optional<EventTypes> getEventTypeById(Long id) {
        return eventTypeRepository.findById(id);
    }

    public EventTypes updateEventType(Long id, EventTypes eventType) {
        if (!eventTypeRepository.existsById(id)) {
            throw new ResourceNotFoundException("Event type with id " + id + " does not exist.");
        }
        eventType.setId(id);
        return eventTypeRepository.save(eventType);
    }

    public Optional<EventTypes> deleteEventTypeById(Long id) {
        Optional<EventTypes> eventType = eventTypeRepository.findById(id);
        if (eventType.isPresent()) {
            eventTypeRepository.deleteById(id);
        }
        return eventType;
    }
}

