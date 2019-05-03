package test;

import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import javax.ejb.EJB;

@Named(value = "registerController")
@SessionScoped
public class registerController implements Serializable {

    @EJB
    private RegistrationBean registrationBean;
    
    private boolean showPopup;
    private String username,password,firstName,lastName,address;
    
   // private Customer customer;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
            
    public void show(){
        showPopup = true;
    }
    public void hide(){
        showPopup = false;
    }

    public boolean isShowPopup(){
        return showPopup;
    }
    
    public void setShowPopup(boolean showPopup) {
        this.showPopup = showPopup;
    }

    public RegistrationBean getRegistrationBean() {
        return registrationBean;
    }

    public void setRegistraionBean(RegistrationBean registraionBean) {
        this.registrationBean = registraionBean;
    }
    
    /*public Customer getCustomer(){
        return customer;
    }
    
    public void setCustomer(Customer customer){
        this.customer = customer;
    }
    */
    
    public void register(){
        registrationBean.registerUser(username,password,firstName,lastName,address);
        
    }
    
    
    public registerController() {
    }
    
}
