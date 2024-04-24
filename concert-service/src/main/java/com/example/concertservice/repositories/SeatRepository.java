package com.example.concertservice.repositories;

import com.example.concertservice.models.Event;
import com.example.concertservice.models.Seat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository

public interface SeatRepository extends JpaRepository<Seat, Long> {
    @Query(value = """
            SELECT * 
            FROM seats 
            WHERE event_id = :id
            AND is_occupied = false
            """, nativeQuery = true)
    List<Seat> findFreeSeatsForConcert(
            @Param("id") Long id
    );
}
