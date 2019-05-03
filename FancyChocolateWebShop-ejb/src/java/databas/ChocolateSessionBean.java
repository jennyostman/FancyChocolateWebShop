
package databas;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.ejb.Stateful;
import javax.ejb.LocalBean;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.NonUniqueResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;


@Stateful
@LocalBean
public class ChocolateSessionBean {

    @PersistenceContext(unitName = "FancyChocolateWebShop-ejbPU")
    private EntityManager em;

    protected EntityManager getEm() {
        return em;
    }
    
    public void persist(Object object) {
        em.persist(object);
    }

    
    public void saveChocolate(){
        Chocolate c1 = new Chocolate("Mjölkchoklad2", 10, "Choklad som smakar kola. Jippiie!", "Marabou", 23);
        Chocolate c2 = new Chocolate("Mandelkross", 20, "Äntligen mandelkross!", "Marabou", 15);
        Person p1 = new Person("Anna Panna", "ap", "ap", "Annavägen 12", false, true);
        Orders or1 = new Orders(p1);
        OrderDetails o1 = new OrderDetails(3, c1, or1);
        
        try{
            Query q = em.createQuery("select o from Chocolate o");
            int size = q.getResultList().size();
            System.out.println("Storleken ar " + size);
            
            em.persist(c1);
            em.persist(c2);
            em.persist(o1);
            em.persist(p1);
            em.persist(or1);
            
            size = q.getResultList().size();
            System.out.println("Storleken ar " + size);
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
    
    
    //OBS OBS OBS NEDAN AR FEL DU HAR EJ GJORT HOGERKLICKA OCH LAGG TILL RATT METOD
    public ArrayList getChocolateObjects() {
        try{
            System.out.println("getChocolateObjects() tillkallas har");
        Query query = em.createQuery("select o from Chocolate o");
        
        List<Chocolate> list = query.getResultList();
            System.out.println("here is list");
            System.out.println(list);
        ArrayList list2 = new ArrayList(list);
            System.out.println("here is list2");
            System.out.println(list2);
        
        return list2;
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return null;
    }
    
    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")

    public String TestMetod2() {
        return "testMetod tillkallad korrekt!";
    }

    public String testar3() {
        return "testar03 marcus";
    }

    public ArrayList getSpecificChocolate(String chocolateName) {
        try{
            System.out.println("getspecifik chocolate tillkallad med variabeln " + chocolateName);
            String temp = "SELECT o FROM Chocolate o WHERE o.name like '" + chocolateName + "'";
            Query query = em.createQuery(temp);
            
            //obs obs borde anvanda det nedan men det fungerade ej... /marcus
            //Query query = em.createQuery("SELECT o FROM Chocolate o WHERE o.name like :chocolateName");
            //query.setParameter("\'chocolateName\'", chocolateName);
            
            
        List<Chocolate> list = query.getResultList();
        ArrayList list2 = new ArrayList(list);
            
        System.out.println("here is the found list");
        System.out.println(list2);
        return list2;
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return null;
    }
    
    
}
