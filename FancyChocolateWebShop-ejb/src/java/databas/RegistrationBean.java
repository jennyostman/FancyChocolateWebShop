package databas;

import javax.ejb.Stateless;
import javax.ejb.LocalBean;
import javax.persistence.*;

@Stateless
@LocalBean
public class RegistrationBean {

    @PersistenceContext(unitName = "FancyChocolateWebShop-ejbPU")
    private EntityManager em;
    
    public void persist(Object object) {
        em.persist(object);
    }
    
    public int findByUsername(String username) {
        int a = 0;
        try {
            Query q = em
                    .createQuery("SELECT o FROM Person o WHERE o.userName =:username");
            q.setParameter("username", username);
            a = q.getResultList().size();           
        } catch (NonUniqueResultException e) {
            e.printStackTrace();
        }
        return a;
    }
    
    public boolean registerUser(String name, String username,String password,String adress){
        
      if(findByUsername(username) == 0){
            Person reg = new Person(name,username,password,adress,false,false);
            persist(reg);
            return true;
      }
      return false;
    }
}