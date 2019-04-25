/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testMarcus;

import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;

/**
 *
 * @author marcu
 */
@Named(value = "marcusController")
@SessionScoped
public class marcusController implements Serializable {

    /**
     * Creates a new instance of marcusController
     */
    public marcusController() {
    }
    
}
