package com.example.concertservice.mappers;

import com.example.concertservice.dto.SeatDTO;
import com.example.concertservice.exceptions.ResourceNotFoundException;
import com.example.concertservice.models.Event;
import com.example.concertservice.models.Seat;
import com.example.concertservice.services.EventService;
import jakarta.annotation.Resource;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class SeatMapperImpl implements SeatMapper {
    private final EventService eventService;
    @Override
    public Seat toSeat(SeatDTO seatDTO) {
        Event event = eventService.getById(seatDTO.getEventID()).orElseThrow(()-> new ResourceNotFoundException("Event does not exist"));
        return Seat
                .builder()
                .seatNumber(seatDTO.getSeatNumber())
                .price(seatDTO.getPrice())
                .category(seatDTO.getCategory())
                .rowNumber(seatDTO.getRowNumber())
                .seatNumber(seatDTO.getSeatNumber())
                //on create
                .isOccupied(false)
                .event(event)
                .build();
    }

    @Override
    public SeatDTO toDTO(Seat seat) {
        return null;
    }

    @Override
    public List<SeatDTO> listToDTO(List<Seat> seats) {
        return null;
    }
}
