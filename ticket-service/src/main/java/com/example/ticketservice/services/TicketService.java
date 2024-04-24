package com.example.ticketservice.services;

import com.example.ticketservice.dto.BookTicketDTO;
import com.example.ticketservice.dto.BookTicketsDTO;
import com.example.ticketservice.models.Ticket;
import com.example.ticketservice.repositories.TicketRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class TicketService {
    private final TicketRepository ticketRepository;
//    private final PaymentServiceClient paymentServiceClient;

    public List<Ticket> getAll() {
        return ticketRepository.findAll();
    }

    public Optional<Ticket> getById(Long id) {
        return ticketRepository.findById(id);
    }

    public Ticket updateTicket(Ticket ticket) {
        return ticketRepository.save(ticket);
    }

    public void deleteById(Long id) {
        ticketRepository.deleteById(id);
    }

    public Ticket createTicket(BookTicketsDTO bookTicketsDTO) {
//        paymentServiceClient.proceed();
//        return ticketRepository.save(ticket);
        //}
        return null;
    }
}
