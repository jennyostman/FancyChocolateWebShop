package test;

import databas.ChocolateSessionBean;
import databas.Person;
import java.io.Serializable;
import java.util.*;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.Dependent;
import javax.enterprise.context.SessionScoped;

@Named(value = "adminController")
@SessionScoped
public class AdminController implements Serializable{

    @EJB
    private ChocolateSessionBean chocolateSessionBean;

    private String name;
    private String userName;
    private String password;
    private String address;
    private boolean admin;
    private boolean premium;
    
    private double totalSum;
    private int totalOrders;
    private ArrayList<Person> customers = new ArrayList();
    
    public AdminController() {
    }

    public boolean isPremium() {
        return premium;
    }

    public void setPremium(boolean premium) {
        this.premium = premium;
    }

    public double getTotalSum() {
        return totalSum;
    }

    public void setTotalSum(double totalSum) {
        this.totalSum = totalSum;
    }

    public int getTotalOrders() {
        return totalOrders;
    }

    public void setTotalOrders(int totalOrders) {
        this.totalOrders = totalOrders;
    }

    public ArrayList<Person> getCustomers() {
        customers = chocolateSessionBean.getAllCustomersForAdmin();
        return customers;
    }

    public void setCustomers(ArrayList<Person> customers) {
        this.customers = customers;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
    
}
