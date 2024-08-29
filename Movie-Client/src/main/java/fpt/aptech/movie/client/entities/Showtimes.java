/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fpt.aptech.movie.client.entities;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import jakarta.persistence.*;


/**
 *
 * @author NTT
 */
@Entity
@Table(name = "Showtimes")
@NamedQueries({
    @NamedQuery(name = "Showtimes.findAll", query = "SELECT s FROM Showtimes s"),
    @NamedQuery(name = "Showtimes.findByShowtimeId", query = "SELECT s FROM Showtimes s WHERE s.showtimeId = :showtimeId"),
    @NamedQuery(name = "Showtimes.findByStartTime", query = "SELECT s FROM Showtimes s WHERE s.startTime = :startTime"),
    @NamedQuery(name = "Showtimes.findByEndTime", query = "SELECT s FROM Showtimes s WHERE s.endTime = :endTime")})
public class Showtimes implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "showtime_id")
    private Integer showtimeId;
    @Column(name = "start_time")
    @Temporal(TemporalType.TIMESTAMP)
    private Date startTime;
    @Column(name = "end_time")
    @Temporal(TemporalType.TIMESTAMP)
    private Date endTime;
    @OneToMany(mappedBy = "showtimeId")
    private Collection<Tickets> ticketsCollection;
    @JoinColumn(name = "movie_id", referencedColumnName = "movie_id")
    @ManyToOne
    private Movies movieId;
    @JoinColumn(name = "room_id", referencedColumnName = "room_id")
    @ManyToOne
    private Room roomId;

    public Showtimes() {
    }

    public Showtimes(Integer showtimeId) {
        this.showtimeId = showtimeId;
    }

    public Integer getShowtimeId() {
        return showtimeId;
    }

    public void setShowtimeId(Integer showtimeId) {
        this.showtimeId = showtimeId;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public Collection<Tickets> getTicketsCollection() {
        return ticketsCollection;
    }

    public void setTicketsCollection(Collection<Tickets> ticketsCollection) {
        this.ticketsCollection = ticketsCollection;
    }

    public Movies getMovieId() {
        return movieId;
    }

    public void setMovieId(Movies movieId) {
        this.movieId = movieId;
    }

    public Room getRoomId() {
        return roomId;
    }

    public void setRoomId(Room roomId) {
        this.roomId = roomId;
    }

}
