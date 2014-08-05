/**
 *  (C) 2013-2014 Stephan Rauh http://www.beyondjava.net
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package de.beyondjava.examples.scopes.jsf.manualScope;

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
 
