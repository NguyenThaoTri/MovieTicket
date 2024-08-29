/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fpt.aptech.movie.client.entities;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Collection;
import jakarta.persistence.*;

/**
 *
 * @author NTT
 */
@Entity
@Table(name = "SeatTypes")
@NamedQueries({
    @NamedQuery(name = "SeatTypes.findAll", query = "SELECT s FROM SeatTypes s"),
    @NamedQuery(name = "SeatTypes.findByTypeId", query = "SELECT s FROM SeatTypes s WHERE s.typeId = :typeId"),
    @NamedQuery(name = "SeatTypes.findByTypeName", query = "SELECT s FROM SeatTypes s WHERE s.typeName = :typeName"),
    @NamedQuery(name = "SeatTypes.findByPrice", query = "SELECT s FROM SeatTypes s WHERE s.price = :price")})
public class SeatTypes implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "type_id")
    private Integer typeId;
    @Column(name = "type_name")
    private String typeName;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "price")
    private BigDecimal price;
    @OneToMany(mappedBy = "typeId")
    private Collection<Seats> seatsCollection;

    public SeatTypes() {
    }

    public SeatTypes(Integer typeId) {
        this.typeId = typeId;
    }

    public Integer getTypeId() {
        return typeId;
    }

    public void setTypeId(Integer typeId) {
        this.typeId = typeId;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Collection<Seats> getSeatsCollection() {
        return seatsCollection;
    }

    public void setSeatsCollection(Collection<Seats> seatsCollection) {
        this.seatsCollection = seatsCollection;
    }

}
