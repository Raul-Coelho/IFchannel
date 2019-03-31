package com.ifpb.controller.bean;


import com.ifpb.controller.servico.RelashionshipService;
import com.ifpb.model.dao.RelashionshipDao;
import com.ifpb.model.entidades.User;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean(name = "followBean")
@SessionScoped
public class FollowBean {

    private LoginBean loginBean;

    private String situation;

    private RelashionshipService service;

    private User user;

    private String emailProfessor;

    @PostConstruct
    public void init(){
        user = new User();
        service = new RelashionshipService();
        loginBean = new LoginBean();
    }

    public String saveUser(){
        service.saveUser(user);
        return "student?faces-redirect=true";
    }

    public void follow(){
        service.createRelashionship(loginBean.getUserLogged().getEmail(), emailProfessor);
    }

    public String getSituation() {
        return situation;
    }

    public void setSituation(String situation) {
        this.situation = situation;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getEmailProfessor() {
        return emailProfessor;
    }

    public void setEmailProfessor(String emailProfessor) {
        this.emailProfessor = emailProfessor;
    }
}
