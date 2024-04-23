package com.example.concertservice.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class SeatDTO {

    private Long eventID;
    private int rowNumber;  // номер ряду
    private int seatNumber;  // номер місця
    private String category;  // категорія місця (наприклад, VIP, стандарт тощо)
    private double price;  // ціна місця

}
