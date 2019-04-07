package com.ifpb.model.dao;

import com.ifpb.connection.PostgreConFactory;
import com.ifpb.model.entidades.Post;
import com.ifpb.model.entidades.User;
import javafx.geometry.Pos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PostDao {
    private PostgreConFactory factory;

    public PostDao(){
        factory = new PostgreConFactory();
    }

    public boolean save(Post post){
        if(post.getId() == 0){
            String sql = "INSERT INTO post(title, video, evaluation, description, exclusivity, userid, lat, lng) VALUES(?,?,?,?,?,?,?,?)";

            try(Connection connection = factory.getConnection()){
                PreparedStatement st = connection.prepareStatement(sql);

                st.setString(1, post.getTitle());
                st.setString(2, post.getVideo());
                st.setFloat(3, post.getEvaluation());
                st.setString(4,post.getDescription());
                st.setString(5,post.getExclusivity());
                st.setInt(6, post.getIdUser());
                st.setDouble(7,post.getLat());
                st.setDouble(8,post.getLng());

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

        try (Connection connection = factory.getConnection()){
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1,id);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()){
                Post p = new Post(
                        resultSet.getInt("id"),
                        resultSet.getString("title"),
                        resultSet.getString("video"),
                        resultSet.getFloat("evaluation"),
                        resultSet.getString("description"),
                        resultSet.getString("exclusivity")
                );
                return p;
            }
            return null;

        } catch (SQLException e) {
            return null;
        } catch (ClassNotFoundException e) {
            return null;
        }
    }

    public List<Post> list(int userid){
        String sql = "SELECT * FROM post WHERE userid = ?";
        List<Post> list = new ArrayList();

        try(Connection connection = factory.getConnection()){
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, userid);
            ResultSet result = st.executeQuery();

            while (result.next()){
                Post p = new Post(
                        result.getInt("id"),
                        result.getString("title"),
                        result.getString("video"),
                        result.getFloat("evaluation"),
                        result.getString("description"),
                        result.getString("exclusivity")

                );
                list.add(p);
            }
            return list;

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
//    public List<Post> searchPost(String title) {
//        List<Post> posts = new ArrayList();
//        String sql = "SELECT u.email, p.title FROM post p JOIN usuario u ON p.userid= u.id WHERE p.title ILIKE ?";
//
//        try (Connection connection = factory.getConnection()) {
//            PreparedStatement st = connection.prepareStatement(sql);
//
//            st.setString(1, title);
//            ResultSet result = st.executeQuery();
//
//            while (result.next()) {
//                Post post = new Post();
//                User user = new User();
//                user.setEmail(result.getString("email"));
//                post.setTitle(result.getString("title"));
//                post.setUser(user);
//                posts.add(post);
//            }
//            return posts;
//        } catch (SQLException ex) {
//            return null;
//        } catch (ClassNotFoundException ex) {
//            return null;
//        }
//    }

    public List<Post> searchByTitle(String title, List<User> users){
        List<Post> list = new ArrayList<>();
        for (User user: users) {
            String sql  = "SELECT * FROM post as p JOIN usuario as u ON p.userid = u.id WHERE title ilike '%"+ title +"%' AND email = ?";

            try(Connection connection = factory.getConnection()){
                PreparedStatement st = connection.prepareStatement(sql);

                st.setString(1, user.getEmail());
                ResultSet result = st.executeQuery();

                while (result.next()) {
                    Post p = new Post(
                            result.getInt("id"),
                            result.getInt("userid"),
                            result.getString("title"),
                            result.getString("video"),
                            result.getFloat("evaluation"),
                            result.getString("description"),
                            result.getString("exclusivity")

                    );
                    list.add(p);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
        return list;
    }

}
