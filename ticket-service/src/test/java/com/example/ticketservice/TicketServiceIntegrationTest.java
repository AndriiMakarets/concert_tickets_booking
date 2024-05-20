package java.com.example.ticketservice;

import com.example.ticketservice.models.Ticket;
import com.example.ticketservice.repositories.TicketRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@Transactional
@Rollback
public class TicketServiceIntegrationTest {

    @Autowired
    private TicketRepository ticketRepository

    @Test
    public void testCreateAndRetrieveTicket() {
        Ticket ticket = new Ticket();

        ticket.setPrice(BigDecimal.valueOf(100.0));

        ticketRepository.save(ticket);

        Ticket foundTicket = ticketRepository.findById(ticket.getId()).orElse(null);
        assertThat(foundTicket).isNotNull();

        assertThat(foundTicket.getPrice()).isEqualTo(100.0);
    }
}

