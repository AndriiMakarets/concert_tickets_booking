package com.example.concertservice.mappers;

import com.example.concertservice.dto.SeatDTO;
import com.example.concertservice.dto.SeatResponseDTO;
import com.example.concertservice.models.Seat;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface SeatMapper {
    Seat toSeat(SeatDTO seatDTO);
    SeatResponseDTO toDTO(Seat seat);
    List<SeatResponseDTO> listToDTO(List<Seat> seats);

}
