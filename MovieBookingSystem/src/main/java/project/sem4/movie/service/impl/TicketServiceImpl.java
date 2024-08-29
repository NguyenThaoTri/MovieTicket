package project.sem4.movie.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import project.sem4.movie.entities.Tickets;
import project.sem4.movie.repository.TicketRepository;
import project.sem4.movie.service.TicketService;

import java.util.List;
import java.util.Optional;

@Service
public class TicketServiceImpl implements TicketService {

    private final TicketRepository ticketRepository;

    @Autowired
    public TicketServiceImpl(TicketRepository ticketRepository) {
        this.ticketRepository = ticketRepository;
    }

    @Override
    public List<Tickets> getAllTickets() {
        return ticketRepository.findAll();
    }

    @Override
    public Tickets getTicketById(int ticket_id) {
        Optional<Tickets> optionalTicket = ticketRepository.findById(ticket_id);
        return optionalTicket.orElse(null);
    }

    @Override
    public Tickets pushTicket(Tickets newTicket) {
        return ticketRepository.save(newTicket);
    }

    @Override
    public Tickets updateTicket(Tickets updateTicket, int ticket_id) {
        Optional<Tickets> optionalTicket = ticketRepository.findById(ticket_id);
        if (optionalTicket.isPresent()) {
            Tickets existingTicket = optionalTicket.get();
            // Update ticket attributes here
            existingTicket.setIsPaid(updateTicket.getIsPaid());
            // Set other attributes as needed

            return ticketRepository.save(existingTicket);
        }
        return null; // Ticket with given ID not found
    }

    @Override
    public void deleteTicketById(int ticket_id) {
        ticketRepository.deleteById(ticket_id);
    }
}
