package com.ifpb.controller.bean;


import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ValueChangeEvent;
import java.util.Locale;

@ManagedBean
@SessionScoped
public class LanguageBean {

    private String language;

    @PostConstruct
    public void init() {
        language = FacesContext.getCurrentInstance().getViewRoot().getLocale().getLanguage();
    }

    public void changeLanguage(ValueChangeEvent event) {
        language = (String)event.getNewValue();
        FacesContext.getCurrentInstance().getViewRoot().setLocale(new Locale(language));
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }
}
