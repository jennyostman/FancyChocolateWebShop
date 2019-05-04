
package test;

import databas.Chocolate;
import databas.ChocolateSessionBean;
import javax.inject.Named;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.component.UIGraphic;


@Named(value = "cartController")
@SessionScoped
public class CartController implements Serializable {

    @EJB
    private ChocolateSessionBean chocolateSessionBean;

    UIGraphic picture;
    private String chocolateName, pictureName;
    private float price;
    private int amount;
    private List<CartDbStandIn2> cartContent = null;
    private boolean deleted = false;
    private int inStock;
    private String inStockMessage = "";
    // Kvar: Hämta en riktig cartContent. Ta bort test-carten ur konstruktorn.
    // Kvar: Att visa summan om man har rabatt
    
    
    public CartController() {
        // Här skulle man kunna uppdatera inStock-variabeln på ChocolateObj
        
        CartDbStandIn2 c = new CartDbStandIn2();
        cartContent = c.createCartObjects();
    }

    public String getInStockMessage() {
        return inStockMessage;
    }

    public void setInStockMessage(String inStockMessage) {
        this.inStockMessage = inStockMessage;
    }

    public boolean isDeleted() {
        return deleted;
    }

    public void setDeleted(boolean deleted) {
        this.deleted = deleted;
    }

    public int getInStock() {
        return inStock;
    }

    public void setInStock(int inStock) {
        this.inStock = inStock;
    }

    public UIGraphic getPicture() {
        return picture;
    }

    public void setPicture(UIGraphic picture) {
        this.picture = picture;
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
    
    public void removeProduct(CartDbStandIn2 chocolateObj){
        CartDbStandIn2 c = new CartDbStandIn2();
        deleted = c.deleteFromCart(chocolateObj, cartContent);
    }
    
    // Lägg till att kolla om amvändaren är premiumkund, i så fall ska den få rabatt
    public double countTotalAmount(){
        double totAmount = 0;
        for (CartDbStandIn2 c : cartContent){
            totAmount += c.getPrice();
        }
        return totAmount;
    }
    
    
    public void buyProducts(){
        boolean allInStock = true;
        // Kolla om produkterna finns i lager.
        List<CartDbStandIn2> cartFromWeb = cartContent;
        List<Chocolate> cartFromDb = new ArrayList(){};
        // Varje chokladObj håller info om vad som finns i lager, men man måste göra en till koll
        // när beställningen görs, så att det fortfarande stämmer.
        for (CartDbStandIn2 c : cartContent){
            int amountInStockFromWeb = c.getAmount();
            int amountInStockFromDB = chocolateSessionBean.amountOfChocolateInStock(c);
            if (amountInStockFromWeb > amountInStockFromDB){
                allInStock = false;
                c.setInStockMessage("Vi har bara " + amountInStockFromDB + " stycken " + c.getChocolateName());
            }
        }
        
        // Om inte allt som beställts finns i lager körs inte nedanstående
        if (allInStock){
            setInStockMessage("Köpet är gjort!");
            // Skapa en orderDetails
        
            // Skapa en orderist
        
            // Lägg till order id i kundens lista
        }

        
        
    }
    
}
