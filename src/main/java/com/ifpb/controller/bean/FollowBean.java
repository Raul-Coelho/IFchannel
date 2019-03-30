package com.ifpb.controller.bean;


import com.ifpb.controller.servico.RelashionshipService;
import com.ifpb.model.dao.RelashionshipDao;
import com.ifpb.model.entidades.User;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean
@SessionScoped
public class FollowBean {

    private String situation;

    private RelashionshipService service;

    private User user;

    @PostConstruct
    public void init(){
        user = new User();
        service = new RelashionshipService();
    }

    public String saveUser(){
        service.saveUser(user);
        return "student?faces-redirect=true";
    }


}
