/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testMarcus;

import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.LinkedList;

/**
 *
 * @author marcu
 */
@Named(value = "marcusController")
@SessionScoped
public class marcusController implements Serializable {

    private ArrayList<ChokladProdukt> ProductList = new ArrayList();
    
    /**
     * Creates a new instance of marcusController
     */
//    public marcusController() {
//    }
    
    public marcusController(){
        System.out.println("test2");
        //ProductList = new ArrayList();
        ChokladProdukt ck1 = new ChokladProdukt("\"marabo\"",19.99, 1);
        ChokladProdukt ck2 = new ChokladProdukt("\"chokladsvan\"",399, 2);
        ChokladProdukt ck3 = new ChokladProdukt("\"chokladkex\"",4200, 3);
        ProductList.add(ck1);
        ProductList.add(ck2);
        ProductList.add(ck3);
        
    }

    public ArrayList<ChokladProdukt> getProductList() {
        return ProductList;
    }

    public void setProductList(ArrayList<ChokladProdukt> ProductList) {
        this.ProductList = ProductList;
    }

   
    
    
}
