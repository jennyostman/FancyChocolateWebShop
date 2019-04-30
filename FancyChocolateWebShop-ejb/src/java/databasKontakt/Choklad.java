/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author marcu
 * aer awesome
 */

package databasKontakt;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Basic;
import static javax.persistence.CascadeType.PERSIST;
import javax.persistence.Entity;
import static javax.persistence.FetchType.LAZY;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;


@Entity
public class Choklad implements Serializable {

    @Basic(fetch=LAZY)
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional=false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    private String namn;
    private double pris;
    private String beskrivning;
    private String marke;
    private int antalILager;
    
    @OneToMany(cascade=PERSIST, mappedBy="choklad")
    private  List<OrderDetalj> orderDetaljer =new ArrayList();

    public Choklad() {
    }

    public Choklad(String namn, double pris, int antalILager) {
        this.namn = namn;
        this.pris = pris;
        this.antalILager = antalILager;
       // System.out.println("Choklad skapats med namn " + namn);
    }

    public Choklad(String namn, double pris, String beskrivning, String marke, int antalILager) {
        this.namn = namn;
        this.pris = pris;
        this.beskrivning = beskrivning;
        this.marke = marke;
        this.antalILager = antalILager;
    }

    public List<OrderDetalj> getOrderDetaljer() {
        return orderDetaljer;
    }

    public void setOrderDetaljer(List<OrderDetalj> orderDetaljer) {
        this.orderDetaljer = orderDetaljer;
    }

    
    
    public String getNamn() {
        return namn;
    }

    public void setNamn(String namn) {
        this.namn = namn;
    }

    public double getPris() {
        return pris;
    }

    public void setPris(double pris) {
        this.pris = pris;
    }

    public String getBeskrivning() {
        return beskrivning;
    }

    public void setBeskrivning(String beskrivning) {
        this.beskrivning = beskrivning;
    }

    public String getMarke() {
        return marke;
    }

    public void setMarke(String marke) {
        this.marke = marke;
    }

    public int getAntalILager() {
        return antalILager;
    }

    public void setAntalILager(int antalILager) {
        this.antalILager = antalILager;
    }
    
    

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Choklad)) {
            return false;
        }
        Choklad other = (Choklad) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "DatabasKontakt.Choklad[ id=" + id + " ]";
    }

}
