package com.example.concertservice.services;

import com.example.concertservice.models.Concert;
import com.example.concertservice.repositories.ConcertRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ConcertService {
    private final ConcertRepository concertRepository;
    public List<Concert> getAll() {
        return concertRepository.findAll();
    }
    public Optional<Concert> getById(Long id) {
        return concertRepository.findById(id);
    }

    public Concert updateConcert(Concert concert){
        return concertRepository.save(concert);
    }
}
