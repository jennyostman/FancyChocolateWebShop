package databas;

import javax.ejb.Stateless;
import javax.ejb.LocalBean;
import javax.persistence.EntityManager;
import javax.persistence.NonUniqueResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

@Stateless
@LocalBean
public class LoginBean {
    @PersistenceContext(unitName = "FancyChocolateWebShop-ejbPU")
    private EntityManager em;
    Person user;
    
    public boolean verifyLogin(String username, String password){
        try {
            Query q = em
                    .createQuery("SELECT o FROM Person o WHERE o.username =:username");
            q.setParameter("username", username);
           user = (Person) q.getSingleResult(); //byt ut med customer entity

        } catch (NonUniqueResultException e) {
            e.printStackTrace();
        }
        return user.getPassword().equals(password);
    }
    
    
}
