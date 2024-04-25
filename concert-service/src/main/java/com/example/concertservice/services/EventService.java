package com.example.concertservice.services;

import com.example.concertservice.exceptions.ResourceNotFoundException;
import com.example.concertservice.models.Event;
import com.example.concertservice.models.Seat;
import com.example.concertservice.repositories.EventRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class EventService {
private final EventRepository eventRepository;
    public List<Event> getAll(Specification<Event> spec, PageRequest pageRequest) {
        return eventRepository.findAll(spec, pageRequest).getContent().stream().toList();
    }

    public Optional<Event> getById(Long id) {
        return eventRepository.findById(id);
    }

    public Event updateEvent(Long id, Event newEvent) {
        newEvent.setId(id);
        return eventRepository.save(newEvent);
    }

    public Event createEvent(Event event) {
        return eventRepository.save(event);
    }

    public void deleteById(Long id) {
        Event existingEvent = getById(id).orElseThrow(() -> new ResourceNotFoundException("Seat doesn't exist"));
        eventRepository.deleteById(id);
    }


    public void updateSeatsWithActualEvent(Event event) {
        event.getSeats().forEach(seat -> seat.setEvent(event));
        eventRepository.save(event);
    }
}
