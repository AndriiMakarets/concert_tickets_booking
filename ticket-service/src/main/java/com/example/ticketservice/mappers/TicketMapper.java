package com.example.ticketservice.mappers;

import com.example.ticketservice.dto.TicketDTO;
import com.example.ticketservice.models.Ticket;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface TicketMapper {
    Ticket toTicket(TicketDTO ticketDTO);
    TicketDTO toDTO(Ticket ticket);
    List<TicketDTO> listToDTO (List<Ticket> tickets);
}

