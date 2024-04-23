package com.example.concertservice.mappers;

import com.example.concertservice.dto.VenueDTO;
import com.example.concertservice.models.Venue;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface VenueMapper {
    Venue toVenue(VenueDTO venueDTO);
    VenueDTO toDTO(Venue venue);
    List<VenueDTO> listToDTO(List<Venue> venues);

}
