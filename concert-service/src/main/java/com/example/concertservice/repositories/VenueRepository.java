package com.example.concertservice.repositories;

import com.example.concertservice.models.Event;
import com.example.concertservice.models.Venue;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface VenueRepository extends JpaRepository<Venue, Long> {

}