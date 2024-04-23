package com.example.concertservice.mappers;

import com.example.concertservice.dto.SeatDTO;
import com.example.concertservice.models.Seat;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface SeatMapper {
    Seat toSeat(SeatDTO seatDTO);
    SeatDTO toDTO(Seat seat);
    List<SeatDTO> listToDTO(List<Seat> seats);

}
