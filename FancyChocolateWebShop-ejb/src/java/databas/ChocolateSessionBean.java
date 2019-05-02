
package databas;

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
        Chocolate c = new Chocolate();
        c.setName("Mjölkchoklad");
        c.setPrice(10);
        c.setDescription("Choklad som smakar kola. Jippiie!");
        c.setBrand("Marabou");
        c.setInStock(23);
        
        
        try{
            Query q = em.createQuery("select o from Chocolate o");
            int size = q.getResultList().size();
            System.out.println("Storleken ar " + size);
            
            em.persist(c);
            
            size = q.getResultList().size();
            System.out.println("Storleken ar " + size);
        }
        catch(Exception e){
            e.printStackTrace();
        }
        
    }
    
    
    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
}
