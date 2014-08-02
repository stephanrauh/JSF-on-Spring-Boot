package de.beyondjava.examples.scopes.manualScope;

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