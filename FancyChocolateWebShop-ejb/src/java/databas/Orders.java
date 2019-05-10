
package databas;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import static javax.persistence.CascadeType.PERSIST;
import javax.persistence.*;

@Entity
public class Orders implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional=false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long orderId;
    public Date date;
    private double price;

    @ManyToOne(cascade=PERSIST)
    public Person person;
    
    @OneToMany(cascade=PERSIST, mappedBy="orders")
    private List<OrderDetails> orderDetails = new ArrayList();
    
    public Orders() {}
    
    public Orders(Person person) {
        this.date = new Date();
        this.person = person;
    }
    
    public double getPrice(){
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
    
    

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public List<OrderDetails> getOrderDetails() {
        return orderDetails;
    }

    public void setOrderDetails(List<OrderDetails> orderDetails) {
        this.orderDetails = orderDetails;
    }

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (orderId != null ? orderId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof Orders)) {
            return false;
        }
        Orders other = (Orders) object;
        if ((this.orderId == null && other.orderId != null) || (this.orderId != null && !this.orderId.equals(other.orderId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "databas.Order[ id=" + orderId + " ]";
    }
}
