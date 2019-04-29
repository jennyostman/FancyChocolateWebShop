
package test;

import java.util.ArrayList;
import java.util.List;


public class CartDbStandIn2 {
    
private String chocolateName, pictureName;
    private float price;
    private int amount;
    private List<CartDbStandIn2> cartContent = null;
    
    public CartDbStandIn2(){}
    
    public CartDbStandIn2(String pictureName, String name, float price, int amount) {
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

    public List<CartDbStandIn2> getCartContent() {
        return cartContent;
    }

    public void setCartContent(List<CartDbStandIn2> cartContent) {
        this.cartContent = cartContent;
    }
    
    // Att labba med tills vidare:
    public List<CartDbStandIn2> createCartObjects(){
        cartContent = new ArrayList(){};
        cartContent.add(new CartDbStandIn2("Grand-Cru-by-Pierre-Marcolni-1.jpg", "Grand Cru by Pierre Marcolni", 102.50f, 3));
        cartContent.add(new CartDbStandIn2("Richart-Chocolate.jpg", 
                "Richart Chocolate", 115.0f, 10));
        cartContent.add(new CartDbStandIn2("Chocolates-with-Edible-Gold-by-DeLafee.jpg", 
                "Chocolates with Edible Gold by DeLafee", 508.0f, 1));
        // this.cartContent = cartContent;
        return cartContent;
    }
    
    
    
    public boolean deleteFromCart(CartDbStandIn2 chocolateObj, List<CartDbStandIn2> cart){
        boolean delete = false;
        int size = cart.size();
        cart.remove(chocolateObj);
        // Koll om något tagits bort
        if(size > cart.size()){
            delete = true;
        }
        return delete;
    }
    
//    public boolean updateAmountInCart(CartDbStandIn2 chocolateObj, List<CartDbStandIn2> cart){
//        boolean delete = false;
//        int oldAmount = chocolateObj.getAmount();
//        cart.remove(chocolateObj);
//        // Koll om något tagits bort
//        if(size > cart.size()){
//            delete = true;
//        }
//        return delete;
//    }
}
