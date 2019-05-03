
package databas;

import java.util.List;
import javax.ejb.Stateful;
import javax.ejb.LocalBean;
import javax.persistence.EntityManager;
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
        Chocolate c1 = new Chocolate("Mjölkchoklad", 10, "Choklad som smakar kola. Jippiie!", "Marabou", 23);
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
    
    
    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")

    public List getAllCustomersForAdmin() {
        
        List customers = null;
        
        try{
            Query q = em.createQuery("select o from Person o");
            customers = q.getResultList();
        }catch(Exception e){
            e.printStackTrace();
        }
        return customers;
    }
}
