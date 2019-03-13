package com.ifpb.model.entidades;

import java.util.Arrays;
import java.util.List;

public class Post {
    private int id;
    private String titulo;
    private byte[] video;
    private List <Comment> comments;
    private Float evaluation;

    public Post(int id, String titulo, byte[] video, List<Comment> comments, Float evaluation) {
        this.id = id;
        this.titulo = titulo;
        this.video = video;
        this.comments = comments;
        this.evaluation = evaluation;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public byte[] getVideo() {
        return video;
    }

    public void setVideo(byte[] video) {
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
                ", titulo='" + titulo + '\'' +
                ", video=" + Arrays.toString(video) +
                ", comments=" + comments +
                ", evaluation=" + evaluation +
                '}';
    }
}
