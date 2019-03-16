package com.ifpb.model.dao;

import com.datastax.driver.core.BoundStatement;
import com.datastax.driver.core.PreparedStatement;
import com.datastax.driver.core.ResultSet;
import com.datastax.driver.core.Session;
import com.ifpb.connection.CassandraConnection;
import com.ifpb.model.entidades.Comment;

public class CommentDao {
    private Session session;

    public CommentDao(){

    }

    public boolean salvarComentario(Comment comment){
        session = CassandraConnection.getConnection();
        PreparedStatement statement = session.prepare("INSERT INTO comment (id, coment, username) VALUES (?,?,?)");
        BoundStatement bound = statement.bind(comment.getId(),comment.getcoment(),comment.getUsername());
        ResultSet rs = session.execute(bound);
        CassandraConnection.closeConnection();
        session.close();
        return rs.wasApplied();
    }

}