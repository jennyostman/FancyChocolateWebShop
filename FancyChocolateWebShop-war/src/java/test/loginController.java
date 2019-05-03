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
        
        //jag kommenterade bort raden nedan sa att inte det laggs in mer choklad i databsen varje gang
        //programmet kors
      //  chocolateSessionBean.saveChocolate();
       // System.out.println("checkIfAdmin() tillkallas");
        //System.out.println(chocolateSessionBean.testar3());
       //sorry testar saker haer /marcus
        return true;
    }
    
    public loginController() {
    }
    
}
