package test;

import javax.ejb.Stateless;
import javax.ejb.LocalBean;
import javax.persistence.EntityManager;
import javax.persistence.NonUniqueResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

@Stateless
@LocalBean
public class LoginBean {
    @PersistenceContext(unitName = "")
    private EntityManager em;
    
    public void verifyLogin(String username, String password){
        try {
            Query q = em
                    .createQuery("SELECT o FROM Customer o WHERE o.username =:username");
            q.setParameter("username", username);
           // user = (PersonReal) q.getSingleResult(); byt ut med customer entity
           
        } catch (NonUniqueResultException e) {
            e.printStackTrace();
        }
    }
    
    
}
