package com.example.concertservice.controllers;

import com.example.concertservice.dto.VenueDTO;
import com.example.concertservice.exceptions.ResourceNotFoundException;
import com.example.concertservice.mappers.VenueMapper;
import com.example.concertservice.models.Venue;
import com.example.concertservice.services.VenueService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/ticket-booking/venues")
public class VenueController {

    private final VenueService venueService;
    private final VenueMapper venueMapper;

    @PostMapping
    public ResponseEntity<Venue> createVenue(@RequestBody VenueDTO venueDTO) {

        Venue venue = venueMapper.toVenue(venueDTO);
        Venue savedVenue =  venueService.createVenue(venue);
        return new ResponseEntity<>(savedVenue, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Venue>> getAllVenues() {
        List<Venue> venues= venueService.getAllVenues();
        return new ResponseEntity<>(venues, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Venue> getVenueById(@PathVariable("id") Long id) {
        Venue venue = venueService.getVenueById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Venue not found with id: " + id));
        return ResponseEntity.ok(venue);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Venue> updateVenue(@PathVariable("id") Long id, @RequestBody VenueDTO venueDTO) {
        Venue venue = venueMapper.toVenue(venueDTO);
        Venue updatedVenue = venueService.updateVenue(id, venue);
        return ResponseEntity.ok(updatedVenue);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteVenue(@PathVariable("id") Long id) {
        venueService.deleteVenue(id);
        return ResponseEntity.ok().body("Venue deleted successfully");
    }
}
