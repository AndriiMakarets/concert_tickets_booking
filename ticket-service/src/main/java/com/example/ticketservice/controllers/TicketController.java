package com.example.ticketservice.controllers;

import java.util.List;
import com.example.ticketservice.dto.TicketDTO;
import com.example.ticketservice.exceptions.ResourceNotFoundException;
import com.example.ticketservice.mappers.TicketMapper;
import com.example.ticketservice.models.Ticket;
import com.example.ticketservice.services.TicketService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/ticket-booking/tickets")
@RequiredArgsConstructor
public class TicketController {
    private final TicketService ticketService;
    private final TicketMapper ticketMapper;

    @GetMapping()
    public ResponseEntity<List<TicketDTO>> getTickets() {
        List<Ticket> tickets = ticketService.getAll();
        List<TicketDTO> ticketsDTO = ticketMapper.listToDTO(tickets);
        return ResponseEntity.ok().body(ticketsDTO);
    }

    @Transactional
    @PutMapping("/{id}")
    public ResponseEntity<TicketDTO> updateTicket(@RequestBody TicketDTO ticketDTO, @PathVariable Long id) {

        Ticket newTicket = ticketMapper.toTicket(ticketDTO);
        Ticket ticketToUpdate = ticketService.getById(id).orElseThrow(() -> new ResourceNotFoundException("Ticket doesn't exist"));
        newTicket.setId(id);
        Ticket updatedTicket = ticketService.updateTicket(newTicket);
        return ResponseEntity.ok(ticketMapper.toDTO(updatedTicket));

    }
    @Transactional
    @PostMapping
    public ResponseEntity<Ticket> createTicket(@RequestBody TicketDTO ticketDTO) {
        Ticket ticket = ticketMapper.toTicket(ticketDTO);
        //add venue and any other dependencies. Use grpc call here.
        Ticket savedTicket = ticketService.createTicket(ticket);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedTicket);
    }
    @Transactional
    @GetMapping("/{id}")
    public ResponseEntity<Ticket> getById(@PathVariable Long id) {
        System.out.println("GET BY ID");
        return ResponseEntity.status(HttpStatus.CREATED).body(ticketService.getById(id).orElseThrow(() -> new ResourceNotFoundException("Ticket doesn't exist")));
    }

    @Transactional //delete all connected entities
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteTicket(@PathVariable Long id) {
        ticketService.deleteById(id);
        return ResponseEntity.ok().body("object deleted: " + id);
    }
}
