package com.example.concertservice.services;

import com.example.concertservice.dto.VenueDTO;
import com.example.concertservice.exceptions.ResourceNotFoundException;
import com.example.concertservice.models.Venue;
import com.example.concertservice.repositories.VenueRepository;
import com.example.concertservice.mappers.VenueMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
@RequiredArgsConstructor
@Service
public class VenueService {

    private final VenueRepository venueRepository;
    private final VenueMapper venueMapper;



    public Venue createVenue(Venue venue) {
        return venueRepository.save(venue);
    }

    public List<Venue> getAllVenues() {
        List<Venue> venues = venueRepository.findAll();
        return venues;
    }

    public Optional<Venue> getVenueById(Long id) {
        return venueRepository.findById(id);
    }

    public Venue updateVenue(Long id, Venue venue) {
        Venue existingVenue = venueRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Venue not found with id: " + id));
        venue.setId(id);
        Venue updatedVenue = venueRepository.save(venue);
        return updatedVenue;
    }

    public void deleteVenue(Long id) {
        Venue venue = venueRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Venue not found with id: " + id));
        venueRepository.delete(venue);
    }
}
