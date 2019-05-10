
package databas;

import java.io.Serializable;
import static javax.persistence.CascadeType.PERSIST;
import javax.persistence.*;

@Entity
public class OrderDetails implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private int amount;
    
    @OneToOne(cascade=PERSIST)
    private Chocolate chocolate;
    
    @ManyToOne(cascade=PERSIST)
    public Orders orders;

    
    public OrderDetails(){}
    
    public OrderDetails(int amount, Chocolate chocolate, Orders orders) {
        this.amount = amount;
        this.chocolate = chocolate;
        this.orders = orders;
    }
    
    public double getPrice(){
        double price = 0;
        for (int i = 0; i < amount; i++) {
            price += chocolate.getPrice();
        }
        return price;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public Chocolate getChocolate() {
        return chocolate;
    }

    public void setChocolate(Chocolate chocolate) {
        this.chocolate = chocolate;
    }
    
    public Orders getOrders() {
        return orders;
    }

    public void setOrders(Orders orders) {
        this.orders = orders;
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
        if (!(object instanceof OrderDetails)) {
            return false;
        }
        OrderDetails other = (OrderDetails) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "databas.OrderDetails[ id=" + id + " ]";
    }
}
