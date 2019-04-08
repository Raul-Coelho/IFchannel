package com.ifpb.model.dao;

import com.ifpb.connection.PostgreConFactory;
import com.ifpb.model.entidades.Evaluation;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormat;

public class EvaluationDao {
    private PostgreConFactory factory;

    public EvaluationDao(){
        factory = new PostgreConFactory();
    }

    public boolean save(Evaluation evaluation){

        String sql = "INSERT INTO evaluation (userid, postid, evaluation) VALUES(?,?,?)";

        try (Connection connection = factory.getConnection()) {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, evaluation.getUserId());
            st.setInt(2, evaluation.getPostId());
            st.setFloat(3, evaluation.getEvaluation());

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

    public boolean update(Evaluation evaluation){
        String sql = "UPDATE avaliation SET(evaluation) = (?) WHERE userid = ? AND postid = ?";

        try(Connection connection = factory.getConnection()){
            PreparedStatement st = connection.prepareStatement(sql);
            st.setFloat(1, evaluation.getEvaluation());
            st.setInt(2, evaluation.getUserId());
            st.setInt(3, evaluation.getPostId());

            return st.executeUpdate()>0;
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return false;
    }

}
