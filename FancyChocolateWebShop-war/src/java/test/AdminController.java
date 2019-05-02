package test;

import java.io.Serializable;
import java.util.*;
import javax.inject.Named;
import javax.enterprise.context.Dependent;

@Named(value = "adminController")
@Dependent
public class AdminController implements Serializable{
    
    private String name;
    private String address;
    private boolean premium;
    private double totalSum;
    private int totalOrders;
    private List<CustomerDbStandIn> customers;
    
    public AdminController() {
        CustomerDbStandIn cd = new CustomerDbStandIn();
        customers = cd.getCustomersList();
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

    public List<CustomerDbStandIn> getCustomers() {
        return customers;
    }

    public void setCustomers(List<CustomerDbStandIn> customers) {
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
