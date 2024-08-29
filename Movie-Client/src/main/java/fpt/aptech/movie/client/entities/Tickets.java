/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fpt.aptech.movie.client.entities;

import java.io.Serializable;
import java.util.Collection;
import jakarta.persistence.*;


/**
 *
 * @author NTT
 */
@Entity
@Table(name = "Tickets")
@NamedQueries({
    @NamedQuery(name = "Tickets.findAll", query = "SELECT t FROM Tickets t"),
    @NamedQuery(name = "Tickets.findByTicketId", query = "SELECT t FROM Tickets t WHERE t.ticketId = :ticketId"),
    @NamedQuery(name = "Tickets.findByIsPaid", query = "SELECT t FROM Tickets t WHERE t.isPaid = :isPaid")})
public class Tickets implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ticket_id")
    private Integer ticketId;
    @Column(name = "is_paid")
    private Boolean isPaid;
    @OneToMany(mappedBy = "ticketId")
    private Collection<Bookings> bookingsCollection;
    @JoinColumn(name = "seat_id", referencedColumnName = "seat_id")
    @ManyToOne
    private Seats seatId;
    @JoinColumn(name = "showtime_id", referencedColumnName = "showtime_id")
    @ManyToOne
    private Showtimes showtimeId;

    public Tickets() {
    }

    public Tickets(Integer ticketId) {
        this.ticketId = ticketId;
    }

    public Integer getTicketId() {
        return ticketId;
    }

    public void setTicketId(Integer ticketId) {
        this.ticketId = ticketId;
    }

    public Boolean getIsPaid() {
        return isPaid;
    }

    public void setIsPaid(Boolean isPaid) {
        this.isPaid = isPaid;
    }

    public Collection<Bookings> getBookingsCollection() {
        return bookingsCollection;
    }

    public void setBookingsCollection(Collection<Bookings> bookingsCollection) {
        this.bookingsCollection = bookingsCollection;
    }

    public Seats getSeatId() {
        return seatId;
    }

    public void setSeatId(Seats seatId) {
        this.seatId = seatId;
    }

    public Showtimes getShowtimeId() {
        return showtimeId;
    }

    public void setShowtimeId(Showtimes showtimeId) {
        this.showtimeId = showtimeId;
    }
    
}
