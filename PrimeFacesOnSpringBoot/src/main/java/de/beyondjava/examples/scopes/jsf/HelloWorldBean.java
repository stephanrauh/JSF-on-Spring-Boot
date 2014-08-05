package de.beyondjava.examples.scopes.jsf;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

@ManagedBean
@ViewScoped
public class HelloWorldBean {
	public String getHello() {
		return "Hello from PrimeFaces and Spring Boot!";
	}
}
