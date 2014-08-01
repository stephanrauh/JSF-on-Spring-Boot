package de.beyondjava.examples.scopes;

import java.io.Serializable;

import javax.faces.bean.CustomScoped;
import javax.faces.bean.ManagedBean;

@CustomScoped("#{ScopeBeyondJava}")
@ManagedBean
public class CustomScopedBean implements Serializable {
	private static final long serialVersionUID = 1L;
	private int counter=1;
	
	public int getCounter() {
		return counter++;
	}
	
	public void setCounter(int counter) {
		this.counter = counter;
	}

}
