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
@Table(name = "Branchs")
@NamedQueries({
    @NamedQuery(name = "Branchs.findAll", query = "SELECT b FROM Branchs b"),
    @NamedQuery(name = "Branchs.findByBranchId", query = "SELECT b FROM Branchs b WHERE b.branchId = :branchId"),
    @NamedQuery(name = "Branchs.findByCinemaName", query = "SELECT b FROM Branchs b WHERE b.cinemaName = :cinemaName"),
    @NamedQuery(name = "Branchs.findByLocation", query = "SELECT b FROM Branchs b WHERE b.location = :location"),
    @NamedQuery(name = "Branchs.findByContactInfo", query = "SELECT b FROM Branchs b WHERE b.contactInfo = :contactInfo")})
public class Branchs implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "branch_id")
    private Integer branchId;
    @Column(name = "cinema_name")
    private String cinemaName;
    @Column(name = "location")
    private String location;
    @Column(name = "contact_info")
    private String contactInfo;

    public Branchs() {
    }

    public Branchs(Integer branchId) {
        this.branchId = branchId;
    }

    public Integer getBranchId() {
        return branchId;
    }

    public void setBranchId(Integer branchId) {
        this.branchId = branchId;
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
