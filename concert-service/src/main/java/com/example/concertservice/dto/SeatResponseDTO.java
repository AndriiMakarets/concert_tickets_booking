package com.example.concertservice.dto;

import com.example.concertservice.models.Seat;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class SeatResponseDTO {
    private Long id;
    private Long eventID;
    private boolean isOccupied;
    private int rowNumber;  // номер ряду
    private int seatNumber;  // номер місця
    private Seat.Category category;  // категорія місця (наприклад, VIP, стандарт тощо)
    private double price;  // ціна місця

}