
package test;

import java.util.ArrayList;
import java.util.List;


public class CartDbStandIn {
    
private String chocolateName, pictureName;
    private float price;
    private int amount;
    private List<CartDbStandIn> cartContent = null;
    
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

    public List<CartDbStandIn> getCartContent() {
        return cartContent;
    }

    public void setCartContent(List<CartDbStandIn> cartContent) {
        this.cartContent = cartContent;
    }
    
    // Att labba med tills vidare:
    public List<CartDbStandIn> createCartObjects(){
        cartContent = new ArrayList(){};
        cartContent.add(new CartDbStandIn("Grand-Cru-by-Pierre-Marcolni-1.jpg", "Grand Cru by Pierre Marcolni", 102.50f, 3));
        cartContent.add(new CartDbStandIn("Richart-Chocolate.jpg", 
                "Richart Chocolate", 115.0f, 10));
        cartContent.add(new CartDbStandIn("Chocolates-with-Edible-Gold-by-DeLafee.jpg", 
                "Chocolates with Edible Gold by DeLafee", 508.0f, 1));
        // this.cartContent = cartContent;
        return cartContent;
    }
    
    
    
    public boolean deleteFromCart(CartDbStandIn chocolateObj, List<CartDbStandIn> cart){
        boolean delete = false;
        int size = cart.size();
        cart.remove(chocolateObj);
        // Koll om något tagits bort
        if(size > cart.size()){
            delete = true;
        }
        return delete;
    }
}
