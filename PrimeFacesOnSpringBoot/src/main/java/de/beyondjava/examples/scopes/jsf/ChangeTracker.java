package de.beyondjava.examples.scopes.jsf;

import java.util.HashMap;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;

@ApplicationScoped
@ManagedBean
public class ChangeTracker {
	private HashMap<Integer, Integer> previousValues=new HashMap<>();
	private HashMap<Integer, Boolean> hasChanged=new HashMap<>();
	
	public int track(int index, int value) {
		if (previousValues.containsKey(index)) {
			int before = previousValues.get(index);
			previousValues.remove(index);
			previousValues.put(index, value);
			hasChanged.put(index, before!=value);

		} else {
			previousValues.put(index, value);
			hasChanged.put(index, false);
		}
		return value;
	}
	
	public String getStyle(int index) {
		if (previousValues.containsKey(index)) {
			if (hasChanged.get(index)) {
				return "color:red;font-weight:bold;font-size:14px";
			}
		}
		return "";
	}
}
