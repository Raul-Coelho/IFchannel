package com.ifpb.controller.bean;

import com.ifpb.controller.servico.UserService;
import com.ifpb.model.entidades.User;


import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.Part;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.Instant;

@ManagedBean(name = "loginBean")
@SessionScoped
public class LoginBean {

//    private String imgSource = "C:\\Imagens\\";
    private String imgSource = "/home/raul/Imagens";

    private UserService service;

    private User userLogged;

    private String login;

    private String password;

    private Part image;

    @PostConstruct
    public void init(){
        service = new UserService();
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

    public String openEditUser(){
        return "edit";
    }

    public String editUser() throws SQLException {
        service = new UserService();
        User user = service.searchById(userLogged.getId());
        String archive = Timestamp.from(Instant.now()).toString() + "-" + image.getSubmittedFileName();

        archive = archive.replaceAll(":", "-");

        try(InputStream file = image.getInputStream()){
            Files.copy(file, new File(imgSource + "/" + archive).toPath(), StandardCopyOption.REPLACE_EXISTING);
        } catch (IOException e) {
            e.printStackTrace();
        }

        userLogged.setPhoto(archive);
        userLogged.setPassword(user.getPassword());

        service.save(userLogged);

        userLogged.setPassword("");

        service = null;

        if(userLogged.getPrivilege().equals("professor")){
            return "professor";
        }else {
            return "student";
        }
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

    public String getImgSource() {
        return imgSource;
    }

    public void setImgSource(String imgSource) {
        this.imgSource = imgSource;
    }

    public Part getImage() {
        return image;
    }

    public void setImage(Part image) {
        this.image = image;
    }
}
