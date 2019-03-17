package com.ifpb.model.dao;

import com.ifpb.connection.PostgreConFactory;
import com.ifpb.model.entidades.Post;
import javafx.geometry.Pos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class PostDao {
    private PostgreConFactory factory;

    public PostDao(){
        factory = new PostgreConFactory();
    }

    public boolean save(Post post){
        if(post.getId() == 0){
            String sql = "INSERT INTO post(title, video, description, exclusivity, idUser) VALUES(?,?,?,?,?)";

            try(Connection connection = factory.getConnection()){
                PreparedStatement st = connection.prepareStatement(sql);

                st.setString(1, post.getTitle());
                st.setString(2, post.getVideo());
                st.setFloat(3, post.getEvaluation());
                st.setString(4,post.getExclusivity());
                st.setInt(5, post.getIdUser());

                return st.executeUpdate()>0;

            } catch (SQLException e) {
                return false;
            } catch (ClassNotFoundException e) {
                return false;
            }
        }else{
            String sql = "UPDATE post SET(title, video, description) = (?,?,?)";

            try(Connection connection = factory.getConnection()){
                PreparedStatement st = connection.prepareStatement(sql);
                st.setString(1, post.getTitle());
                st.setString(2, post.getVideo());
                st.setString(3, post.getDescription());

                return st.executeUpdate()>0;

            } catch (SQLException e) {
                return false;
            } catch (ClassNotFoundException e) {
                return false;
            }
        }
    }

    public Post searchById(int id){
        String sql = "SELECT * FROM post WHERE id = ?";

        Post post = new Post();

        try(Connection connection = factory.getConnection()){
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, id);
            ResultSet result = st.executeQuery();

            if(result.next()){
                post = new Post(
                        result.getInt("id"),
                        result.getInt("idUser"),
                        result.getString("title"),
                        result.getString("video"),
                        result.getFloat("evaluation"),
                        result.getString("description"),
                        result.getString("exclusivity")
                );
            }
            return post;
        } catch (SQLException e) {
            return null;
        } catch (ClassNotFoundException e) {
            return null;
        }
    }

    public List<Post> list(int idUser){
        String sql = "SELECT * FROM post WHERE id = ?";
        List<Post> post = null;

        try(Connection connection = factory.getConnection()){
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, idUser);
            ResultSet result = st.executeQuery();

            while (result.next()){
                Post p = new Post(
                        result.getInt("id"),
                        result.getInt("idUser"),
                        result.getString("title"),
                        result.getString("video"),
                        result.getFloat("evaluation"),
                        result.getString("description"),
                        result.getString("exclusivity")

                );
                post.add(p);
            }
            return post;

        } catch (SQLException e) {
            return null;
        } catch (ClassNotFoundException e) {
            return null;
        }
    }

    public boolean delete(int id){
        String sql = "DELETE FROM post WHERE id =?";

        try(Connection connection = factory.getConnection()){
            PreparedStatement st = connection.prepareStatement(sql);

            st.setInt(1, id);

            return st.executeUpdate()>0;
        } catch (SQLException e) {
            return false;
        } catch (ClassNotFoundException e) {
            return false;
        }
    }

}
