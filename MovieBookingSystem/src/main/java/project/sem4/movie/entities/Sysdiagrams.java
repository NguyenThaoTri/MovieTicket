/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package project.sem4.movie.entities;

import java.io.Serializable;
import jakarta.persistence.*;


/**
 *
 * @author NTT
 */
@Entity
@Table(name = "sysdiagrams")
@NamedQueries({
    @NamedQuery(name = "Sysdiagrams.findAll", query = "SELECT s FROM Sysdiagrams s"),
    @NamedQuery(name = "Sysdiagrams.findByName", query = "SELECT s FROM Sysdiagrams s WHERE s.name = :name"),
    @NamedQuery(name = "Sysdiagrams.findByPrincipalId", query = "SELECT s FROM Sysdiagrams s WHERE s.principalId = :principalId"),
    @NamedQuery(name = "Sysdiagrams.findByDiagramId", query = "SELECT s FROM Sysdiagrams s WHERE s.diagramId = :diagramId"),
    @NamedQuery(name = "Sysdiagrams.findByVersion", query = "SELECT s FROM Sysdiagrams s WHERE s.version = :version")})
public class Sysdiagrams implements Serializable {

    private static final long serialVersionUID = 1L;
    @Basic(optional = false)
    @Column(name = "name")
    private String name;
    @Basic(optional = false)
    @Column(name = "principal_id")
    private int principalId;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "diagram_id")
    private Integer diagramId;
    @Column(name = "version")
    private Integer version;
    @Lob
    @Column(name = "definition")
    private byte[] definition;

    public Sysdiagrams() {
    }

    public Sysdiagrams(Integer diagramId) {
        this.diagramId = diagramId;
    }

    public Sysdiagrams(Integer diagramId, String name, int principalId) {
        this.diagramId = diagramId;
        this.name = name;
        this.principalId = principalId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrincipalId() {
        return principalId;
    }

    public void setPrincipalId(int principalId) {
        this.principalId = principalId;
    }

    public Integer getDiagramId() {
        return diagramId;
    }

    public void setDiagramId(Integer diagramId) {
        this.diagramId = diagramId;
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    public byte[] getDefinition() {
        return definition;
    }

    public void setDefinition(byte[] definition) {
        this.definition = definition;
    }
    
}
