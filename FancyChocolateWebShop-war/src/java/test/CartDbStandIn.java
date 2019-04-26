
package test;

import javax.inject.Named;
import javax.enterprise.context.Dependent;


@Named(value = "cartDbStandIn")
@Dependent
public class CartDbStandIn {

private String chocolateName, pictureName;
    private float price;
    private int amount;
    
    
    public CartDbStandIn(){}
    
    public CartDbStandIn(String pictureName, String name, float price, int amount) {
        this.chocolateName = name;
        this.pictureName = pictureName;
        this.price = price;
        this.amount = amount;
    }

    public String getChocolateName() {
        return chocolateName;
    }

    public void setChocolateName(String name) {
        this.chocolateName = name;
    }

    public String getPictureName() {
        return pictureName;
    }

    public void setPictureName(String pictureName) {
        this.pictureName = pictureName;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }
    
}
