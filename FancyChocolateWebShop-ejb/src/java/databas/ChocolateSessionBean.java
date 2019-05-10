package databas;

import java.util.*;
import javax.ejb.*;
import javax.persistence.*;

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
    
    public void merge(Object object){
        em.merge(object);
    }

    public void fillDB() {
        Query q = em.createQuery("select o from Chocolate o");
        int size = q.getResultList().size();
        if (size < 1) {
            Chocolate c1 = new Chocolate("Le Grand Louis XVI", 8616, " The dark chocolates with 99% cocoa", "Debauve and Gallais", 20, 0, "", false, "Le-Grand-Louis-XVI.jpg");
            Chocolate c2 = new Chocolate("Wispa Gold", 15316.39, "Chocolate is wrapped in an edible gold leaf", "Cadbury", 5, 0, "", false, "Wispa-gold.jpg");
            Chocolate c3 = new Chocolate("Chocopologie Chocolate Truffle", 24895.31, "Dark chocolate, ganache, and French Perigord truffle", "Knipschildt", 5, 0, "", false, "Chocopologie-Chocolate-Truffle.jpg");
            Chocolate c4 = new Chocolate("Flavored Truffles", 938.06, "Plain dark chocolate, black currant, caramell toffee ", "La Maison du Chocolat", 20, 0, "", false, "Amedei-Toscano-Black-Truffles-in-Swarovski-Chocolate-Box.jpg");
            Chocolate c5 = new Chocolate("Boite Maison", 1856.89, "Selection of 93 ganaches,pralines and dark chocolate truffles", "La Maison du Chocolat", 15, 0, "", false, "Grand-Cru-by-Pierre-Marcolni-1.jpg");
            Chocolate c6 = new Chocolate("Sweet Surprise Tower", 899.58, "Creamy milk chocolates and luscious chocolate truffles", "Godiva", 30, 0, "", false, "Richart-Chocolate.jpg");
            Chocolate c7 = new Chocolate("Milk Chocolate Dipped Strawberies", 765, "12 sweet strawberries covered in smooth milk chocolate ", "Godiva", 30, 0, "", false, "Voges-Haut.jpg");
            Chocolate c8 = new Chocolate("Chocolate Pearls", 449.80, " Dark Chocolate Pearls 55%, Dark Chocolate Crunchy Pearls 55%, CARAMÉLIA 36% Crunchy Pearls.", "Valrhona", 40, 0, "", false, "Chocolates-with-Edible-Gold-by-DeLafee.jpg");
            Chocolate c9 = new Chocolate("Coffret Selection", 525.45, "An assortment of almonds and hazelnuts coated in milk chocolate", "Valrhona", 35, 0, "", false, "Amedei-Porcelana.jpg");
            Chocolate c10 = new Chocolate("Tosca", 567.25, "A box with 7 delightful artisan chocolates, the best southern European almonds covered in chocolate", "Puccini bomboni", 10, 0, "", false, "The-Aficionados-Collection.jpg");

            Person p1 = new Person("Alice Svensson", "Alice", "Alice123", "Annavägen 12", false, false);
            Person p2 = new Person("Maja Adolfsson", "Maja", "Maja123", "Majavägen 10", false, false);
            Person p3 = new Person("Ella Asplund", "Ella", "Ella123", "Ellavägen 5", false, false);
            Person p4 = new Person("Olivia Bauer", "Olivia", "Olivia123", "Oliviavägen 3", false, false);
            Person p5 = new Person("Jenny Svensson", "Jenny", "Jenny123", "Jennyvägen 1", true, false);
            Person p6 = new Person("Leo Messi", "Messi", "Leo123", "Leovägen 3", false, false);
            Person p7 = new Person("Gabriel Agrell", "Gabriel", "Gabriel123", "Gabrielvägen 3", false, false);
            Person p8 = new Person("Elton John", "Elton", "Elton123", "Eltonvägen 3", false, true);
            Person p9 = new Person("Lady Gaga", "Lady", "Lady123", "Ladyvägen 1", false, true);
            Person p10 = new Person("Taylor Swift", "Taylor", "Taylor123", "Taylorvägen 1", false, false);
            Person p11 = new Person("Testperson testis", "t", "t", "Testvagen 1", false, false);

            Orders or1 = new Orders(p1);
            Orders or2 = new Orders(p2);
            Orders or3 = new Orders(p10);
            Orders or4 = new Orders(p10);
            Orders or5 = new Orders(p9);
            Orders or6 = new Orders(p9);
            Orders or7 = new Orders(p8);
            Orders or8 = new Orders(p8);
            Orders or9 = new Orders(p6);

            OrderDetails od1 = new OrderDetails(3, c1, or1);
            OrderDetails od2 = new OrderDetails(3, c8, or2);
            OrderDetails od3 = new OrderDetails(3, c2, or3);
            OrderDetails od4 = new OrderDetails(1, c3, or4);
            OrderDetails od5 = new OrderDetails(1, c3, or5);
            OrderDetails od6 = new OrderDetails(2, c1, or5);
            OrderDetails od7 = new OrderDetails(3, c4, or5);
            OrderDetails od8 = new OrderDetails(3, c4, or4);
            OrderDetails od9 = new OrderDetails(3, c1, or4);
            OrderDetails od10 = new OrderDetails(3, c6, or4);
            OrderDetails od11 = new OrderDetails(5, c6, or6);
            OrderDetails od12 = new OrderDetails(9, c1, or6);
            OrderDetails od13 = new OrderDetails(15, c3, or6);
            OrderDetails od14 = new OrderDetails(8, c3, or7);
            OrderDetails od15 = new OrderDetails(6, c8, or7);
            OrderDetails od16 = new OrderDetails(2, c6, or7);
            OrderDetails od17 = new OrderDetails(8, c10, or7);
            OrderDetails od18 = new OrderDetails(12, c3, or8);
            OrderDetails od19 = new OrderDetails(10, c8, or8);
            OrderDetails od20 = new OrderDetails(7, c6, or8);
            OrderDetails od21 = new OrderDetails(8, c10, or8);
            OrderDetails od22 = new OrderDetails(20, c3, or9);
            OrderDetails od23 = new OrderDetails(2, c4, or9);

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
                em.persist(p11);

                em.persist(or1);
                em.persist(or2);
                em.persist(or3);
                em.persist(or4);
                em.persist(or5);
                em.persist(or6);
                em.persist(or7);
                em.persist(or8);
                em.persist(or9);

                em.persist(od1);
                em.persist(od2);
                em.persist(od3);
                em.persist(od4);
                em.persist(od5);
                em.persist(od6);
                em.persist(od7);
                em.persist(od8);
                em.persist(od9);
                em.persist(od10);
                em.persist(od11);
                em.persist(od12);
                em.persist(od13);
                em.persist(od14);
                em.persist(od15);
                em.persist(od16);
                em.persist(od17);
                em.persist(od18);
                em.persist(od19);
                em.persist(od20);
                em.persist(od21);
                em.persist(od22);
                em.persist(od23);

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public ArrayList getChocolateObjects() {
        try {
            Query query = em.createQuery("select o from Chocolate o");
            List<Chocolate> list = query.getResultList();
            ArrayList list2 = new ArrayList(list);
            return list2;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public ArrayList getSpecificChocolate(String chocolateName) {
        try {
            System.out.println("getspecifik chocolate tillkallad med variabeln " + chocolateName);
            String temp = "SELECT o FROM Chocolate o WHERE o.name like '" + chocolateName + "'";
            Query query = em.createQuery(temp);

            List<Chocolate> list = query.getResultList();
            ArrayList list2 = new ArrayList(list);
            return list2;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public ArrayList marcusGetKunder() {
        try {
            Query query = em.createQuery("Select k From Person k");
            List<Person> list2 = query.getResultList();
            ArrayList list3 = new ArrayList(list2);
            return list3;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public int amountOfChocolateInStock(Chocolate chocolate) {
        int inStock = 0;
        Chocolate c = new Chocolate();
        try {
            Query q = em.createQuery("select o from Chocolate o where o.name =:chocolateName");
            q.setParameter("chocolateName", chocolate.getName());
            c = (Chocolate) q.getSingleResult();
            inStock = c.getInStock();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return inStock;
    }

    public ArrayList getAllCustomersForAdmin() {
        ArrayList<Person> customers = null;
        try {
            Query q = em.createQuery("select o from Person o WHERE o.admin = false");
            List<Person> customersTemp = q.getResultList();
            customers = new ArrayList(customersTemp);
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        return customers;
    }

    public Orders createOrderForPerson(Person person) {
        long pid = person.getPersonId();
        String temp = "SELECT o FROM Person o WHERE o.personId = " + pid;

        Query query = em.createQuery(temp);
        List<Person> list = query.getResultList();
        Person p2 = list.get(0);
        
        Orders order = new Orders(p2);
        try {
            Query q = em.createQuery("select o from Orders o");
            int size = q.getResultList().size();
            em.persist(order);

            size = q.getResultList().size();
            return order;
            
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("obs obs createOrderForPerson failade");
        }
        return null;
    }

    public OrderDetails createOrderDetailsForOrder(Orders order, Chocolate chocolate) {
        System.out.println("test3");
        boolean success = false;

        long ood = order.getOrderId();
        String temp = "SELECT o FROM Orders o WHERE o.orderId = " + ood;
        Query query = em.createQuery(temp);
        List<Orders> list = query.getResultList();
        Orders realorder = list.get(0);

        long cod = chocolate.getChocolateId();
        temp = "SELECT o FROM Chocolate o WHERE o.chocolateId = " + cod;
        query = em.createQuery(temp);
        List<Chocolate> list2 = query.getResultList();
        Chocolate realchocolate = list2.get(0);

        OrderDetails orderdetail = new OrderDetails(chocolate.getAmount(), realchocolate, realorder);

        try {
            Query q = em.createQuery("select o from OrderDetails o");
            int size = q.getResultList().size();
            em.persist(orderdetail);

            size = q.getResultList().size();
            return orderdetail;
            
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    public double beraknaEnOrdersKostnad(Orders order) {
        double totalsum = 0;
        for (OrderDetails od : order.getOrderDetails()) {
            totalsum += od.getPrice();
        }
        return totalsum;
    }

    public double BeraknaKundsBetalningar(Person person) {
        double totalsum = 0;
        List<Orders> ordrar = person.getOrder();
        List<OrderDetails> allaOD = new ArrayList();
        for (Orders o : ordrar) {
            for (int x = 0; x < o.getOrderDetails().size(); x++) {
                totalsum += o.getOrderDetails().get(x).getPrice();
            }
        }

        if (totalsum > 500000) {
            person.setPremium(true);
            em.merge(person);
        }
        return totalsum;
    }

    public void removeChocolateFromDatabase(Chocolate choc, int amount) {
        String temp = "SELECT c FROM Chocolate c WHERE c.chocolateId = " + choc.getChocolateId();
        Query query = em.createQuery(temp);
        
        List<Chocolate> list = query.getResultList();
        Chocolate chocolate = list.get(0);
        
        chocolate.setInStock(chocolate.getInStock() - amount);
        em.merge(chocolate);
    }

}
