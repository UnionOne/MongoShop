package com.itibo.mongo.component;

import javax.el.ELContext;
import javax.el.ValueExpression;
import javax.faces.component.FacesComponent;
import javax.faces.component.UINamingContainer;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

@FacesComponent("collapsible")
public class CollapsiblePanel extends UINamingContainer {
    enum PropertyKeys {
        collapsed
    }

    public boolean isCollapsed() {
        return (Boolean) getStateHelper().eval(PropertyKeys.collapsed, Boolean.FALSE);
    }

    public void setCollapsed(boolean collapsed) {
        getStateHelper().put(PropertyKeys.collapsed, collapsed);
    }

    @SuppressWarnings("UnusedDeclaration")
    public void toggle(ActionEvent e) {
        setCollapsed(!isCollapsed());
        setCollapsedValueExpression();
    }

    private void setCollapsedValueExpression() {
        ELContext context = FacesContext.getCurrentInstance().getELContext();
        ValueExpression expression = getValueExpression(PropertyKeys.collapsed.name());
        if (expression != null) {
            expression.setValue(context, isCollapsed());
        }
    }
}