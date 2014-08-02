package de.beyondjava.examples.scopes.manualScope;
import java.beans.FeatureDescriptor;
import java.util.Collections;
import java.util.Iterator;
import java.util.Map;

import javax.el.ELContext;
import javax.el.ELResolver;
import javax.el.PropertyNotFoundException;
import javax.faces.bean.CustomScoped;
import javax.faces.context.FacesContext;

public class ManualScopeELResolver extends ELResolver {

	@Override
	public Object getValue(final ELContext elContext, final Object base, final Object property) {

		if (property == null) {
			throw new PropertyNotFoundException();
		}
		
		if (base instanceof ManualScope || base instanceof CustomScoped || property.equals(ManualScope.SCOPE_NAME)) {
			System.out.println("base: " + base);
			System.out.println("Propoerty:" + property);
		}

		FacesContext facesContext = (FacesContext) elContext.getContext(FacesContext.class);

		if ((null == base) && ManualScope.SCOPE_NAME.equals(property.toString())) {

			// Scope is referenced directly

			ManualScope scope = getScope(facesContext);
			elContext.setPropertyResolved(true);
			return scope;

		} else if ((null != base) && (base instanceof ManualScope)) {

			// An object within the scope is referenced

			return resolve(facesContext, (ManualScope) base, property.toString());

		} else if (null == base) {
			ManualScope customScope = getScope(facesContext);
			return null != customScope ? resolve(facesContext, customScope, property.toString()):null;

		}
		return null;
	}


	/**
	 * Resolve the key on the given {@link ManualScope}
	 * @param facesContext
	 * @param scope
	 * @param key
	 * @return scoped
	 */
	public Object resolve(final FacesContext facesContext, final ManualScope scope, final String key) {

		Object value = scope.get(key);
		facesContext.getELContext().setPropertyResolved(value != null);
		return value;

	}


	/**
	 * Responsible to retrieve the scope
	 * @param facesContext
	 * @return
	 */
	private ManualScope getScope(final FacesContext facesContext) {

		Map<String, Object> sessionMap = facesContext.getExternalContext().getSessionMap();
		ManualScope customScope = (ManualScope) sessionMap.get(ManualScope.SCOPE_NAME);

		return customScope;
	}


	@Override
	public Class<?> getType(final ELContext elContext, final Object base, final Object property) {
		return Object.class;
	}

	@Override
	public void setValue(final ELContext elContext, final Object base, final Object property, final Object value) {
		// do nothing
	}

	@Override
	public boolean isReadOnly(final ELContext elContext, final Object base, final Object property) {
		return true;
	}

	@Override
	public Iterator<FeatureDescriptor> getFeatureDescriptors(final ELContext elContext, final Object base) {
		return Collections.<FeatureDescriptor>emptyList().iterator();
	}

	@Override
	public Class<?> getCommonPropertyType(final ELContext elContext, final Object base) {
		if (base != null) {
			return null;
		}
		return String.class;
	}

}