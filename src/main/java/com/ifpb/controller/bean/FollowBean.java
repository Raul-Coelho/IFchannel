package com.ifpb.controller.bean;


import com.ifpb.model.dao.RelashionshipDao;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean
@SessionScoped
public class FollowBean {

    private String situation;

    private RelashionshipDao dao;

    @PostConstruct
    public void init(){
        dao = new RelashionshipDao();
    }


}
