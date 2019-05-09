
package test;

import databas.Chocolate;
import databas.ChocolateSessionBean;
import databas.Person;
import javax.inject.Named;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIGraphic;
import javax.faces.context.FacesContext;


@Named(value = "cartController")
@SessionScoped
public class CartController implements Serializable {

    @EJB
    private ChocolateSessionBean chocolateSessionBean;

    UIGraphic picture;
    private String chocolateName, pictureName;
    private float price;
    private int amount;
    private List<Chocolate> cartContent;
    private boolean deleted = false;
    private int inStock;
    private String inStockMessage = "";
    
    private List<Chocolate> ProductList;
    private  String sokTerm;
    private boolean dontrefresh=false;
    private boolean visaPopup = false;
    private Chocolate markeradChoklad;
    private int antalAttKopa;
    // private ArrayList<Chocolate> kundvagnsLista;
    

    // Avrunda så att totalpriset aldrig kan ha mer än två decimaler
    // Dölja rabatt-raden i Cart om personen inte är premium
    // Kvar: Hämta en riktig cartContent. 
    // Kvar: Se till att man inte kan beställa -3 varor. Och ev ge fina felmeddelanden för 0.2 eller a.
    // Snygga till lite med visningen av priset
    
    
    public CartController() { 
    }

    
    
    public void sok(){
        System.out.println("soktermen ar " + sokTerm);
        ProductList = chocolateSessionBean.getSpecificChocolate(sokTerm);
    }
    
    public void reset(){
        System.out.println("OBS OBS REFRESH HIT!");
        dontrefresh=false;
    }
    
    public void testaOmSokt(){
        System.out.println("Nu soktes definitivt fel metod");
    }
    
    
    
    // Metod som lägger till valda choklad-produkter i kundvagnslistan
    public void kop(Chocolate c){
        //obs obs, denna metod ska ocksa tillkallas med ett antal
        //antalet av chokladen man koper
        //dop den variabeln till "mangd"
        //sa funkar det bortkommenterade nedan
          String mes = "Du har köpt " + antalAttKopa + " antal av chockladen " + markeradChoklad.getName() + "!";
        FacesMessage fm = new FacesMessage(FacesMessage.SEVERITY_INFO,
                mes, null);
        FacesContext.getCurrentInstance().addMessage("guessForm:gText", fm);
       
        System.out.println(mes);
        antalAttKopa=0;
        if(cartContent==null || cartContent.size()==0){
            cartContent = new ArrayList();
        }
//        boolean finnsredan=false;
//        for(Chocolate cho: cartContent){
//            if(cho.getChocolateId()==c.getChocolateId()){
//                finnsredan=true;
//                c.amount+=mangd;
//            }
//        }
//        if(!finnsredan)
        cartContent.add(c);
        
        System.out.println(cartContent);
        
//        String messageText = mes;
//              throw new ValidatorException(new FacesMessage(FacesMessage.SEVERITY_ERROR,
//                  messageText, messageText));
             
    }
    
    
    public void skickaChoklad(Chocolate ck){
        setMarkeradChoklad(ck);
        setVisaPopup(true);
    }
    
    public void stangChokladRuta(){
        setMarkeradChoklad(null);
        setVisaPopup(false);
        System.out.println("test03");
    }
    

    // Produkt/chokladobj tas bort ur kundvagnslistan
    public void removeProduct(Chocolate chocolateObj){
        cartContent.remove(chocolateObj);
    }    
    
    public double countTotalAmount(){
        double totAmount = 0;
        for (Chocolate c : cartContent){
            double oneProduct = c.getPrice() * c.getAmount();
            totAmount += oneProduct;
        }
        return totAmount;
    }
    
    // Om kunden inte är premiumkund blir priser med rabatt samma som det vanliga priset.
    public double countPremiumCustomerPrice(Person person){
        double premiumPrice = countTotalAmount();
        if (person.isPremium()){
            premiumPrice = premiumPrice * 0.9;
        }
        return premiumPrice;
    }
    
    
    public void buyProducts(Person person){
        // Kolla om produkterna finns i lager.
        boolean allInStock = true;
        for (int i = 0; i < cartContent.size(); i++) {
            // Det uppdaterade inStock-värdet
            System.out.println(" JENNY - kolla inStock ");
            int amountInStockFromDB = chocolateSessionBean.amountOfChocolateInStock(cartContent.get(i));
            // int amountInStockFromDB = 10;   // Testvärde
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
            // Spara kostnad + vad kunden betalat. Behövs på adminsidan.
        
            // Skapa en orderist
        
            // Lägg till order id i kundens lista
            
        }   
    }
    

    public List<Chocolate> getProductList() {
        if(!dontrefresh){
            // ProductList = new ArrayList<>();
            ProductList = chocolateSessionBean.getChocolateObjects();
        
        }
        dontrefresh=true;
        return ProductList;
    }

    public Chocolate getMarkeradChoklad() {
        return markeradChoklad;
    }
    

    public void setMarkeradChoklad(Chocolate markeradChoklad) {
        this.markeradChoklad = markeradChoklad;
    }

    public int getAntalAttKopa() {
        return antalAttKopa;
    }

    public void setAntalAttKopa(int antalAttKopa) {
        this.antalAttKopa = antalAttKopa;
    }

    public void skrivUtKunder(){
        chocolateSessionBean.marcusGetKunder();
    }
    
    public boolean showPopup(){
        return true;
    }
    
    public boolean hidePopup(){
        return false;
    }

    public boolean isVisaPopup() {
        return visaPopup;
    }

    public void setVisaPopup(boolean visaPopup) {
        
        System.out.println("visapopup = " + visaPopup);
        this.visaPopup = visaPopup;
    }

//    public ArrayList<Chocolate> getKundvagnsLista() {
//        return kundvagnsLista;
//    }
//
//    public void setKundvagnsLista(ArrayList<Chocolate> kundvagnsLista) {
//        this.kundvagnsLista = kundvagnsLista;
//    }
    
    public ChocolateSessionBean getChocolateSessionBean() {
        return chocolateSessionBean;
    }

    public void setChocolateSessionBean(ChocolateSessionBean chocolateSessionBean) {
        this.chocolateSessionBean = chocolateSessionBean;
    }
    
    public String getSokTerm() {
        return sokTerm;
    }

    public void setSokTerm(String sokTerm) {
        this.sokTerm = sokTerm;
    }

    public boolean isDontrefresh() {
        return dontrefresh;
    }

    public void setDontrefresh(boolean dontrefresh) {
        this.dontrefresh = dontrefresh;
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

    public List<Chocolate> getCartContent() {
        return cartContent;
    }

    public void setCartContent(List<Chocolate> cartContent) {
        this.cartContent = cartContent;
    }
}
