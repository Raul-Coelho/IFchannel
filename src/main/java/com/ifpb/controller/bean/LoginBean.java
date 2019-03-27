package com.ifpb.controller.bean;

import com.ifpb.controller.servico.UserService;
import com.ifpb.model.entidades.User;

import java.sql.SQLException;
import java.util.Optional;

public class LoginBean {
    UserService service;

    User userLogged;

    String login;
    String password;

    public void init() throws SQLException, ClassNotFoundException {
        service = new UserService();
    }

    public String autenticate() throws SQLException {
        User user = service.searchByLogin(login);
        return null;
    }


    public User getUserLogged() {
        return userLogged;
    }

    public void setUserLogged(User userLogged) {
        this.userLogged = userLogged;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
