package test;

import databas.RegistrationBean;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import javax.ejb.EJB;

@Named(value = "registerController")
@SessionScoped
public class registerController implements Serializable {


    
    private boolean showPopup;
    private String name,username,password,address;
    
    @EJB
    private RegistrationBean registrationBean;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
            

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
    

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
            

    public boolean isShowPopup(){
        return showPopup;
    }
    
    public void setShowPopup(boolean showPopup) {
        this.showPopup = showPopup;
    }
    public void show(){
        showPopup = true;
    }
    public void hide(){
        showPopup = false;
    }

    public RegistrationBean getRegistrationBean() {
        return registrationBean;
    }

    public void setRegistraionBean(RegistrationBean registraionBean) {
        this.registrationBean = registraionBean;
    }
    
    public void register(){
        registrationBean.registerUser(name,username,password,address);
        
    }
    
    
    public registerController() {
        showPopup = false;
    }
    
}
