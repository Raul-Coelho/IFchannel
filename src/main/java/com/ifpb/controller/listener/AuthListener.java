package com.ifpb.controller.listener;

import com.ifpb.controller.bean.LoginBean;
import com.ifpb.controller.bean.UserBean;

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
            event.getFacesContext().getApplication().getNavigationHandler().handleNavigation(context, null, "goIndex");
        }

        LoginBean loginBean = (LoginBean)request.getSession(false).getAttribute("loginBean");
        UserBean userBean = (UserBean) request.getSession(false).getAttribute("userBean");
        if (!viewId.equals("/ifchannel/login.xhtml") && (!viewId.equals("/ifchannel/index.xhtml") && (!viewId.equals("/ifchannel/register.xhtml") ))) {
            if (loginBean == null || loginBean.getUserLogged() == null) {
                event.getFacesContext().getApplication().getNavigationHandler().handleNavigation(context, null, "goIndex");
            }
        } else {
            if (loginBean != null && loginBean.getUserLogged() != null) {
                event.getFacesContext().getApplication().getNavigationHandler().handleNavigation(context, null, "goIndex");
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
