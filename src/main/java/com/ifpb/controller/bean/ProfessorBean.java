package com.ifpb.controller.bean;

import com.ifpb.controller.servico.UserService;
import com.ifpb.model.entidades.User;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.NoneScoped;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.faces.flow.FlowScoped;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@ManagedBean(name = "professorBean")
@SessionScoped
public class ProfessorBean {

    private List<User> professores;

    private User user;

    private UserService service;

    private String name;


    public ProfessorBean(){

    }

    @PostConstruct
    public void init(){
        this.service = new UserService();
        this.professores = new ArrayList<>();
        this.user = new User();
    }

    public String listProfessor() throws SQLException {
        this.professores = service.listProfessor();
        return "goList";
    }


    public List<User> getProfessores() {
        return professores;
    }

    public void setProfessores(List<User> professores) {
        this.professores = professores;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public UserService getService() {
        return service;
    }

    public void setService(UserService service) {
        this.service = service;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
