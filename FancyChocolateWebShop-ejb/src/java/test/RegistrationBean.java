package test;

import javax.ejb.Stateless;
import javax.ejb.LocalBean;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.NonUniqueResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;


@Stateless
@LocalBean
public class RegistrationBean {

    @PersistenceContext(unitName = "")
    private EntityManager em;
    /* 
        Metoden ska söka i databasen om det finns en person med ett visst username
        Metoden ska sedan användas i en annan metod registerUser.
    */
    
    public void persist(Object object) {
        em.persist(object);
    }
    
    
    public void findByUsername(String username) {
        // Customer user = new Customer();  byt ut med customer entity
        try {
            Query q = em
                    .createQuery("SELECT o FROM Customer o WHERE o.username =:username");
            q.setParameter("username", username);
           // user = (Customer) q.getSingleResult(); byt ut med customer entity
           
        } catch (NonUniqueResultException e) {
            e.printStackTrace();
        }
    //    return user;
    
    }
    
    // ska return true/false om det går att regga eller inte
    public void registerUser(String username,String password,String firstName,String lastName,String adress){
        
      /*if(findByUsername(username == null)){
            Customer c = new Customer(username,password,firstName,lastName,adress);
            persist(c);
            return true;
        }
        else{
            return false
        }*/
    }
    
}
