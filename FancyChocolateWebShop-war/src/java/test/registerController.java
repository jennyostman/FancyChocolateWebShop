package test;

import databas.RegistrationBean;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

@Named(value = "registerController")
@SessionScoped
public class registerController implements Serializable {


    
    private boolean showPopup;
    private String name,username,password,address;
    private FacesMessage facesMessage;
    private String registered,inUse = "";

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

    public String getRegistered() {
        return registered;
    }

    public void setRegistered() {
        this.registered = "Register Sucessfull";
    }

    public String getInUse() {
        return inUse;
    }

    public void setInUse() {
        this.inUse = "Username is already in use!";
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
    
    public FacesMessage getFacesmessage() {
        return facesMessage;
    }

    public void setFacesMessage(FacesMessage facesmessage) {
        this.facesMessage = facesmessage;
    }
    
    
     public boolean formFilled(){
        
        FacesContext facesContext = FacesContext.getCurrentInstance();
        FacesMessage facesMessage = new FacesMessage("This field is requiered");
        boolean isFilled = true;
        
        if(name.equals("")){
            facesContext.addMessage("registerForm:name", facesMessage);
            isFilled = false;
        }
        if(username.equals("")){
            facesContext.addMessage("registerForm:username", facesMessage);
            isFilled = false;
        }
        if(password.equals("")){
            facesContext.addMessage("registerForm:password", facesMessage);
            isFilled = false;
        }
        if(address.equals("")){
            facesContext.addMessage("registerForm:adress", facesMessage);
            isFilled = false;
        }
        
        return isFilled;
   
    }
    
    
    
    
    public String register(){
        
        
        if(!formFilled()){
            return "";
        }
        
        
        else if(!registrationBean.registerUser(name,username,password,address)){
            setInUse();
            return "";
        }
        setRegistered();
        hide();
        return "";
    }
    
    public registerController() {
        showPopup = false;
    }
    
}
