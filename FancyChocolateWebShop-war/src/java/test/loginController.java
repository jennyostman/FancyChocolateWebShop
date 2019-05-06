package test;

import databas.ChocolateSessionBean;
import databas.LoginBean;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import javax.ejb.EJB;

@Named(value = "loginController")
@SessionScoped
public class loginController implements Serializable {

    @EJB
    private LoginBean login;
    
    private String username;
    private String password;

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
    
    public boolean checkIfAdmin(){
        return true;
    }
    
    public boolean loggain(){
        
        if(login.verifyLogin(username, password)){
        return true;
        }
        else
            return false;
    }
    
    public loginController() {
    }
    
}
