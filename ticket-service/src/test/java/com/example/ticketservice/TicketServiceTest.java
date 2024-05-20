package java.com.example.ticketservice;

import com.example.ticketservice.models.Ticket;
import com.example.ticketservice.repositories.TicketRepository;
import com.example.ticketservice.services.TicketService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

public class TicketServiceTest {

    @Mock
    private TicketRepository ticketRepository;

    @InjectMocks
    private TicketService ticketService;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testGetAll() {
        ticketService.getAll();
        verify(ticketRepository, times(1)).findAll();
    }

    @Test
    public void testGetById() {
        Ticket ticket = new Ticket();
        when(ticketRepository.findById(1L)).thenReturn(Optional.of(ticket));

        Optional<Ticket> foundTicket = ticketService.getById(1L);
        assertThat(foundTicket.isPresent()).isTrue();
        assertThat(foundTicket.get()).isEqualTo(ticket);
    }

    @Test
    public void testCreateTicket() {
        Ticket ticket = new Ticket();
        when(ticketRepository.save(any(Ticket.class))).thenReturn(ticket);

        Ticket createdTicket = ticketService.createTicket(ticket);
        assertThat(createdTicket).isEqualTo(ticket);
    }

    @Test
    public void testUpdateTicket() {
        Ticket ticket = new Ticket();
        when(ticketRepository.save(any(Ticket.class))).thenReturn(ticket);

        Ticket updatedTicket = ticketService.updateTicket(ticket);
        assertThat(updatedTicket).isEqualTo(ticket);
    }

    @Test
    public void testDeleteById() {
        doNothing().when(ticketRepository).deleteById(1L);

        ticketService.deleteById(1L);
        verify(ticketRepository, times(1)).deleteById(1L);
    }
}

