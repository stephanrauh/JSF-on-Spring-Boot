package de.beyondjava.examples.scopes.springInJSFBean;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.support.WebApplicationContextUtils;

import de.beyondjava.examples.scopes.spring.SpringAOPRequestScopedBean;

@ViewScoped
@ManagedBean
public class ViewScopeContainsAOPRequestScope {
	@Autowired
	SpringAOPRequestScopedBean springBean;

	public String getCounter() {
		return springBean.getCounter();
	}
	
    @PostConstruct
    private void init() {
    	ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext();
        ServletContext servletContext = (ServletContext) externalContext.getContext();
		WebApplicationContextUtils.getRequiredWebApplicationContext(servletContext).
                                   getAutowireCapableBeanFactory().
                                   autowireBean(this);
    }

}
