
package test;

import java.util.ArrayList;
import java.util.List;


public class CartDbStandIn2 {
    
private String chocolateName, pictureName;
    private double price;
    private int amount;
    private List<CartDbStandIn2> cartContent = null;
    private int inStock;
    private String inStockMessage = "";
    
    public CartDbStandIn2(){}
    
    public CartDbStandIn2(String pictureName, String name, double price, int amount, int inStock) {
        this.chocolateName = name;
        this.pictureName = pictureName;
        this.price = price;
        this.amount = amount;
        this.inStock = inStock;
    }

    public String getInStockMessage() {
        return inStockMessage;
    }

    public void setInStockMessage(String inStockMessage) {
        this.inStockMessage = inStockMessage;
    }
    
    public int getInStock() {
        return inStock;
    }

    public void setInStock(int inStock) {
        this.inStock = inStock;
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

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
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
        cartContent.add(new CartDbStandIn2("Grand-Cru-by-Pierre-Marcolni-1.jpg", "Grand Cru by Pierre Marcolni", 102.50, 3, 10));
        cartContent.add(new CartDbStandIn2("Richart-Chocolate.jpg", 
                "Richart Chocolate", 115.0, 10, 20));
        cartContent.add(new CartDbStandIn2("Chocolates-with-Edible-Gold-by-DeLafee.jpg", 
                "Chocolates with Edible Gold by DeLafee", 508.0, 1, 30));
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
    
}
