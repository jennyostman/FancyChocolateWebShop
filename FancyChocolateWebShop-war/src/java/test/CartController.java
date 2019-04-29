
package test;

import javax.inject.Named;

import java.io.Serializable;
import java.util.List;
import javax.enterprise.context.SessionScoped;
import javax.faces.component.UIGraphic;
import javax.faces.event.PhaseEvent;


@Named(value = "cartController")
@SessionScoped
public class CartController implements Serializable {

    UIGraphic picture;
    private String chocolateName, pictureName;
    private float price;
    private int amount;
    private List<CartDbStandIn2> cartContent = null;
    private boolean deleted = false;
    // Kvar: update row in JSF dataTable
    // Kvar: delete row/object in JSF dataTable
    // Kvar: att visa summan
    // Kvar: Att visa summan om man har rabatt

    /*
    Innehållet i kundvagnen sparas inte till db förrän man lägger en order i köp.
    Om listan ligger i controllerklassen (här) så blir det inte MVC, för då
    blir det logik här för att hantera listan.
    */
    
    
    public CartController() {
        CartDbStandIn2 c = new CartDbStandIn2();
        cartContent = c.createCartObjects();
//        cartContent = new ArrayList() {
//        };
//        cartContent.add(new CartDbStandIn("Grand-Cru-by-Pierre-Marcolni-1.jpg", "Grand Cru by Pierre Marcolni", 102.50f, 3));
//        cartContent.add(new CartDbStandIn("Richart-Chocolate.jpg", "Richart Chocolate", 115.0f, 10));
//        cartContent.add(new CartDbStandIn("Chocolates-with-Edible-Gold-by-DeLafee.jpg", "Chocolates with Edible Gold by DeLafee", 508.0f, 1));
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

    public void phaseListener(PhaseEvent e){
		System.out.println(e);
	}
    
//    public void updateAmount(CartDbStandIn2 chocolateObj){
//        CartDbStandIn2 c = new CartDbStandIn2();
//        deleted = c.updateAmountInCart(chocolateObj, cartContent);
//    }
    
    public void removeProduct(CartDbStandIn2 chocolateObj){
        CartDbStandIn2 c = new CartDbStandIn2();
        deleted = c.deleteFromCart(chocolateObj, cartContent);
    }
    
}
