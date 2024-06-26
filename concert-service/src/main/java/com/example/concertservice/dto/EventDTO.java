package com.example.concertservice.dto;

import lombok.*;

import java.util.Date;
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class EventDTO {
    private int seatsAmount;
    private int rows;
    private int columns;
    private String name;
    private String description;
    private Long eventTypeID;
    private Date eventDate;
    private Date saleStartDate;
    private Date saleEndDate;
    private Long venueID;
}
