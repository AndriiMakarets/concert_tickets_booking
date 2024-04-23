package com.example.concertservice.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import com.example.concertservice.dto.VenueTypeDTO;
import com.example.concertservice.exceptions.ResourceNotFoundException;
import com.example.concertservice.models.VenueType;
import com.example.concertservice.repositories.VenueTypeRepository;
import com.example.concertservice.mappers.VenueTypeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
@RequiredArgsConstructor
@Service
public class VenueTypeService {

    private final VenueTypeRepository venueTypeRepository;
    private final VenueTypeMapper venueTypeMapper;


    public VenueType createVenueType(VenueType venueType) {
        return venueTypeRepository.save(venueType);
    }

    public List<VenueType> getAllVenueTypes() {
        List<VenueType> venueTypes = venueTypeRepository.findAll();
        return venueTypes;
    }

    public Optional<VenueType> getVenueTypeById(Long id) {
        return venueTypeRepository.findById(id);
    }

    public VenueType updateVenueType(Long id, VenueType venueType) {
        VenueType existingVenueType = venueTypeRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Venue type not found with id: " + id));
        venueType.setId(id);
        // Update properties of existingVenueType with values from venueTypeDTO

        VenueType updatedVenueType = venueTypeRepository.save(venueType);
        return updatedVenueType;
    }

    public void deleteVenueType(Long id) {
        VenueType venueType = venueTypeRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Venue type not found with id: " + id));
        venueTypeRepository.delete(venueType);
    }
}
