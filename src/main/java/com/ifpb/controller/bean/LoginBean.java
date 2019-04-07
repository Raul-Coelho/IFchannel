package com.ifpb.controller.bean;

import com.datastax.driver.core.Row;
import com.ifpb.controller.servico.CommentService;
import com.ifpb.controller.servico.PostService;
import com.ifpb.controller.servico.RelashionshipService;
import com.ifpb.controller.servico.UserService;
import com.ifpb.model.entidades.Comment;
import com.ifpb.model.entidades.Post;
import com.ifpb.model.entidades.User;
import org.primefaces.model.map.DefaultMapModel;
import org.primefaces.model.map.LatLng;
import org.primefaces.model.map.MapModel;
import org.primefaces.model.map.Marker;


import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
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
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@ManagedBean(name = "loginBean")
@SessionScoped
public class LoginBean {

//    private String imgSource = "C:\\Users\\Lucas\\Documents\\Projetos\\IFchannel\\src\\main\\web\\images";
//    private String videoSource = "C:\\Users\\Lucas\\Documents\\Projetos\\IFchannel\\src\\main\\web\\videos";

    private String imgSource = "/home/raul/Documentos/Repositorios/IFchannel/src/main/web/images";
    private String videoSource = "/home/raul/Documentos/Repositorios/IFchannel/src/main/web/videos";

//    private String imgSource = "/home/romulo/Documentos/Repositorios/IFchannel/src/main/web/images";
//    private String videoSource = "/home/romulo/Documentos/Repositorios/IFchannel/src/main/web/videos";


    private UserService service;

    private RelashionshipService rService;

    private CommentService cService;

    private PostService servicePost;

    private User userLogged;

    private Comment comment;

    private  String textComment;

    private String login;

    private String password;

    private Post post;

    private MapModel emptyModel;

    private String title;

    private String search;

    private Part video;

    private Part image;

    private float evaluationPost;

    private List<User> professores;

    private List<Post> posts;

    private List<Comment> comments;


    @PostConstruct
    public void init(){
        service = new UserService();
        comment = new Comment();
        emptyModel = new DefaultMapModel();
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

    ///////////////////////////////////

    public String openEditUser(){
        return "edit";
    }

    public String editUser() throws SQLException {
        service = new UserService();
        User user = service.searchById(userLogged.getId());
        String archive = LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd-MM-yyyy-HH-mm-ss")) + "-" + image.getSubmittedFileName();

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

    ////////////////////////////////////

    public String openSavePost(){
        this.post = new Post();
        return "savePost";
    }

    public String savePost(){
        servicePost = new PostService();

        String archive = LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd-MM-yyyy-HH-mm-ss")) + "-" + video.getSubmittedFileName();

        archive = archive.replaceAll(":", "-");

        try(InputStream file = video.getInputStream()){
            Files.copy(file, new File(videoSource + "/" + archive).toPath(), StandardCopyOption.REPLACE_EXISTING);
        } catch (IOException e) {
            e.printStackTrace();
        }

        post.setVideo(archive);

        post.setEvaluation(evaluationPost);

        post.setIdUser(userLogged.getId());

        servicePost.save(post);

        servicePost = null;

        return "professor";
    }

    public void addMarker() {
        Marker marker = new Marker(new LatLng(post.getLat(), post.getLng()), title);
        emptyModel.addOverlay(marker);
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Marker Added", "Lat:" + post.getLat() + ", Lng:" + post.getLng()));
    }

    //////////////////////////////////////

    public String searchProfessor() throws SQLException {
        this.professores = new ArrayList<>();
        this.service = new UserService();
        this.professores = service.listProfessor();
        service = null;
        return "goList";
    }

    public String searchPost() throws SQLException {
        this.professores = new ArrayList<>();
        this.service = new UserService();
        this.professores = service.listProfessor();
        service = null;

        this.posts = new ArrayList<>();
        this.servicePost = new PostService();
        this.posts = servicePost.searchPost(userLogged,search);
        servicePost = null;
        
        return "goList";
    }

    public void follow(User professor){
        rService = new RelashionshipService();
        rService.createRelashionship(userLogged.getEmail(), professor.getEmail());
        rService = null;

    }


    public void unfollow(User professor){
        rService = new RelashionshipService();
        rService.unfollow(userLogged.getEmail(), professor.getEmail());
        rService = null;

    }



    //////////////////////////////////////

    public void saveComment(){
            cService = new CommentService();
            comment.setId(userLogged.getId());
            comment.setComment(textComment);
            comment.setUsername(userLogged.getName());
            cService.save(comment);
            cService = null;

            this.comments = new ArrayList<>();
            cService = new CommentService();
            comments = cService.list();
            cService = null;
    }

    public void listComments(){
        this.comments = new ArrayList<>();
        cService = new CommentService();
        comments = cService.list();
        cService = null;
    }


    public void removeComment(Comment comment){
        cService = new CommentService();
        cService.delete(comment);
        cService = null;

        this.comments = new ArrayList<>();
        cService = new CommentService();
        comments = cService.list();
        cService = null;
    }


    //////////////////////////////////////


    public float getEvaluationPost() {
        return evaluationPost;
    }

    public void setEvaluationPost(float evaluationPost) {
        this.evaluationPost = evaluationPost;
    }

    public MapModel getEmptyModel() {
        return emptyModel;
    }

    public void setEmptyModel(MapModel emptyModel) {
        this.emptyModel = emptyModel;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Post getPost() {
        return post;
    }

    public void setPost(Post post) {
        this.post = post;
    }

    public Part getVideo() {
        return video;
    }

    public void setVideo(Part video) {
        this.video = video;
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

    public String getVideoSource() {
        return videoSource;
    }

    public void setVideoSource(String videoSource) {
        this.videoSource = videoSource;
    }

    public List<User> getProfessores() {
        return professores;
    }

    public void setProfessores(List<User> professores) {
        this.professores = professores;
    }

    public Comment getComment() {
        return comment;
    }

    public void setComment(Comment comment) {
        this.comment = comment;
    }

    public String getTextComment() {
        return textComment;
    }

    public void setTextComment(String textComment) {
        this.textComment = textComment;
    }

    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }

    public List<Post> getPosts() {
        return posts;
    }

    public void setPosts(List<Post> posts) {
        this.posts = posts;
    }

    public String getSearch() {
        return search;
    }

    public void setSearch(String search) {
        this.search = search;
    }
}
