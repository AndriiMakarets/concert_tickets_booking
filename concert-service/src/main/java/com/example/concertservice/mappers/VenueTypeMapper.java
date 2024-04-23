package com.example.concertservice.mappers;

import com.example.concertservice.dto.VenueTypeDTO;
import com.example.concertservice.models.VenueType;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface VenueTypeMapper {
    VenueType toVenueType(VenueTypeDTO venueTypeDTO);
    VenueTypeDTO toDTO(VenueType venueType);
    List<VenueTypeDTO> listToDTO(List<VenueType> venueTypes);
}
