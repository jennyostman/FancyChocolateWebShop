/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package databasKontakt;

import javax.ejb.Stateful;
import javax.ejb.LocalBean;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author marcu
 */
@Stateful
@LocalBean
public class SessionBean {
    
    
                                  
    @PersistenceContext(unitName = "FancyChocolateWebShop-ejbPU")
    private EntityManager em;

    public void persist(Object object) {
        System.out.println("du kom till metoden persist");
        em.persist(object);
    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")

    public boolean LaggTillChoklad() {
        System.out.println("test2");
        boolean gickDet = true;
        
        //Choklad k = new Choklad("hej",1,2);
        Choklad k = new Choklad("choklad1", 0, "beskrivning", "marke", 0);
        //Kund kund = new Kund();
        //k.setNamn("Choklad1");
        try{
            System.out.println("laggTillChoklad forsoker");
            //persist(kund);
            persist(k);
            System.out.println("laggtillchoklad har lyckats");
        }
        catch(Exception e){
            System.out.println("lagg till choklad failade");
            e.printStackTrace();
            gickDet=false;
        }
      //  persist(k);
        return gickDet;
    }
    
    
}
