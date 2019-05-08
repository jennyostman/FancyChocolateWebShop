
package databas;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import static javax.persistence.CascadeType.PERSIST;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;


@Entity
public class Person implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long personId;
    @OneToMany(cascade=PERSIST, mappedBy="person")
    private List<Orders> order = new ArrayList();

    private String name;
    private String userName;
    private String password;
    private String address;
    private boolean admin;
    private boolean premium;

    public Person() {}

   
    public Person(String name, String userName, String password, String address, boolean admin, boolean premium) {
        this.name = name;
        this.userName = userName;
        this.password = password;
        this.address = address;
        this.admin = admin;
        this.premium = premium;
    }
    
    public String premiumString(){
        if(premium){
            return "Yes";
        } else {
            return "No";
        }
    }
    
    public int getNumberofOrders(){
        int size = order.size();
        return size;
    }
    
    public double getTotalSum(){
        double total = 0;
        for (Orders o : order){
            total += o.getPrice();
        }
        
        return total;
    }

    public List<Orders> getOrder() {
        return order;
    }

    public void setOrder(List<Orders>order) {
        this.order = order;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public boolean isAdmin() {
        return admin;
    }

    public void setAdmin(boolean admin) {
        this.admin = admin;
    }

    public boolean isPremium() {
        return premium;
    }

    public void setPremium(boolean premium) {
        this.premium = premium;
    }

    
    
    
    public Long getPersonId() {
        return personId;
    }

    public void setPersonId(Long personId) {
        this.personId = personId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (personId != null ? personId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Person)) {
            return false;
        }
        Person other = (Person) object;
        if ((this.personId == null && other.personId != null) || (this.personId != null && !this.personId.equals(other.personId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "databas.Person[ id=" + personId + " ]";
    }

}
