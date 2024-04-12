package com.example.concertservice.mappers;

import com.example.concertservice.dto.ConcertDTO;
import com.example.concertservice.models.Concert;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ConcertMapperImpl implements ConcertMapper {
    @Override
    public Concert toConcert(ConcertDTO concertDTO) {
        return null;
    }

    @Override
    public ConcertDTO toDTO(Concert concert) {
        return null;
    }

    @Override
    public List<ConcertDTO> listToDTO(List<Concert> concerts) {
        return null;
    }
}
