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
    
    private Person choosenCustomer;
    private boolean showPopup = false;
    
    public AdminController() {
    }
    
    public void sendCustumer(Person customer){
        
        setChoosenCustomer(customer);
        setshowPopup(true);
    }
    
    public boolean showPopup(){
        return true;
    }
    
    public boolean hidePopup(){
        return false;
    }

    public boolean isShowPopup() {
        return showPopup;
    }

    public void setshowPopup(boolean showPopup) {
        this.showPopup = showPopup;
    }
    
    public void closePopup(){
        setChoosenCustomer(null);
        setshowPopup(false);
    }

    public ChocolateSessionBean getChocolateSessionBean() {
        return chocolateSessionBean;
    }

    public void setChocolateSessionBean(ChocolateSessionBean chocolateSessionBean) {
        this.chocolateSessionBean = chocolateSessionBean;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isAdmin() {
        return admin;
    }

    public void setAdmin(boolean admin) {
        this.admin = admin;
    }

    public Person getChoosenCustomer() {
        return choosenCustomer;
    }

    public void setChoosenCustomer(Person choosenCustomer) {
        this.choosenCustomer = choosenCustomer;
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
