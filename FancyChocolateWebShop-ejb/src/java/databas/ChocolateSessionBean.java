
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

    public void fillDB() {
        Query q = em.createQuery("select o from Chocolate o");
        int size = q.getResultList().size();
        if (size < 1) {

            Chocolate c1 = new Chocolate("Le Grand Louis XVI", 8616, " The dark chocolates with 99% cocoa", "Debauve and Gallais", 20);
            Chocolate c2 = new Chocolate("Wispa Gold", 15316.39, "Chocolate is wrapped in an edible gold leaf", "Cadbury", 5);
            Chocolate c3 = new Chocolate("Chocopologie Chocolate Truffle", 24895.31, "Dark chocolate, ganache, and French Perigord truffle", "Knipschildt", 5);
            Chocolate c4 = new Chocolate("Flavored Truffles", 938.06, "Plain dark chocolate, black currant, caramell toffee ", "La Maison du Chocolat", 20);
            Chocolate c5 = new Chocolate("Boite Maison", 1856.89, "Selection of 93 ganaches,pralines and dark chocolate truffles", "La Maison du Chocolat", 15);
            Chocolate c6 = new Chocolate("Sweet Surprise Tower", 899.58, "Creamy milk chocolates and luscious chocolate truffles", "Godiva", 30);
            Chocolate c7 = new Chocolate("Milk Chocolate Dipped Strawberies", 765, "12 sweet strawberries covered in smooth milk chocolate ", "Godiva", 30);
            Chocolate c8 = new Chocolate("Chocolate Pearls", 449.80, " Dark Chocolate Pearls 55%, Dark Chocolate Crunchy Pearls 55%, CARAMÉLIA 36% Crunchy Pearls.", "Valrhona", 40);
            Chocolate c9 = new Chocolate("Coffret Selection", 525.45, "An assortment of almonds and hazelnuts coated in milk chocolate", "Valrhona", 35);
            Chocolate c10 = new Chocolate("Tosca", 567.25, "A box with 7 delightful artisan chocolates, the best southern European almonds covered in chocolate", "Puccini bomboni", 10);

            Person p1 = new Person("Alice Svensson", "Alice", "Alice123", "Annavägen 12", false, false);
            Person p2 = new Person("Maja Adolfsson", "Maja", "Maja123", "Majavägen 10", false, false);
            Person p3 = new Person("Ella Asplund", "Ella", "Ella123", "Ellavägen 5", false, false);
            Person p4 = new Person("Olivia Bauer", "Olivia", "Olivia123", "Oliviavägen 3", false, false);
            Person p5 = new Person("Jenny Svensson", "Jenny", "Jenny123", "Jennyvägen 1", true, false);
            Person p6 = new Person("Leo Messi", "Messi", "Leo123", "Leovägen 3", false, false);
            Person p7 = new Person("Gabriel Agrell", "Gabriel", "Gabriel123", "Gabrielvägen 3", false, false);
            Person p8 = new Person("Elton John", "Elton", "Elton123", "Eltonvägen 3", false, false);
            Person p9 = new Person("Lady Gaga", "Lady", "Lady123", "Ladyvägen 1", false, false);
            Person p10 = new Person("Taylor Swift", "Taylor", "Taylor123", "Taylorvägen 1", false, false);

            Orders or1 = new Orders(p1);
            Orders or2 = new Orders(p2);
            Orders or3 = new Orders(p10);
            Orders or4 = new Orders(p8);
            
            OrderDetails od1 = new OrderDetails(3, c1, or1);
            OrderDetails od2 = new OrderDetails(3, c8, or2);
            OrderDetails od3 = new OrderDetails(3, c2, or3);
            OrderDetails od4 = new OrderDetails(1, c3, or4);

            try {
                em.persist(c1);
                em.persist(c2);
                em.persist(c3);
                em.persist(c4);
                em.persist(c5);
                em.persist(c6);
                em.persist(c7);
                em.persist(c8);
                em.persist(c9);
                em.persist(c10);

                

                em.persist(p1);
                em.persist(p2);
                em.persist(p3);
                em.persist(p4);
                em.persist(p5);
                em.persist(p6);
                em.persist(p7);
                em.persist(p8);
                em.persist(p9);
                em.persist(p10);
                
                em.persist(or1);
                em.persist(or2);
                em.persist(or3);
                em.persist(or4);
                
                em.persist(od1);
                em.persist(od2);
                em.persist(od3);
                em.persist(od4);

            } catch (Exception e) {
                e.printStackTrace();
            }

        }

    }
}

// Add business logic below. (Right-click in editor and choose
// "Insert Code > Add Business Method")

