package com.example.concertservice.repositories;

import com.example.concertservice.models.Event;
import com.example.concertservice.models.VenueType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface VenueTypeRepository extends JpaRepository<VenueType, Long> {

}
