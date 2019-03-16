package com.ifpb.model.entidades;

import java.util.Arrays;
import java.util.List;

public class Post {
    private int id;
    private String title;
    private String video;
    private List <Comment> comments;
    private Float evaluation;
    private String description;

    public Post() {
    }

    public Post(String title, String video, Float evaluation, String description) {
        this.title = title;
        this.video = video;
        this.evaluation = evaluation;
        this.description = description;
    }

    public Post(int id, String title, String video, List<Comment> comments, float evaluation, String description) {
        this.id = id;
        this.title = title;
        this.video = video;
        this.comments = comments;
        this.evaluation = evaluation;
        this.description = description;
    }

    public Post(int id, String title, String video, Float evaluation, String description) {
        this.id = id;
        this.title = title;
        this.video = video;
        this.evaluation = evaluation;
        this.description = description;
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


    @Override
    public String toString() {
        return "Post{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", video=" + video +
                ", comments=" + comments +
                ", evaluation=" + evaluation +
                ", description='" + description + '\'' +
                '}';
    }
}
