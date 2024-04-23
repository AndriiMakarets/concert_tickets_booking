package com.example.concertservice.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class VenueDTO {

    private String name;
    private String address;
    private Integer capacity;
    private String description;
    private Long venueTypeID;

}
