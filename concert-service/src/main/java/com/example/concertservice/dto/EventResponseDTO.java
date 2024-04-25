package com.example.concertservice.dto;

import lombok.*;

import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class EventResponseDTO {
    private Long id;
    private int seatsAmount;
    private String name;
    private String description;
    private Long eventTypeID;
    private Date eventDate;
    private Date saleStartDate;
    private Date saleEndDate;
    private Long venueID;
}
