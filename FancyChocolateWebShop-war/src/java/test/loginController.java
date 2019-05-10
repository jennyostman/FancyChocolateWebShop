package test;

import databas.ChocolateSessionBean;
import databas.LoginBean;
import databas.Person;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

@Named(value = "loginController")
@SessionScoped
public class loginController implements Serializable {

    @EJB
    private LoginBean login;

    @EJB
    private ChocolateSessionBean chocolateSessionBean;

    private Person person = null;
    private String username;
    private String password;

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
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

    public String logIn() {
        chocolateSessionBean.fillDB();
        person = login.verifyLogin(username, password);

        if (person != null) {
            if (!person.isAdmin()) {
                return "Products";
            } else {
                return "Admin";  //ändra till en admin sida
            }
        } else {
            FacesContext facesContext = FacesContext.getCurrentInstance();
            FacesMessage facesMessage = new FacesMessage("Wrong username or password");
            facesContext.addMessage("loginForm:button", facesMessage);
            return "";
        }
    }

    public loginController() {
    }
}
