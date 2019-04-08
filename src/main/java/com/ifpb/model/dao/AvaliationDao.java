package com.ifpb.model.dao;

import com.ifpb.connection.PostgreConFactory;
import com.ifpb.model.entidades.Avaliation;

import java.lang.ref.PhantomReference;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormat;

import static java.lang.Float.parseFloat;

public class AvaliationDao {
    private PostgreConFactory factory;

    public AvaliationDao(){
        factory = new PostgreConFactory();
    }

    public boolean save(Avaliation avaliation){

        String sql = "INSERT INTO avaliation(userid, postid, evaluation) VALUES(?,?,?)";

        try (Connection connection = factory.getConnection()) {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, avaliation.getUserId());
            st.setInt(2, avaliation.getPostId());
            st.setFloat(3, avaliation.getEvaluation());

            return st.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return false;

    }

    public boolean wasEvaluated(int userId, int postId){
        String sql = "SELECT id FROM avaliation WHERE userid = ? AND postId = ?";

        try(Connection connection = factory.getConnection()){
            PreparedStatement st  = connection.prepareStatement(sql);

            st.setInt(1, userId);
            st.setInt(2, postId);

            ResultSet result = st.executeQuery();
            result.next();
            if(result.getInt(1) == 0){
                return false;
            }else {
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return false;
    }

    public float totalEvaluation(int postId){
        String sql = "SELECT evaluation FROM avaliation WHERE postid = ?";
        int cont = 0;
        float media = 0;
        DecimalFormat df = new DecimalFormat("#,00");

        try(Connection connection = factory.getConnection()) {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, postId);

            ResultSet result = st.executeQuery();
            while (result.next()){
                media += result.getFloat("evaluation");
                cont++;
            }
            if(cont == 0){
                return 0;
            }else {
                return Float.parseFloat(df.format(media/cont));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return 0;

    }

    public boolean update(Avaliation avaliation){
        String sql = "UPDATE avaliation SET(evaluation) = (?) WHERE userid = ? AND postid = ?";

        try(Connection connection = factory.getConnection()){
            PreparedStatement st = connection.prepareStatement(sql);
            st.setFloat(1, avaliation.getEvaluation());
            st.setInt(2, avaliation.getUserId());
            st.setInt(3, avaliation.getPostId());

            return st.executeUpdate()>0;
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return false;
    }

}
