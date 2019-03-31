package com.ifpb.model.dao;

import com.datastax.driver.core.*;
import com.datastax.driver.core.querybuilder.QueryBuilder;
import com.ifpb.connection.CassandraConnection;
import com.ifpb.model.entidades.Comment;

import java.util.List;

import static com.datastax.driver.core.querybuilder.QueryBuilder.eq;

public class CommentDao {
    private Session session;

    public CommentDao(){

    }

    public boolean saveComment(Comment comment){
        session = CassandraConnection.getConnection();
        PreparedStatement statement = session.prepare("INSERT INTO comment (id, coment, username) VALUES (?,?,?)");
        BoundStatement bound = statement.bind(comment.getId(),comment.getcoment(),comment.getUsername());
        ResultSet rs = session.execute(bound);
        CassandraConnection.closeConnection();
        session.close();
        return rs.wasApplied();
    }
    public boolean deleteComment(int id){
        session = CassandraConnection.getConnection();
        Statement statement = QueryBuilder.delete().from("comment").where(eq("id",id));
        ResultSet rs = session.execute(statement);
        CassandraConnection.closeConnection();
        session.close();
        return rs.wasApplied();
    }
    public List<Row> listComments(){
        session = CassandraConnection.getConnection();
        Statement statement = QueryBuilder.select("coment","username").from("comment");
        ResultSet resultSet = session.execute(statement);
        List<Row>rowList= resultSet.all();
        for (Row row:rowList){
            return rowList;
        }
        CassandraConnection.closeConnection();
        session.close();
        return null;
    }
    public List<Row> searchComment(int id){
        session=CassandraConnection.getConnection();
        Statement statement = QueryBuilder.select("coment").from("comment").where(eq("id",id));
        ResultSet resultSet = session.execute(statement);
        if (resultSet.wasApplied()){
            List<Row> rows = resultSet.all();
            for (Row row:rows){
                return rows;
            }
        }else return null;

        CassandraConnection.closeConnection();
        session.close();
        return null;
    }

    public boolean editComent(int id, String comment){
        String script = "UPDATE comment SET coment = '"+ comment +"' WHERE id = "+ id+ ";";
        session = CassandraConnection.getConnection();
        PreparedStatement statement= session.prepare(script);
        ResultSet resultSet = session.execute(script);
        CassandraConnection.closeConnection();
        session.close();
        return resultSet.wasApplied();
    }



}