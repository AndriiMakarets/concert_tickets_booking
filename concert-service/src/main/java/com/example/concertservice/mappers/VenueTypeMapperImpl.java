package com.example.concertservice.mappers;

import com.example.concertservice.dto.VenueTypeDTO;
import com.example.concertservice.models.VenueType;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import java.util.List;

@Component
@RequiredArgsConstructor
public class VenueTypeMapperImpl implements VenueTypeMapper{
    @Override
    public VenueType toVenueType(VenueTypeDTO venueTypeDTO) {
        return VenueType
                .builder()
                .name(venueTypeDTO.getName())
                .description(venueTypeDTO.getDescription())
                .build();
    }

    @Override
    public VenueTypeDTO toDTO(VenueType venueType) {
        return null;
    }

    @Override
    public List<VenueTypeDTO> listToDTO(List<VenueType> venueTypes) {
        return null;
    }
}
