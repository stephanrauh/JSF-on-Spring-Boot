package de.beyondjava.examples.scopes.beyondViewScope;

import java.util.Map;

import javax.faces.context.FacesContext;
import javax.faces.event.AbortProcessingException;
import javax.faces.event.ActionEvent;
import javax.faces.event.ActionListener;

public class DestroyBeyondViewScope implements ActionListener {
 
    @Override
    public void processAction(final ActionEvent event) throws AbortProcessingException {
 
        FacesContext facesContext = FacesContext.getCurrentInstance();
        Map<String, Object> sessionMap = facesContext.getExternalContext().getSessionMap();
 
        BeyondViewScope customScope = (BeyondViewScope) sessionMap.get(BeyondViewScope.SCOPE_NAME);
        customScope.notifyDestroy(facesContext);
 
        sessionMap.remove(BeyondViewScope.SCOPE_NAME);
 
    }
 
}