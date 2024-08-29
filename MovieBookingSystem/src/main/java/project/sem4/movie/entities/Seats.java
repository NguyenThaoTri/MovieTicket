/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package project.sem4.movie.entities;

import java.io.Serializable;
import java.util.Collection;
import jakarta.persistence.*;


/**
 *
 * @author NTT
 */
@Entity
@Table(name = "Seats")
@NamedQueries({
    @NamedQuery(name = "Seats.findAll", query = "SELECT s FROM Seats s"),
    @NamedQuery(name = "Seats.findBySeatId", query = "SELECT s FROM Seats s WHERE s.seatId = :seatId"),
    @NamedQuery(name = "Seats.findByIsBooked", query = "SELECT s FROM Seats s WHERE s.isBooked = :isBooked")})
public class Seats implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "seat_id")
    private Integer seatId;
    @Column(name = "is_booked")
    private Boolean isBooked;
    @OneToMany(mappedBy = "seatId")
    private Collection<Tickets> ticketsCollection;
    @JoinColumn(name = "room_id", referencedColumnName = "room_id")
    @ManyToOne
    private Room roomId;
    @JoinColumn(name = "type_id", referencedColumnName = "type_id")
    @ManyToOne
    private SeatTypes typeId;

    public Seats() {
    }

    public Seats(Integer seatId) {
        this.seatId = seatId;
    }

    public Integer getSeatId() {
        return seatId;
    }

    public void setSeatId(Integer seatId) {
        this.seatId = seatId;
    }

    public Boolean getIsBooked() {
        return isBooked;
    }

    public void setIsBooked(Boolean isBooked) {
        this.isBooked = isBooked;
    }

    public Collection<Tickets> getTicketsCollection() {
        return ticketsCollection;
    }

    public void setTicketsCollection(Collection<Tickets> ticketsCollection) {
        this.ticketsCollection = ticketsCollection;
    }

    public Room getRoomId() {
        return roomId;
    }

    public void setRoomId(Room roomId) {
        this.roomId = roomId;
    }

    public SeatTypes getTypeId() {
        return typeId;
    }

    public void setTypeId(SeatTypes typeId) {
        this.typeId = typeId;
    }

   
}
