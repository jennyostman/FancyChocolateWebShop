package test;

import databas.ChocolateSessionBean;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import javax.ejb.EJB;

@Named(value = "loginController")
@SessionScoped
public class loginController implements Serializable {

    @EJB
    private ChocolateSessionBean chocolateSessionBean;
    
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
        chocolateSessionBean.saveChocolate();
        return true;
    }
    
    public loginController() {
    }
    
}
