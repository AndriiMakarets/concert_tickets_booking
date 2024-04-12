package com.example.concertservice.controllers;

import com.example.concertservice.dto.ConcertDTO;
import com.example.concertservice.exceptions.ResourceNotFoundException;
import com.example.concertservice.mappers.ConcertMapper;
import com.example.concertservice.models.Concert;
import com.example.concertservice.services.ConcertService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/concert/v1/ticket-booking")
@RequiredArgsConstructor
public class ConcertController {
    private final ConcertService concertService;
    private final ConcertMapper concertMapper;

    @GetMapping()
    public ResponseEntity<List<ConcertDTO>> getConcerts(){
        List<Concert> concerts = concertService.getAll();
        List<ConcertDTO> contactsDTO = concertMapper.listToDTO(concerts);
        return ResponseEntity.ok().body(contactsDTO);
    }

    @Transactional
    @PutMapping("/{id}")
    public ResponseEntity<ConcertDTO> updateConcert(@RequestBody ConcertDTO concertDTO, @PathVariable Long id) {

        Concert newConcert = concertMapper.toConcert(concertDTO);
        Concert concertToUpdate = concertService.getById(id).orElseThrow(() -> new ResourceNotFoundException("Concert doesn't exist"));
        newConcert.setId(id);
        Concert updatedContact = concertService.updateConcert(newConcert);
        return ResponseEntity.ok(concertMapper.toDTO(updatedContact));

    }
}