package com.ifpb.controller.bean;


import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

@ManagedBean(name = "postBean")
@ViewScoped
public class PostBean {

    private int evaluation;


    public  PostBean(){

    }

    @PostConstruct
    public void init(){

    }

    public String openSavePost(){
        return "savePost";
    }

}
