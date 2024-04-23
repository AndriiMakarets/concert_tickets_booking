package com.example.concertservice.dto;

import com.example.concertservice.models.EventTypes;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class EventCreationDTO {
    private int seatsAmount;
    private String name;
    private String description;
    private Long eventTypeID;
    private Date eventDate;
    private Date saleStartDate;
    private Date saleEndDate;
    private Long venueID;
}
