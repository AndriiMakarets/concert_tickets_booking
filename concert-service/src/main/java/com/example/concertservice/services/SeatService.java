package com.example.concertservice.services;

import com.example.concertservice.exceptions.ResourceNotFoundException;
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

    //TODO: add row and column* field to seat
    public List<Seat> createSeats(int seatsAmount) {
        List<Seat> seats = new ArrayList<>();
        for (int i = 0; i < seatsAmount; i++) {
            Seat seat = Seat.builder().build();
            seats.add(seat);
            seatRepository.save(seat);
        }
        return seats;
    }
}
