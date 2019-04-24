
package test;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

@FacesValidator("usernameValidate")
public class UsernameValidator implements Validator{

    @Override
    public void validate(FacesContext context, UIComponent component, Object value) throws ValidatorException {
        
          String pass=(String)value;
          boolean text;
          text = pass.equalsIgnoreCase("Grupp7");

          if(pass.isEmpty()){
              String messageText = "Username required!";
                throw new ValidatorException(new FacesMessage(FacesMessage.SEVERITY_ERROR,
                    messageText, messageText));
          }
           
          else if(!text){
               String messageText = "Wrong Username!";
                throw new ValidatorException(new FacesMessage(FacesMessage.SEVERITY_ERROR,
                    messageText, messageText));
        }


        
    }
    
}