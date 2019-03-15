package com.ifpb.model.entidades;

public class Comment {
    private int id;
    private String coment;
    private String username;

    public Comment(int id, String coment, String username) {
        this.id = id;
        this.coment = coment;
        this.username = username;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getcoment() {
        return coment;
    }

    public void setcoment(String coment) {
        this.coment = coment;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public String toString() {
        return "Comment{" +
                "id=" + id +
                ", coment='" + coment + '\'' +
                ", username='" + username + '\'' +
                '}';
    }
}