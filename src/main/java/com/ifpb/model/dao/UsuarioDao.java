package com.ifpb.model.dao;

import com.ifpb.conexao.ConnectionFactory;
import com.ifpb.model.entidades.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class UsuarioDao {

    private ConnectionFactory factory;

    public UsuarioDao(){
        factory = new ConnectionFactory();
    }

    public boolean salvar(User u) throws SQLException{
        if(u.getId() == 0){
            String sql = "INSERT INTO usuario(nome, email, senha, sexo, rua, estado, cidade, numero, cep, foto, " +
                    "telefone) VALUES (?,?,?,?,?,?,?,?,?,?,?)";

            try(Connection connection = factory.getConnection()){
                PreparedStatement st = connection.prepareStatement(sql);
                st.setString(1, u.getName());
                st.setString(2, u.getEmail() );
                st.setString(3, u.getPassword());
                st.setString(4, u.getSex());
                st.setString(5, u.getStreet());
                st.setString(6, u.getState());
                st.setString(7, u.getCity());
                st.setString(8, u.getNumber());
                st.setString(9, u.getCep());
                st.setBytes(10, u.getPhoto());
                st.setString(11, u.getPhone());

                return st.executeUpdate() > 0;

            } catch (SQLException e) {
                System.out.println(e);
                return false;
            } catch (ClassNotFoundException e) {
                System.out.println(e);
                return false;
            }
        }else{

            String sql = "UPDATE usuario set (nome, senha, sexo, rua, estado, cidade, numero, cep, foto, " +
                    "telefone) = (?,?,?,?,?,?,?,?,?,?) WHERE id = ?";
            try(Connection connection = factory.getConnection()){
                PreparedStatement st = connection.prepareStatement(sql);
                st.setString(1, u.getName());
                st.setString(2, u.getPassword());
                st.setString(3, u.getSex());
                st.setString(4, u.getStreet());
                st.setString(5, u.getState());
                st.setString(6, u.getCity());
                st.setString(7, u.getNumber());
                st.setString(8, u.getCep());
                st.setBytes(9, u.getPhoto());
                st.setString(10, u.getPhone());

                st.setInt(11, u.getId());

                return st.executeUpdate() > 0;

            }catch (SQLException e){
                System.out.println(e);
                return false;
            } catch (ClassNotFoundException e) {
                System.out.println(e);
                return false;
            }
        }
    }


    public User buscarById(int id) throws SQLException {
        String sql = "SELECT * FROM usuario WHERE id = ?";

        try(Connection connection = factory.getConnection()){
            PreparedStatement st = connection.prepareStatement(sql);

            st.setInt(1, id);
            ResultSet resultado = st.executeQuery();

            if(resultado.next()){
                User u = new User(
                        resultado.getString("id"),
                        resultado.getString("email"),
                        resultado.getString("senha"),
                        resultado.getString("nome"),
                        resultado.getBytes("foto"),
                        resultado.getString("sexo"),
                        resultado.getString("rua"),
                        resultado.getString("cidade"),
                        resultado.getString("estado"),
                        resultado.getString("cep"),
                        resultado.getString("telefone")
                );
                return u;
            }
            return null;
        }catch (SQLException e){
            return null;
        } catch (ClassNotFoundException e) {
            return null;
        }
    }

    public List<User> searchByName(String nome) throws SQLException{
        String sql = "SELECT * FROM usuario WHERE nome = ?";
        List<User> users = null;

        try(Connection connection = factory.getConnection()){
            PreparedStatement st = connection.prepareStatement(sql);

            st.setString(1, nome);
            ResultSet resultado = st.executeQuery();

            while(resultado.next()){
                User u = new User(
                        resultado.getString("id"),
                        resultado.getString("email"),
                        resultado.getString("senha"),
                        resultado.getString("nome"),
                        resultado.getBytes("foto"),
                        resultado.getString("sexo"),
                        resultado.getString("rua"),
                        resultado.getString("cidade"),
                        resultado.getString("estado"),
                        resultado.getString("cep"),
                        resultado.getString("telefone")
                );
                users.add(u);
            }
            return users;
        }catch (SQLException e){
            return null;
        } catch (ClassNotFoundException e) {
            return null;
        }
    }

    public List<User> listar() throws SQLException{
        String sql = "SELECT * FROM usuario";
        List<User> users = null;

        try(Connection connection = factory.getConnection()){
            PreparedStatement st = connection.prepareStatement(sql);

            ResultSet resultado = st.executeQuery();

            while(resultado.next()){
                User u = new User(
                        resultado.getString("id"),
                        resultado.getString("email"),
                        resultado.getString("senha"),
                        resultado.getString("nome"),
                        resultado.getBytes("foto"),
                        resultado.getString("sexo"),
                        resultado.getString("rua"),
                        resultado.getString("cidade"),
                        resultado.getString("estado"),
                        resultado.getString("cep"),
                        resultado.getString("telefone")
                );
                users.add(u);
            }
            return users;
        }catch (SQLException e){
            return null;
        } catch (ClassNotFoundException e) {
            return null;
        }
    }

    public User searchByLogin(String login) throws SQLException {
        String sql = "SELECT * FROM usuario WHERE id = ?";

        try(Connection connection = factory.getConnection()){
            PreparedStatement st = connection.prepareStatement(sql);

            st.setString(1, login);
            ResultSet resultado = st.executeQuery();

            if(resultado.next()){
                User u = new User(
                        resultado.getString("id"),
                        resultado.getString("email"),
                        resultado.getString("senha"),
                        resultado.getString("nome"),
                        resultado.getBytes("foto"),
                        resultado.getString("sexo"),
                        resultado.getString("rua"),
                        resultado.getString("cidade"),
                        resultado.getString("estado"),
                        resultado.getString("cep"),
                        resultado.getString("telefone")
                );
                return u;
            }
            return null;
        }catch (SQLException e){
            return null;
        } catch (ClassNotFoundException e) {
            return null;
        }
    }

    public boolean deletar(String email) throws SQLException {
        String sql = "DELETE FROM usuario WHERE email = ?";

        try (Connection connection = factory.getConnection()) {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, email);

            return st.executeUpdate() > 0;
        } catch (SQLException e) {
            return false;
        } catch (ClassNotFoundException e) {
            return false;
        }
    }

//    public boolean authenticate(String email, String password){
//        String sql = "SELECT * FROM usuario WHERE email = ?";
//
//        try(ConnectionFactory connection = factory.getConnection()){
//            PreparedStatement st = connection.Pre
//        }
//    }

}
