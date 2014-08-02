package de.beyondjava.examples.scopes.jsf;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

@ViewScoped
@ManagedBean
public class ViewScopedBean implements Serializable {
	private static final long serialVersionUID = 1L;
	private int counter = 1;

	public int getCounter() {
		return counter++;
	}

	public void setCounter(int counter) {
		this.counter = counter;
	}
}
