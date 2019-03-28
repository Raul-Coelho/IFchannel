package com.ifpb.controller.bean;

import com.ifpb.controller.servico.UserService;
import com.ifpb.model.entidades.User;


import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import java.sql.SQLException;

@ManagedBean(name = "loginBean")
@SessionScoped
public class LoginBean {

    private UserService service;

    private User userLogged;

    private String login;
    private String password;

    @PostConstruct
<<<<<<< HEAD
    public void init() {
        try{
            service = new UserService();
        }catch (Exception e){

=======
    public void init(){
        try {
            service = new UserService();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
>>>>>>> 7a71874ce925b120fb1a48b8a0d26f9e5cd76f02
        }
    }

    public String autenticate() throws SQLException {

        User user = service.searchByLogin(login);

        if(!service.authenticate(login, password)){
            return "";
        }else if(user.getPrivilege().equals("professor")){

            userLogged = user;
            userLogged.setPassword("");
            login = null;
            password = null;
            service = null;

            return "professor";
        }else{

            userLogged = user;
            userLogged.setPassword("");
            login = null;
            password = null;
            service = null;

            return "student";
        }
    }

    public String logout() {
        HttpServletRequest request = (HttpServletRequest)FacesContext.getCurrentInstance().getExternalContext().getRequest();
        request.getSession(false).invalidate();
        return "logout";
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
