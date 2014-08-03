package de.beyondjava.examples.scopes.spring;

import java.io.Serializable;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope(value="request")
public class SpringRequestScopedBean implements Serializable {
	private static final long serialVersionUID = 1L;
	private int counter=1;
	
	public int getCounter() {
		return counter++;
	}
	
	public void setCounter(int counter) {
		this.counter = counter;
	}
}

