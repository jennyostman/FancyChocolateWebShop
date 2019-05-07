
package databas;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public class Chocolate implements Serializable {

    // @Basic(fetch=LAZY)
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional=false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long chocolateId;
    private String name;
    private double price;
    private String description;
    private String brand;
    private int inStock;
    private int amount;
    private String inStockMessage = "";
    String pictureName;
    
    
    public Chocolate (){}
    
    public Chocolate(String name, double price, int inStock) {
        this.name = name;
        this.price = price;
        this.inStock = inStock;
       
    }

    public Chocolate(String name, double price, String description, String brand, int inStock, String inStockMessage, String pictureName) {
        this.name = name;
        this.price = price;
        this.description = description;
        this.brand = brand;
        this.inStock = inStock;
        this.inStockMessage = inStockMessage;
        this.pictureName = pictureName;
    }

    public String getPictureName() {
        return pictureName;
    }

    public void setPictureName(String pictureName) {
        this.pictureName = pictureName;
    }
    
    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public String getInStockMessage() {
        return inStockMessage;
    }

    public void setInStockMessage(String inStockMessage) {
        this.inStockMessage = inStockMessage;
    }
    
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public int getInStock() {
        return inStock;
    }

    public void setInStock(int inStock) {
        this.inStock = inStock;
    }
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Long getChocolateId() {
        return chocolateId;
    }

    public void setChocolateId(Long id) {
        this.chocolateId = id;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (chocolateId != null ? chocolateId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Chocolate)) {
            return false;
        }
        Chocolate other = (Chocolate) object;
        if ((this.chocolateId == null && other.chocolateId != null) || (this.chocolateId != null && !this.chocolateId.equals(other.chocolateId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "databas.Chocolate[ id=" + chocolateId + " ]";
    }

}
