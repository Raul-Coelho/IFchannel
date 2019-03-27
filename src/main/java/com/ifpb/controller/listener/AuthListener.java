package com.ifpb.controller.listener;

import com.ifpb.controller.bean.LoginBean;

import javax.faces.context.FacesContext;
import javax.faces.event.PhaseEvent;
import javax.faces.event.PhaseId;
import javax.faces.event.PhaseListener;
import javax.servlet.http.HttpServletRequest;

public class AuthListener implements PhaseListener {
    @Override
    public void afterPhase(PhaseEvent event) {
        String viewId = event.getFacesContext().getViewRoot().getViewId();
        FacesContext context = FacesContext.getCurrentInstance();
        HttpServletRequest request = (HttpServletRequest)context.getExternalContext().getRequest();

        if (request.getSession() == null) {
            event.getFacesContext().getApplication().getNavigationHandler().handleNavigation(context, null, "goLogin");
        }

        LoginBean loginBean = (LoginBean)request.getSession(false).getAttribute("loginBean");
        if (!viewId.equals("/ifchannel/login.xhtml")) {
            if (loginBean == null || loginBean.getUserLogged() == null) {
                event.getFacesContext().getApplication().getNavigationHandler().handleNavigation(context, null, "login");
            }
        } else {
            if (loginBean != null && loginBean.getUserLogged() != null) {
                event.getFacesContext().getApplication().getNavigationHandler().handleNavigation(context, null, "produtos");
            }
        }
    }

    @Override
    public void beforePhase(PhaseEvent phaseEvent) {

    }

    @Override
    public PhaseId getPhaseId() {
        return PhaseId.RESTORE_VIEW;
    }
}
