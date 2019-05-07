package test;

import java.util.*;

public class CustomerDbStandIn {
    
    private String name;
    private String address;
    private boolean premium;
    private double totalSum;
    private int totalOrders;

    public CustomerDbStandIn() {
    }

    public CustomerDbStandIn(String name, String address, boolean premium, float totalSum, int totalOrders) {
        this.name = name;
        this.address = address;
        this.premium = premium;
        this.totalSum = totalSum;
        this.totalOrders = totalOrders;
    }
    
    public List<CustomerDbStandIn> getCustomersList(){
        List<CustomerDbStandIn> customers = new ArrayList();
        customers.add(new CustomerDbStandIn("Pelle", "hejgatan 3", true, 3091874, 300));
        customers.add(new CustomerDbStandIn("Anna", "nejgatan 10", false, 3762, 3));
        customers.add(new CustomerDbStandIn("Kajsa", "hejhejgatan 30", true, 471518873, 274));
        return customers;
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
