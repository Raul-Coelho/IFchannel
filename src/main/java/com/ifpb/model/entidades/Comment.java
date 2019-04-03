package com.ifpb.model.entidades;

import com.datastax.driver.mapping.annotations.PartitionKey;
import com.datastax.driver.mapping.annotations.Table;

import java.util.UUID;

@Table(keyspace = "comments", name = "comment")
public class Comment {
    @PartitionKey
    private UUID commentid;
    private int id;
    private String coment;
    private String username;

    public Comment() {
    }

    public Comment(UUID commentid, int id, String coment, String username) {
        this.commentid = UUID.randomUUID();
        this.id = id;
        this.coment = coment;
        this.username = username;
    }


    public UUID getCommentid() {
        return commentid;
    }

    public void setCommentid(UUID commentid) {
        this.commentid = commentid;
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
                "commentid='" + commentid + '\'' +
                ", id=" + id +
                ", coment='" + coment + '\'' +
                ", username='" + username + '\'' +
                '}';
    }
}
