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
package de.beyondjava.examples.scopes.jsf.manualScope;

import java.util.concurrent.ConcurrentHashMap;

import javax.faces.context.FacesContext;
import javax.faces.event.PostConstructCustomScopeEvent;
import javax.faces.event.PreDestroyCustomScopeEvent;
import javax.faces.event.ScopeContext;

public class ManualScope extends ConcurrentHashMap<String, Object> {
 
    private static final long serialVersionUID = 6013804747421198557L;
 
    public static final String SCOPE_NAME = "ManualScope";
 
    public ManualScope(){
        super();
    }
 
    public void notifyCreate(final FacesContext ctx) {
 
        ScopeContext context = new ScopeContext(SCOPE_NAME, this);
        ctx.getApplication().publishEvent(ctx, PostConstructCustomScopeEvent.class, context);
 
    }
 
    public void notifyDestroy(final FacesContext ctx) {
 
        ScopeContext scopeContext = new ScopeContext(SCOPE_NAME,this);
        ctx.getApplication().publishEvent(ctx, PreDestroyCustomScopeEvent.class, scopeContext);
 
    }
 
}