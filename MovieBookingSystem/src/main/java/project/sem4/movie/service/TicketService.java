/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package project.sem4.movie.service;

import java.util.List;
import project.sem4.movie.entities.Tickets;

/**
 *
 * @author NTT
 */
public interface TicketService {
    List<Tickets> getAllTickets();
    
    Tickets getTicketById(int showtime_id);
    
    Tickets pushTicket(Tickets newTicket);
    
    Tickets updateTicket(Tickets updateTicket, int ticket_id);
    
    void deleteTicketById(int ticket_id);
}
