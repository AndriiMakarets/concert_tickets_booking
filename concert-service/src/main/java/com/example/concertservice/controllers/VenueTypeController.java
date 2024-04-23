package com.example.concertservice.controllers;
import com.example.concertservice.dto.VenueTypeDTO;
import com.example.concertservice.exceptions.ResourceNotFoundException;
import com.example.concertservice.mappers.VenueTypeMapper;
import com.example.concertservice.models.VenueType;
import com.example.concertservice.services.VenueTypeService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/ticket-booking/venue-types")
public class VenueTypeController {

    private final VenueTypeService venueTypeService;
    private final VenueTypeMapper venueTypeMapper;


    @PostMapping
    public ResponseEntity<VenueType> createVenueType(@RequestBody VenueTypeDTO venueTypeDTO) {

        VenueType venueType = venueTypeMapper.toVenueType(venueTypeDTO);
        VenueType newVenue = venueTypeService.createVenueType(venueType);
        return new ResponseEntity<>(newVenue, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<VenueType>> getAllVenueTypes() {
        List<VenueType> venueTypes = venueTypeService.getAllVenueTypes();
        return new ResponseEntity<>(venueTypes, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<VenueType> getVenueTypeById(@PathVariable("id") Long id) {
        VenueType venueType = venueTypeService.getVenueTypeById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Venue type not found with id: " + id));
        return ResponseEntity.ok(venueType);
    }

    @PutMapping("/{id}")
    public ResponseEntity<VenueType> updateVenueType(@PathVariable("id") Long id, @RequestBody VenueType venueType) {
        VenueType updatedVenueType = venueTypeService.updateVenueType(id, venueType);
        return ResponseEntity.ok(updatedVenueType);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteVenueType(@PathVariable("id") Long id) {
        venueTypeService.deleteVenueType(id);
        return ResponseEntity.ok().body("Venue type deleted successfully");
    }
}
