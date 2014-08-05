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
package de.beyondjava.examples.scopes.jsf.beyondViewScope;

import java.util.Map;
import java.util.Set;

import javax.faces.application.ConfigurableNavigationHandler;
import javax.faces.application.NavigationCase;
import javax.faces.application.NavigationHandler;
import javax.faces.context.FacesContext;

/**
 * This Navigation handler destroys the custom view scope each time a new JSF
 * page is opened.
 *
 */
public class BeyondViewScopeNavigationHandler extends
		ConfigurableNavigationHandler {

	private NavigationHandler wrappedNavigationHandler;

	public BeyondViewScopeNavigationHandler(NavigationHandler parent) {
		this.wrappedNavigationHandler = parent;
	}

	/** If a new JSF page is opened, get rid of the current custom view scope. */
	@Override
	public void handleNavigation(FacesContext context, String from,
			String outcome) {
		String previousView = context.getViewRoot().getViewId();
		if (null != outcome && (!previousView.endsWith(outcome))) {
			destroyCurrentViewScope();
		}

		wrappedNavigationHandler.handleNavigation(context, from, outcome);
	}

	/** Get rid of the custom view scope. */
	private void destroyCurrentViewScope() {
		FacesContext facesContext = FacesContext.getCurrentInstance();
		Map<String, Object> sessionMap = facesContext.getExternalContext()
				.getSessionMap();

		BeyondViewScope customScope = (BeyondViewScope) sessionMap
				.get(BeyondViewScope.SCOPE_NAME);
		if (null != customScope) {
			customScope.notifyDestroy(facesContext);
		}

		sessionMap.remove(BeyondViewScope.SCOPE_NAME);
	}

	/** Calls the default implementation */
	@Override
	public NavigationCase getNavigationCase(FacesContext context,
			String fromAction, String outcome) {
		if (wrappedNavigationHandler instanceof ConfigurableNavigationHandler) {
			return ((ConfigurableNavigationHandler) wrappedNavigationHandler)
					.getNavigationCase(context, fromAction, outcome);
		} else {
			return null;
		}
	}

	/** Calls the default implementation */
	@Override
	public Map<String, Set<NavigationCase>> getNavigationCases() {
		if (wrappedNavigationHandler instanceof ConfigurableNavigationHandler) {
			return ((ConfigurableNavigationHandler) wrappedNavigationHandler)
					.getNavigationCases();
		} else {
			return null;
		}
	}

}