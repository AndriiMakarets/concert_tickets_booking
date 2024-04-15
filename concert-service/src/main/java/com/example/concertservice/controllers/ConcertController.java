package com.example.concertservice.controllers;

import com.example.concertservice.dto.ConcertDTO;
import com.example.concertservice.exceptions.ResourceNotFoundException;
import com.example.concertservice.mappers.ConcertMapper;
import com.example.concertservice.models.Concert;
import com.example.concertservice.services.ConcertService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/ticket-booking/concerts")
@RequiredArgsConstructor
public class ConcertController {
    private final ConcertService concertService;
    private final ConcertMapper concertMapper;

    @GetMapping()
    public ResponseEntity<List<ConcertDTO>> getConcerts() {
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
        Concert updatedConcert = concertService.updateConcert(newConcert);
        return ResponseEntity.ok(concertMapper.toDTO(updatedConcert));

    }
    @Transactional
    @PostMapping
    public ResponseEntity<Concert> createConcert(@RequestBody ConcertDTO concertDTO) {
        Concert contact = concertMapper.toConcert(concertDTO);
        //add venue and any other dependencies. Use grpc call here.
        Concert savedConcert = concertService.createConcert(contact);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedConcert);
    }
    @Transactional
    @GetMapping("/{id}")
    public ResponseEntity<Concert> getById(@PathVariable Long id) {
        System.out.println("GET BY ID");
        return ResponseEntity.status(HttpStatus.CREATED).body(concertService.getById(id).orElseThrow(() -> new ResourceNotFoundException("Contact doesn't exist")));
    }

    @Transactional //delete all connected entities
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteContact(@PathVariable Long id) {
        concertService.deleteById(id);
        return ResponseEntity.ok().body("object deleted: " + id);
    }
}
