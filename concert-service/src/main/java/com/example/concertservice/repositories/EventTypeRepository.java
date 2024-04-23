package com.example.concertservice.repositories;

import com.example.concertservice.models.Event;
import com.example.concertservice.models.EventTypes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface EventTypeRepository extends JpaRepository<EventTypes, Long> {

}
