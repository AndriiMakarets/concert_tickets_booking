package com.example.concertservice.controllers;

import com.example.concertservice.exceptions.ResourceNotFoundException;
import com.example.concertservice.models.EventTypes;
import com.example.concertservice.services.EventTypeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import lombok.RequiredArgsConstructor;
import java.util.List;

@RestController
@RequestMapping("/api/v1/ticket-booking/event-types")
@RequiredArgsConstructor
public class EventTypesController {

    private final EventTypeService eventTypeService;

    @PostMapping
    public ResponseEntity<EventTypes> createEventType(@RequestBody EventTypes eventType) {
        EventTypes createdEventType = eventTypeService.createEventType(eventType);
        return new ResponseEntity<>(createdEventType, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<EventTypes>> getAllEventTypes() {
        List<EventTypes> eventTypes = eventTypeService.getAllEventTypes();
        return new ResponseEntity<>(eventTypes, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<EventTypes> getEventTypeById(@PathVariable("id") Long id) {
        EventTypes eventType = eventTypeService.getEventTypeById(id).orElseThrow(() -> new ResourceNotFoundException("Event type doesn't exist"));;
        return new ResponseEntity<>(eventType, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<EventTypes> updateEventType(@PathVariable("id") Long id, @RequestBody EventTypes eventType) {
        EventTypes existingEventType = eventTypeService.getEventTypeById(id).orElseThrow(() -> new ResourceNotFoundException("Event type doesn't exist"));;

        EventTypes updatedEventType = eventTypeService.updateEventType(id, eventType);
        return ResponseEntity.ok(updatedEventType);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteEventType(@PathVariable("id") Long id) {
        eventTypeService.deleteEventTypeById(id).orElseThrow(() -> new ResourceNotFoundException("Event type doesn't exist"));
        return ResponseEntity.ok().body("object deleted: " + id);
    }
}
