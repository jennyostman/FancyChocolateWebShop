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
import javax.persistence.Basic;
import static javax.persistence.CascadeType.PERSIST;
import javax.persistence.Entity;
import static javax.persistence.FetchType.LAZY;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;


@Entity
public class OrderDetalj implements Serializable {

    @Basic(fetch=LAZY)
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional=false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    @ManyToOne(cascade=PERSIST)
    private Order order;
    
    @ManyToOne(cascade=PERSIST)
    private Choklad choklad;

    public OrderDetalj() {
    }

    public OrderDetalj(Order order, Choklad choklad) {
        this.order = order;
        this.choklad = choklad;
    }
    
    

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public Choklad getChoklad() {
        return choklad;
    }

    public void setChoklad(Choklad choklad) {
        this.choklad = choklad;
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
        if (!(object instanceof OrderDetalj)) {
            return false;
        }
        OrderDetalj other = (OrderDetalj) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "DatabasKontakt.OrderDetalj[ id=" + id + " ]";
    }

}
