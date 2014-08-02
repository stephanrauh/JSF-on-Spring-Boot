package de.beyondjava.examples.scopes.manualScope;

import java.io.Serializable;
import java.util.Map;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.NoneScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.AbortProcessingException;
import javax.faces.event.ActionEvent;
import javax.faces.event.ActionListener;

@NoneScoped
@ManagedBean
public class ManualScopeManagerBean implements Serializable {
	private static final long serialVersionUID = 1L;

    public void createScope(final ActionEvent event) {
 
        FacesContext facesContext = FacesContext.getCurrentInstance();
        Map<String, Object> sessionMap = facesContext.getExternalContext().getSessionMap();
 
        ManualScope customScope = new ManualScope();
        sessionMap.put(ManualScope.SCOPE_NAME, customScope);
 
        customScope.notifyCreate(facesContext);
 
    }
    
    public void destroyScope(final ActionEvent event)  {
    	 
        FacesContext facesContext = FacesContext.getCurrentInstance();
        Map<String, Object> sessionMap = facesContext.getExternalContext().getSessionMap();
 
        ManualScope customScope = (ManualScope) sessionMap.get(ManualScope.SCOPE_NAME);
        customScope.notifyDestroy(facesContext);
 
        sessionMap.remove(ManualScope.SCOPE_NAME);
 
    }

 
}
 
