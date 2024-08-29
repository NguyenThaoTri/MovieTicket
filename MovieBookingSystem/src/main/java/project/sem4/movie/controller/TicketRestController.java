package project.sem4.movie.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import project.sem4.movie.entities.Tickets;
import project.sem4.movie.service.TicketService;

import java.util.List;

@RestController
@RequestMapping("/api/tickets")
public class TicketRestController {

    private final TicketService ticketService;

    @Autowired
    public TicketRestController(TicketService ticketService) {
        this.ticketService = ticketService;
    }

    @GetMapping
    public ResponseEntity<List<Tickets>> getAllTickets() {
        List<Tickets> tickets = ticketService.getAllTickets();
        return new ResponseEntity<>(tickets, HttpStatus.OK);
    }

    @GetMapping("/{ticketId}")
    public ResponseEntity<Tickets> getTicketById(@PathVariable int ticketId) {
        Tickets ticket = ticketService.getTicketById(ticketId);
        if (ticket != null) {
            return new ResponseEntity<>(ticket, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public ResponseEntity<Tickets> createTicket(@RequestBody Tickets newTicket) {
        Tickets createdTicket = ticketService.pushTicket(newTicket);
        return new ResponseEntity<>(createdTicket, HttpStatus.CREATED);
    }

    @PutMapping("/{ticketId}")
    public ResponseEntity<Tickets> updateTicket(
            @RequestBody Tickets updateTicket,
            @PathVariable int ticketId
    ) {
        Tickets updatedTicket = ticketService.updateTicket(updateTicket, ticketId);
        if (updatedTicket != null) {
            return new ResponseEntity<>(updatedTicket, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{ticketId}")
    public ResponseEntity<Void> deleteTicketById(@PathVariable int ticketId) {
        ticketService.deleteTicketById(ticketId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
