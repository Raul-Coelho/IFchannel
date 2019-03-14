package com.ifpb.model.dao;

import com.ifpb.connection.PostgreConFactory;
import com.ifpb.model.entidades.Post;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class PostDao {
    private PostgreConFactory factory;

    public PostDao(){
        factory = new PostgreConFactory();
    }

//    public boolean save(Post post){
//        if(post.getId() == 0){
//            String sql = "INSERT INTO post(title, video, comment, evaluation) VALUES(?,?,?,?)";
//
//            try(Connection connection = factory.getConnection()){
//                PreparedStatement st = connection.prepareStatement(sql);
//
//                st.setString(1, post.getTitle());
//                st.setBytes(2, post.getVideo());
//                st.setString(3, post.toString());
//                st.setFloat(4, post.getEvaluation());
//
//                return st.executeUpdate()>0;
//
//            } catch (SQLException e) {
//                return false;
//            } catch (ClassNotFoundException e) {
//                return false;
//            }
//        }else{
//            String sql = "UPDATE post";
//        }
//    }


}
