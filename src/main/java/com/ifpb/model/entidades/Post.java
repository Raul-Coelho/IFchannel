package com.ifpb.model.entidades;

import java.util.Arrays;
import java.util.List;

public class Post {
    private int id;
    private int idUser;
    private String title;
    private String video;
    private List <Comment> comments;
    private Float evaluation;
    private String description;
    private String exclusivity;
    private double lat;
    private double lng;

    public Post() {
    }

    public Post(int id, int idUser, String title, String video, List<Comment> comments, Float evaluation, String description, String exclusivity, double lat, double lng) {
        this.id = id;
        this.idUser = idUser;
        this.title = title;
        this.video = video;
        this.comments = comments;
        this.evaluation = evaluation;
        this.description = description;
        this.exclusivity = exclusivity;
        this.lat = lat;
        this.lng = lng;
    }

    public Post(int idUser, String title, String video, Float evaluation, String description, String exclusivity) {
        this.idUser = idUser;
        this.title = title;
        this.video = video;
        this.evaluation = evaluation;
        this.description = description;
        this.exclusivity = exclusivity;
    }

    public Post(int id, int idUser, String title, String video, List<Comment> comments, float evaluation, String description, String exclusivity) {
        this.id = id;
        this.title = title;
        this.video = video;
        this.comments = comments;
        this.evaluation = evaluation;
        this.description = description;
        this.exclusivity = exclusivity;
    }

    public Post(int id, int idUser, String title, String video, Float evaluation, String description, String exclusivity) {
        this.id = id;
        this.idUser = idUser;
        this.title = title;
        this.video = video;
        this.evaluation = evaluation;
        this.description = description;
        this.exclusivity = exclusivity;
    }

    public double getLat() {
        return lat;
    }

    public void setLat(double lat) {
        this.lat = lat;
    }

    public double getLng() {
        return lng;
    }

    public void setLng(double lng) {
        this.lng = lng;
    }

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getVideo() {
        return video;
    }

    public void setVideo(String video) {
        this.video = video;
    }

    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }

    public Float getEvaluation() {
        return evaluation;
    }

    public void setEvaluation(Float evaluation) {
        this.evaluation = evaluation;
    }

    public String getExclusivity() {
        return exclusivity;
    }

    public void setExclusivity(String exclusivity) {
        this.exclusivity = exclusivity;
    }

    @Override
    public String toString() {
        return "Post{" +
                "id=" + id +
                ", idUser=" + idUser +
                ", title='" + title + '\'' +
                ", video='" + video + '\'' +
                ", comments=" + comments +
                ", evaluation=" + evaluation +
                ", description='" + description + '\'' +
                ", exclusivity='" + exclusivity + '\'' +
                ", lat=" + lat +
                ", lng=" + lng +
                '}';
    }
}
