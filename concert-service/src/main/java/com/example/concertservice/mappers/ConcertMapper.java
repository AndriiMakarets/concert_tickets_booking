package com.example.concertservice.mappers;

import com.example.concertservice.dto.ConcertDTO;
import com.example.concertservice.models.Concert;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface ConcertMapper {
    Concert toConcert(ConcertDTO concertDTO);
    ConcertDTO toDTO(Concert concert);
    List<ConcertDTO> listToDTO (List<Concert> concerts);
}
