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
    
    
    
    /**
     * Creates a new instance of marcusController
     */
//    public marcusController() {
//    }
    
    public marcusController(){
        
        boolean testaDatabas=true;
        //if(!testaDatabas){
        System.out.println("test2");
        //ProductList = new ArrayList();
        ChokladProdukt ck1 = new ChokladProdukt("\"marabo\"",19.99, 1);
        ChokladProdukt ck2 = new ChokladProdukt("\"chokladsvan\"",399, 2);
        ChokladProdukt ck3 = new ChokladProdukt("\"chokladkex\"",4200, 3);
        ProductList.add(ck1);
        ProductList.add(ck2);
        ProductList.add(ck3);
        
        //System.out.println(chocolateSessionBean.TestMetod2());
        
        //System.out.println(chocolateSessionBean.testar3());
        //ProductList2 = chocolateSessionBean.getChocolateObjects();
        System.out.println("har skriver marcusConstroller ut productlist2");
            System.out.println(ProductList2);
        //}
        //else{
           // ProductList=chocolateSessionBean.getChocolateObjects();
                    //ChocolateSessionBean.getChocolateObjects();//getChocolateObjects
        //}
        
    }

    public ArrayList<Chocolate> getProductList2() {
        ProductList2 = chocolateSessionBean.getChocolateObjects();
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

   
    
    
}
