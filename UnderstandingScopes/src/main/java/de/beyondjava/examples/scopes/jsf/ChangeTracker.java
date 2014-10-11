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
package de.beyondjava.examples.scopes.jsf;

import java.util.HashMap;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;

@ApplicationScoped
@ManagedBean
public class ChangeTracker {
	private HashMap<Integer, Integer> previousValues=new HashMap<>();
	private HashMap<Integer, String> previousStringValues=new HashMap<>();
	private HashMap<Integer, Boolean> hasChanged=new HashMap<>();
	
// method deactivated because EL doesn't support polymorphism
//	public int track(int index, int value) {
//		if (previousValues.containsKey(index)) {
//			int before = previousValues.get(index);
//			previousValues.remove(index);
//			previousValues.put(index, value);
//			hasChanged.put(index, before!=value);
//
//		} else {
//			previousValues.put(index, value);
//			hasChanged.put(index, false);
//		}
//		return value;
//	}
	
	public String track(int index, String value) {
		if (previousStringValues.containsKey(index)) {
			String before = previousStringValues.get(index);
			previousStringValues.remove(index);
			previousStringValues.put(index, value);
			hasChanged.put(index, !value.equals(before));

		} else {
			previousStringValues.put(index, value);
			hasChanged.put(index, false);
		}
		return value;
	}

	
	public String getStyle(int index) {
		if (hasChanged.containsKey(index)) {
			if (hasChanged.get(index)) {
				return "color:red;font-weight:bold;font-size:14px";
			}
		}
		return "";
	}
}
