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
@Table(name = "Room")
@NamedQueries({
    @NamedQuery(name = "Room.findAll", query = "SELECT r FROM Room r"),
    @NamedQuery(name = "Room.findByRoomId", query = "SELECT r FROM Room r WHERE r.roomId = :roomId"),
    @NamedQuery(name = "Room.findByRoomNumber", query = "SELECT r FROM Room r WHERE r.roomNumber = :roomNumber"),
    @NamedQuery(name = "Room.findByCapacity", query = "SELECT r FROM Room r WHERE r.capacity = :capacity"),
    @NamedQuery(name = "Room.findByBranchId", query = "SELECT r FROM Room r WHERE r.branchId = :branchId")})
public class Room implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "room_id")
    private Integer roomId;
    @Column(name = "room_number")
    private String roomNumber;
    @Column(name = "capacity")
    private Integer capacity;
    @Basic(optional = false)
    @Column(name = "branch_id")
    private int branchId;
    @OneToMany(mappedBy = "roomId")
    private Collection<Showtimes> showtimesCollection;
    @OneToMany(mappedBy = "roomId")
    private Collection<Seats> seatsCollection;

    public Room() {
    }

    public Room(Integer roomId) {
        this.roomId = roomId;
    }

    public Room(Integer roomId, int branchId) {
        this.roomId = roomId;
        this.branchId = branchId;
    }

    public Integer getRoomId() {
        return roomId;
    }

    public void setRoomId(Integer roomId) {
        this.roomId = roomId;
    }

    public String getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(String roomNumber) {
        this.roomNumber = roomNumber;
    }

    public Integer getCapacity() {
        return capacity;
    }

    public void setCapacity(Integer capacity) {
        this.capacity = capacity;
    }

    public int getBranchId() {
        return branchId;
    }

    public void setBranchId(int branchId) {
        this.branchId = branchId;
    }

    public Collection<Showtimes> getShowtimesCollection() {
        return showtimesCollection;
    }

    public void setShowtimesCollection(Collection<Showtimes> showtimesCollection) {
        this.showtimesCollection = showtimesCollection;
    }

    public Collection<Seats> getSeatsCollection() {
        return seatsCollection;
    }

    public void setSeatsCollection(Collection<Seats> seatsCollection) {
        this.seatsCollection = seatsCollection;
    }

}