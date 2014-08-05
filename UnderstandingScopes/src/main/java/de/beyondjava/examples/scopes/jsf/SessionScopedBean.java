package de.beyondjava.examples.scopes.jsf;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@SessionScoped
@ManagedBean
public class SessionScopedBean {
	private int counter=1;
	
	public int getCounter() {
		return counter++;
	}

	public void setCounter(int counter) {
		this.counter = counter;
	}
}
