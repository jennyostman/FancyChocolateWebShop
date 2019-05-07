/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testMarcus;

import databas.Chocolate;
import databas.ChocolateSessionBean;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.LinkedList;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.validator.ValidatorException;

/**
 *
 * @author marcu
 */
@Named(value = "marcusController")
@SessionScoped
public class marcusController implements Serializable {

    @EJB
    private ChocolateSessionBean chocolateSessionBean;
    

    private ArrayList<ChokladProdukt> ProductList = new ArrayList();
    
    private ArrayList<Chocolate> ProductList2 = new ArrayList();
    
    private  String sokTerm;
    
    private boolean dontrefresh=false;
    
    private boolean visaPopup = false;
    
    private Chocolate markeradChoklad;
    
    private int antalAttKopa;
    
    
    
    
    
    public marcusController(){
        
    //obs obs  allt nedan ar gammal kod som inte langre anvands, vi behover inte dessa objekt
    //har kvar koden for testsyfte//marcus
//        System.out.println("test2");
//        ChokladProdukt ck1 = new ChokladProdukt("\"marabo\"",19.99, 1);
//        ChokladProdukt ck2 = new ChokladProdukt("\"chokladsvan\"",399, 2);
//        ChokladProdukt ck3 = new ChokladProdukt("\"chokladkex\"",4200, 3);
//        ProductList.add(ck1);
//        ProductList.add(ck2);
//        ProductList.add(ck3);
        
        //System.out.println(chocolateSessionBean.TestMetod2());
        
        //System.out.println(chocolateSessionBean.testar3());
        //ProductList2 = chocolateSessionBean.getChocolateObjects();
        System.out.println("har skriver marcusConstroller ut productlist2");
       //     System.out.println(ProductList2);
        //}
        //else{
           // ProductList=chocolateSessionBean.getChocolateObjects();
                    //ChocolateSessionBean.getChocolateObjects();//getChocolateObjects
        //}
        
    }
    
    public void kop(){
        
         String mes = "Du vill kopa " + antalAttKopa + " antal av chockladen " + markeradChoklad.getName() + ".";
        System.out.println(mes);
        antalAttKopa=0;
        
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
    
    public void sok(){
        System.out.println("soktermen ar " + sokTerm);
        ProductList2 = chocolateSessionBean.getSpecificChocolate(sokTerm);
    }

    public String getSokTerm() {
        return sokTerm;
    }

    public void reset(){
        System.out.println("OBS OBS REFRESH HIT!");
        dontrefresh=false;
    }
    public void setSokTerm(String sokTerm) {
        //System.out.println("setsokterm kallades, soktermen ar " + sokTerm);
        
        this.sokTerm = sokTerm;
    }
    
    public void testaOmSokt(){
        System.out.println("Nu soktes definitivt fel metod");
    }

    public Chocolate getMarkeradChoklad() {
        return markeradChoklad;
    }
    

    public void setMarkeradChoklad(Chocolate markeradChoklad) {
        this.markeradChoklad = markeradChoklad;
    }

    
    
    public ArrayList<Chocolate> getProductList2() {
        //System.out.println("getProductList2() har tillkallats");
        if(!dontrefresh){
        ProductList2 = chocolateSessionBean.getChocolateObjects();
        }
        dontrefresh=true;
        return ProductList2;
    }
    

    public void setProductList2(ArrayList<Chocolate> ProductList2) {
        this.ProductList2 = ProductList2;
    }
    
    

    public ArrayList<ChokladProdukt> getProductList() {
        return ProductList;
    }

    public void setProductList(ArrayList<ChokladProdukt> ProductList) {
        this.ProductList = ProductList;
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

    
   
    
    
}
