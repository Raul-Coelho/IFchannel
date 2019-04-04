package com.ifpb.model.dao;

import com.datastax.driver.core.*;
import com.datastax.driver.core.querybuilder.QueryBuilder;
import com.ifpb.connection.CassandraConnection;
import com.ifpb.model.entidades.Comment;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import static com.datastax.driver.core.querybuilder.QueryBuilder.eq;

public class CommentDao {
    private Session session;

    UUID commentid;

    public CommentDao(){

    }

    public boolean saveComment(Comment comment){
        commentid = UUID.randomUUID();
        session = CassandraConnection.getConnection();
        PreparedStatement statement = session.prepare("INSERT INTO comment (commentid, userid, comment, username) VALUES (?,?,?,?)");
        BoundStatement bound = statement.bind(commentid, comment.getId(),comment.getComment(),comment.getUsername());
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
    public List<Comment> listComments(){
        session = CassandraConnection.getConnection();
        Statement statement = QueryBuilder.select("commentid","userid","comment","username").from("comment");
        ResultSet resultSet = session.execute(statement);
        List<Row>rowList= resultSet.all();
        List<Comment> comments = new ArrayList<>();
        for (Row row:rowList){
            Comment comment = new Comment();
            comment.setId(row.getInt("userid"));
            comment.setUsername(row.getString("username"));
            comment.setComment(row.getString("comment"));
            comments.add(comment);
        }
        CassandraConnection.closeConnection();
        session.close();
        return comments;
    }
    public List<Row> searchComment(int id){
        session=CassandraConnection.getConnection();
        Statement statement = QueryBuilder.select("comment").from("comment").where(eq("id",id));
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
        String script = "UPDATE comment SET comment = '"+ comment +"' WHERE id = "+ id+ ";";
        session = CassandraConnection.getConnection();
        PreparedStatement statement= session.prepare(script);
        ResultSet resultSet = session.execute(script);
        CassandraConnection.closeConnection();
        session.close();
        return resultSet.wasApplied();
    }



}