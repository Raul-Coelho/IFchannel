package com.ifpb.controller.bean;

import com.ifpb.controller.servico.UserService;
import com.ifpb.model.entidades.User;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@ManagedBean(name = "userBean")
@ViewScoped
public class UserBean {

    private List<User> users;

    private User user;

    private UserService service;

    private String status;

    public UserBean(){

    }

    @PostConstruct
    public void init() throws SQLException, ClassNotFoundException {
        this.service = new UserService();
        this.users = new ArrayList();
        this.user = new User();
    }

    public void list() throws SQLException {
        this.status = "list";
        this.users = service.list();
    }

    public String openLogin(){
        return "goLogin";
    }

    public String openRegister(){
        return "register";
    }

    public String registerUser() throws SQLException {
        service.save(user);
        list();
        return "begin";
    }

    public void prepareEdition(){
        this.status = "edition";
    }

    public void removeUser() throws SQLException {
        service.delete(user);
        list();
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
