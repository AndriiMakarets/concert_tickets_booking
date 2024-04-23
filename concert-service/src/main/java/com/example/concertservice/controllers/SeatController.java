package com.example.concertservice.controllers;

import com.example.concertservice.dto.SeatDTO;
import com.example.concertservice.exceptions.ResourceNotFoundException;
import com.example.concertservice.mappers.EventMapper;
import com.example.concertservice.mappers.SeatMapper;
import com.example.concertservice.models.Seat;
import com.example.concertservice.services.SeatService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/ticket-booking/seats")
@RequiredArgsConstructor
public class SeatController {

    private final SeatService seatService;
    private final SeatMapper seatMapper;

    @PostMapping
    public ResponseEntity<Seat> createSeat(@RequestBody SeatDTO seatDTO) {
        Seat seat = seatMapper.toSeat(seatDTO);
        Seat createdSeat = seatService.createSeat(seat);
        return new ResponseEntity<>(createdSeat, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Seat>> getAllSeats() {
        List<Seat> seats = seatService.getAllSeats();
        return new ResponseEntity<>(seats, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Seat> getSeatById(@PathVariable("id") Long id) {
        Seat seat = seatService.getSeatById(id).orElseThrow(() -> new ResourceNotFoundException("Seat doesn't exist"));
        return ResponseEntity.ok(seat);
    }

    //update will not be available for external users. Occupied status will be change from payment service.
//    @PutMapping("/{id}")
//    public ResponseEntity<Seat> updateSeat(@PathVariable("id") Long id, @RequestBody SeatDTO seat) {
//        Seat existingSeat = seatService.getSeatById(id).orElseThrow(() -> new ResourceNotFoundException("Seat doesn't exist"));
//        seat.setId(id);
//        Seat updatedSeat = seatService.updateSeat(seat);
//        return ResponseEntity.ok(updatedSeat);
//    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteSeat(@PathVariable("id") Long id) {
        seatService.deleteSeat(id);
        return ResponseEntity.ok().body("Seat deleted: " + id);
    }
}
