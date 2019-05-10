package databas;

import javax.ejb.Stateless;
import javax.ejb.LocalBean;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

@Stateless
@LocalBean
public class LoginBean {

    @PersistenceContext(unitName = "FancyChocolateWebShop-ejbPU")
    private EntityManager em;

    public Person verifyLogin(String username, String password) {
        Person user = null;
        try {
            Query q = em.createQuery("SELECT o FROM Person o WHERE o.userName =:username"
                    + " and o.password =:password");
            q.setParameter("username", username);
            q.setParameter("password", password);
            user = (Person) q.getSingleResult();

        } catch (NoResultException e) {
            e.printStackTrace();
            return user;
        }
        return user;
    }
}
