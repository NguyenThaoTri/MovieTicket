/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fpt.aptech.movie.client.entities;

import java.io.Serializable;
import jakarta.persistence.*;

/**
 *
 * @author NTT
 */
@Entity
@Table(name = "Cinemas")
@NamedQueries({
    @NamedQuery(name = "Cinemas.findAll", query = "SELECT c FROM Cinemas c"),
    @NamedQuery(name = "Cinemas.findByCinemaId", query = "SELECT c FROM Cinemas c WHERE c.cinemaId = :cinemaId"),
    @NamedQuery(name = "Cinemas.findByCinemaName", query = "SELECT c FROM Cinemas c WHERE c.cinemaName = :cinemaName"),
    @NamedQuery(name = "Cinemas.findByLocation", query = "SELECT c FROM Cinemas c WHERE c.location = :location"),
    @NamedQuery(name = "Cinemas.findByContactInfo", query = "SELECT c FROM Cinemas c WHERE c.contactInfo = :contactInfo")})
public class Cinemas implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "cinema_id")
    private Integer cinemaId;
    @Column(name = "cinema_name")
    private String cinemaName;
    @Column(name = "location")
    private String location;
    @Column(name = "contact_info")
    private String contactInfo;

    public Cinemas() {
    }

    public Cinemas(Integer cinemaId) {
        this.cinemaId = cinemaId;
    }

    public Integer getCinemaId() {
        return cinemaId;
    }

    public void setCinemaId(Integer cinemaId) {
        this.cinemaId = cinemaId;
    }

    public String getCinemaName() {
        return cinemaName;
    }

    public void setCinemaName(String cinemaName) {
        this.cinemaName = cinemaName;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getContactInfo() {
        return contactInfo;
    }

    public void setContactInfo(String contactInfo) {
        this.contactInfo = contactInfo;
    }

}
