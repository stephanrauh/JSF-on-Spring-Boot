package de.beyondjava.examples.scopes.spring;

import java.io.Serializable;

import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;

@Component
@Scope(proxyMode=ScopedProxyMode.TARGET_CLASS, value="prototype")
public class SpringAOPPrototypeScopedBean implements Serializable {
	private static final long serialVersionUID = 1L;
	private int counter=1;
	
	public int getCounter() {
		System.out.println("AOPPrototypeScopedBean - ProxyMode=TARGET_CLASS");
		return counter++;
	}
	
	public void setCounter(int counter) {
		this.counter = counter;
	}
}

