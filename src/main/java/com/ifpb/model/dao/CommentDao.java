package com.ifpb.model.dao;

import com.datastax.driver.core.*;
import com.datastax.driver.core.querybuilder.QueryBuilder;
import com.ifpb.connection.CassandraConnection;
import com.ifpb.model.entidades.Comment;

import static com.datastax.driver.core.querybuilder.QueryBuilder.eq;

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
    public boolean excluirComentario(int id){
        session = CassandraConnection.getConnection();
        Statement statement = QueryBuilder.delete().from("comment").where(eq("id",id));
        ResultSet rs = session.execute(statement);
        CassandraConnection.closeConnection();
        session.close();
        return rs.wasApplied();
    }


}