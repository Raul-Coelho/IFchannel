package com.ifpb.controller.bean;

import com.ifpb.controller.servico.UserService;
import com.ifpb.model.entidades.User;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.servlet.http.Part;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

@ManagedBean(name = "userBean")
@ViewScoped
public class UserBean {

    private String imgSource = "C:\\Users\\Lucas\\Documents\\Projetos\\IFchannel\\src\\main\\web\\images";

    private List<User> users;

    private List<User> professores;

    private User user;

    private UserService service;

    private String status;

    private Part image;

    public UserBean(){

    }

    @PostConstruct
    public void init(){
        this.service = new UserService();
        this.users = new ArrayList<>();
        try{
            this.professores = new ArrayList(service.listProfessor());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        this.user = new User();
    }

    public void list() throws SQLException {
        this.status = "list";
        this.users = service.list();
    }


    public String openLogin(){
        return "goLogin";
    }

    public String openList(){
        return "goList";
    }

    public String openRegister(){
        return "register?faces-redirect=true";
    }

    public String registerUser() throws SQLException {
        String archive = LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd-MM-yyyy-HH-mm-ss")) + "-" + image.getSubmittedFileName();

        archive = archive.replaceAll(":", "-");

        try(InputStream file = image.getInputStream()){
            Files.copy(file, new File(imgSource + "/" + archive).toPath(), StandardCopyOption.REPLACE_EXISTING);
        } catch (IOException e) {
            e.printStackTrace();
        }

        user.setPhoto(archive);

        if (user.getMatriculation().length() == 12){
           user.setPrivilege("student");
        }else{
            user.setPrivilege("professor");
        }
        service.save(user);
        list();
        return "goLogin";
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

    public Part getImage() {
        return image;
    }

    public void setImage(Part image) {
        this.image = image;
    }

    public List<User> getProfessores() {
        return professores;
    }

    public void setProfessores(List<User> professores) {
        this.professores = professores;
    }
}
