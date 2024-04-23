package com.example.concertservice.mappers;

import com.example.concertservice.dto.VenueDTO;
import com.example.concertservice.exceptions.ResourceNotFoundException;
import com.example.concertservice.models.Venue;
import com.example.concertservice.models.VenueType;
import com.example.concertservice.services.VenueService;
import com.example.concertservice.services.VenueTypeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

@Component
@RequiredArgsConstructor
public class VenueMapperImpl implements VenueMapper{
    private final VenueTypeService venueTypeService;
    @Override
    public Venue toVenue(VenueDTO venueDTO) {
        VenueType venueType = venueTypeService.getVenueTypeById(venueDTO.getVenueTypeID())
                .orElseThrow(()-> new ResourceNotFoundException("Venue type does not exist"));
        return Venue
                .builder()
                .address(venueDTO.getAddress())
                .name(venueDTO.getName())
                .capacity(venueDTO.getCapacity())
                .description(venueDTO.getDescription())
                .venueType(venueType)
                .build();
    }

    @Override
    public VenueDTO toDTO(Venue venue) {
        return null;
    }

    @Override
    public List<VenueDTO> listToDTO(List<Venue> venues) {
        return null;
    }
}
