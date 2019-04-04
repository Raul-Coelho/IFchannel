package com.ifpb.model.entidades;

import com.datastax.driver.mapping.annotations.PartitionKey;
import com.datastax.driver.mapping.annotations.Table;

import java.util.UUID;

@Table(keyspace = "comments", name = "comment")
public class Comment {
    @PartitionKey
    private UUID commentid;
    private int id;
    private String comment;
    private String username;

    public Comment() {
    }

    public Comment(UUID commentid, int id, String comment, String username) {
        this.commentid = UUID.randomUUID();
        this.id = id;
        this.comment = comment;
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

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
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
                ", comment='" + comment + '\'' +
                ", username='" + username + '\'' +
                '}';
    }
}
