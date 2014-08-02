package de.beyondjava.examples.scopes.spring;

import java.io.Serializable;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope(value="session")
public class SpringSessionScopedBean implements Serializable {
	private static final long serialVersionUID = 1L;
	private int counter=1;
	
	public int getCounter() {
		System.out.println("SessionScopedBean");
		return counter++;
	}
	
	public void setCounter(int counter) {
		this.counter = counter;
	}
}

