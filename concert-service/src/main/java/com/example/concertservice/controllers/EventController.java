package com.example.concertservice.controllers;

import com.example.concertservice.dto.EventCreationDTO;
import com.example.concertservice.dto.EventDTO;
import com.example.concertservice.exceptions.ResourceNotFoundException;
import com.example.concertservice.mappers.EventMapper;
import com.example.concertservice.models.Event;
import com.example.concertservice.models.Seat;
import com.example.concertservice.services.EventService;
import com.example.concertservice.services.SeatService;
import com.example.concertservice.specifications.EventSpecifications;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("api/v1/ticket-booking/events")
@RequiredArgsConstructor
public class EventController {
    private final EventService eventService;
    private final SeatService seatService;
    private final EventMapper eventMapper;

    @GetMapping()
    public ResponseEntity<List<Event>> getEvents(
            @RequestParam(required = false, defaultValue = "0") int page,
            @RequestParam(required = false, defaultValue = "10") int size,
            @RequestParam(required = false) String city,
            @RequestParam(required = false) Long type_id,
            @RequestParam(required = false) @DateTimeFormat(pattern = "yyyy-MM-dd") Date from,
            @RequestParam(required = false) @DateTimeFormat(pattern = "yyyy-MM-dd") Date to
    ) {
        Specification<Event> spec = Specification.where(null);

        if (city != null) {
            spec = spec.and(EventSpecifications.byCity(city));
        }
        if (from != null && to != null) {
            spec = spec.and(EventSpecifications.byDateRange(from, to));
        }
        if (type_id != null) {
            spec = spec.and(EventSpecifications.byType(type_id));
        }

        List<Event> events = eventService.getAll(spec, PageRequest.of(page, size));
//        List<EventDTO> eventsDTO = eventMapper.listToDTO(events);
        return ResponseEntity.ok().body(events);
    }

    @Transactional
    @PutMapping("/{id}")
    public ResponseEntity<Event> updateEvent(@RequestBody EventDTO eventDTO, @PathVariable Long id) {

        Event eventToUpdate = eventMapper.toEvent(eventDTO);
        Event existingEvent = eventService.getById(id).orElseThrow(() -> new ResourceNotFoundException("Event doesn't exist"));
        Event updatedEvent = eventService.updateEvent(id, eventToUpdate);
        return ResponseEntity.ok(updatedEvent);
//        return ResponseEntity.ok(eventMapper.toDTO(updatedEvent));

    }

    @Transactional
    @PostMapping
    public ResponseEntity<Event> createEvent(@RequestBody EventDTO eventDTO) {
        Event event = eventMapper.toEvent(eventDTO);
        //add venue and any other dependencies. Use grpc call here.
        Event savedEvent = eventService.createEvent(event);
        eventService.updateSeatsWithActualEvent(savedEvent);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedEvent);
    }

    @Transactional
    @GetMapping("/{id}")
    public ResponseEntity<Event> getById(@PathVariable Long id) {
        System.out.println("GET BY ID");
        return ResponseEntity.status(HttpStatus.CREATED).body(eventService.getById(id).orElseThrow(() -> new ResourceNotFoundException("Contact doesn't exist")));
    }

    @Transactional
    @GetMapping("/{id}/free-seats")
    public ResponseEntity<List<Seat>> getFreeSeats(@PathVariable Long id) {
        return ResponseEntity.status(HttpStatus.CREATED).body(eventService.getFreeSeats(id));
    }


    @Transactional //delete all connected entities
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteEvent(@PathVariable Long id) {
        eventService.deleteById(id);
        return ResponseEntity.ok().body("object deleted: " + id);
    }
}
