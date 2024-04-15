package com.example.ticketservice.mappers;

import com.example.ticketservice.dto.TicketDTO;
import com.example.ticketservice.models.Ticket;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class TicketMapperImpl implements TicketMapper {
    @Override
    public Ticket toTicket(TicketDTO ticketDTO) {
        return null;
    }

    @Override
    public TicketDTO toDTO(Ticket ticket) {
        return null;
    }

    @Override
    public List<TicketDTO> listToDTO(List<Ticket> tickets) {
        return null;
    }
}
