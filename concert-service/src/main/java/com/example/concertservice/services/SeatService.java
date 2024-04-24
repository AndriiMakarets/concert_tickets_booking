package com.example.concertservice.services;

import com.example.concertservice.exceptions.ResourceNotFoundException;
import com.example.concertservice.models.Event;
import com.example.concertservice.models.Seat;
import com.example.concertservice.repositories.SeatRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class SeatService {

    private final SeatRepository seatRepository;
    public Seat createSeat(Seat seat) {
        return seatRepository.save(seat);
    }

    public List<Seat> getAllSeats() {
        return seatRepository.findAll();
    }

    public Optional<Seat> getSeatById(Long id) {
        return seatRepository.findById(id);
    }


    public void deleteSeat(Long id) {
        Seat existingSeat = getSeatById(id).orElseThrow(() -> new ResourceNotFoundException("Seat doesn't exist"));
        seatRepository.deleteById(id);
    }

    // Seats amount in Event DTO. Also, there is a capacity in venue. Can I make seat's amount nullable attribute?
    // or just remove it. and take seats from venue

    //seats amount need to be rows * cols
    public List<Seat> createSeats(int seatsAmount, int rows, int cols) {
        List<Seat> seats = new ArrayList<>();
        for (int row = 0; row < rows; row++) {
            for(int col=0; col<cols;col++) {
                Seat seat = Seat
                        .builder()
                        .rowNumber(row)
                        .seatNumber(col)
                        .isOccupied(false)
                        .build();
                seats.add(seat);
                seatRepository.save(seat);
            }
        }
        return seats;
    }

    public List<Seat> getFreeSeatsForConcert(Long id) {
        return seatRepository.findFreeSeatsForConcert(id);
    }
}
