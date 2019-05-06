
package test;

import databas.ChocolateSessionBean;
import javax.inject.Named;

import java.io.Serializable;
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
    
    // Behöver inte skötas av SessionBean. Pga innan cart sparats i db.
    public void removeProduct(CartDbStandIn2 chocolateObj){
        cartContent.remove(chocolateObj);
    }
    
    // Lägg till att kolla om amvändaren är premiumkund, i så fall ska den få rabatt
    public double countTotalAmount(){
        double totAmount = 0;
        for (CartDbStandIn2 c : cartContent){
            double oneProduct = c.getPrice() * c.getAmount();
            totAmount += oneProduct;
        }
        return totAmount;
    }
    
    
    public void buyProducts(){
        // Kolla om produkterna finns i lager.
        boolean allInStock = true;
        // Varje chokladObj håller info om vad som finns i lager, men man måste göra en till koll
        // när beställningen görs, så att det fortfarande stämmer.
        for (int i = 0; i < cartContent.size(); i++) {
            // Det uppdaterade inStock-värdet
            // int amountInStockFromDB = chocolateSessionBean.amountOfChocolateInStock(cartContent.get(i));
            int amountInStockFromDB = 10;   // Testvärde
            // Uppdatera objektets inStock-värde
            cartContent.get(i).setInStock(amountInStockFromDB);
            
            // Kolla om kunden beställt mer av en vara än vad som finns i db.
            // Lägg till meddelande till kunden på respektive objekt
            if (cartContent.get(i).getAmount() > amountInStockFromDB){
                allInStock = false;
                // Uppdatera InStockMessage på objektet
                cartContent.get(i).setInStockMessage("Har för få i lager");
                // cartContent.get(i).setInStockMessage("Vi har bara " + cartContent.get(i).getInStock() + " stycken " + cartContent.get(i).getChocolateName());
            }
            else if (cartContent.get(i).getAmount() <= amountInStockFromDB) {
                // Här behövs inget meddelande
                cartContent.get(i).setInStockMessage("");
            }              
        }        
        
        // Bara om allt som beställts finns i lager körs nedanstående
        if (allInStock){
            setInStockMessage("Allt fanns i db");
            // Skapa en orderDetails
        
            // Skapa en orderist
        
            // Lägg till order id i kundens lista
            
        }   
    }
}
