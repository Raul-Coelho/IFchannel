package com.ifpb.model.dao;

import com.ifpb.connection.PostgreConFactory;
import com.ifpb.model.entidades.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class UsuarioDao {

    private PostgreConFactory factory;

    public UsuarioDao() {
        factory = new PostgreConFactory();
    }

    public boolean save(User u) throws SQLException {
        if (u.getId() == 0) {
            String sql = "INSERT INTO usuario(name, matriculation, email, password, gender, street, state, city, number," +
                    " cep, photo, phone, privilege) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?)";

            try (Connection connection = factory.getConnection()) {
                PreparedStatement st = connection.prepareStatement(sql);
                st.setString(1, u.getName());
                st.setString(2, u.getMatriculation());
                st.setString(3, u.getEmail());
                st.setString(4, u.getPassword());
                st.setString(5, u.getSex());
                st.setString(6, u.getStreet());
                st.setString(7, u.getState());
                st.setString(8, u.getCity());
                st.setString(9, u.getNumber());
                st.setString(10, u.getCep());
                st.setString(11, u.getPhoto());
                st.setString(12, u.getPhone());
                st.setString(13, u.getPrivilege());

                return st.executeUpdate() > 0;

            } catch (SQLException e) {
                System.out.println(e);
                return false;
            } catch (ClassNotFoundException e) {
                System.out.println(e);
                return false;
            }
        } else {

            String sql = "UPDATE usuario set (name, password, gender, street, state, city, number, cep, photo, " +
                    "phone, privilege) = (?,?,?,?,?,?,?,?,?,?,?) WHERE id = ?";
            try (Connection connection = factory.getConnection()) {
                PreparedStatement st = connection.prepareStatement(sql);
                st.setString(1, u.getName());
                st.setString(2, u.getPassword());
                st.setString(3, u.getSex());
                st.setString(4, u.getStreet());
                st.setString(5, u.getState());
                st.setString(6, u.getCity());
                st.setString(7, u.getNumber());
                st.setString(8, u.getCep());
                st.setString(9, u.getPhoto());
                st.setString(10, u.getPhone());
                st.setString(11, u.getPrivilege());

                st.setInt(11, u.getId());

                return st.executeUpdate() > 0;

            } catch (SQLException e) {
                System.out.println(e);
                return false;
            } catch (ClassNotFoundException e) {
                System.out.println(e);
                return false;
            }
        }
    }


    public User searchById(int id) throws SQLException {
        String sql = "SELECT * FROM usuario WHERE id = ?";

        try (Connection connection = factory.getConnection()) {
            PreparedStatement st = connection.prepareStatement(sql);

            st.setInt(1, id);
            ResultSet result = st.executeQuery();

            if (result.next()) {
                User u = new User(
                        result.getInt("id"),
                        result.getString("privilege"),
                        result.getString("email"),
                        result.getString("matriculation"),
                        result.getString("password"),
                        result.getString("name"),
                        result.getString("gender"),
                        result.getString("photo"),
                        result.getString("street"),
                        result.getString("city"),
                        result.getString("state"),
                        result.getString("cep"),
                        result.getString("phone"),
                        result.getString("number")
                );
                return u;
            }
            return null;
        } catch (SQLException e) {
            return null;
        } catch (ClassNotFoundException e) {
            return null;
        }
    }

    public List<User> searchByName(String nome) throws SQLException {
        String sql = "SELECT * FROM usuario WHERE nome = ?";
        List<User> users = null;

        try (Connection connection = factory.getConnection()) {
            PreparedStatement st = connection.prepareStatement(sql);

            st.setString(1, nome);
            ResultSet result = st.executeQuery();

            while (result.next()) {
                User u = new User(
                        result.getInt("id"),
                        result.getString("privilege"),
                        result.getString("email"),
                        result.getString("matriculation"),
                        result.getString("password"),
                        result.getString("name"),
                        result.getString("gender"),
                        result.getString("photo"),
                        result.getString("street"),
                        result.getString("city"),
                        result.getString("state"),
                        result.getString("cep"),
                        result.getString("phone"),
                        result.getString("number")
                );
                users.add(u);
            }
            return users;
        } catch (SQLException e) {
            return null;
        } catch (ClassNotFoundException e) {
            return null;
        }
    }

    public List<User> listar() throws SQLException {
        String sql = "SELECT * FROM usuario";
        List<User> users = null;

        try (Connection connection = factory.getConnection()) {
            PreparedStatement st = connection.prepareStatement(sql);

            ResultSet result = st.executeQuery();

            while (result.next()) {
                User u = new User(
                        result.getInt("id"),
                        result.getString("privilege"),
                        result.getString("email"),
                        result.getString("matriculation"),
                        result.getString("password"),
                        result.getString("name"),
                        result.getString("gender"),
                        result.getString("photo"),
                        result.getString("street"),
                        result.getString("city"),
                        result.getString("state"),
                        result.getString("cep"),
                        result.getString("phone"),
                        result.getString("number")
                );
                users.add(u);
            }
            return users;
        } catch (SQLException e) {
            return null;
        } catch (ClassNotFoundException e) {
            return null;
        }
    }

    public User searchByLogin(String login) throws SQLException {
        String sql = "SELECT * FROM usuario WHERE email = ?";

        try (Connection connection = factory.getConnection()) {
            PreparedStatement st = connection.prepareStatement(sql);

            st.setString(1, login);
            ResultSet result = st.executeQuery();

            if (result.next()) {
                User u = new User(
                        result.getInt("id"),
                        result.getString("privilege"),
                        result.getString("email"),
                        result.getString("matriculation"),
                        result.getString("password"),
                        result.getString("name"),
                        result.getString("gender"),
                        result.getString("photo"),
                        result.getString("street"),
                        result.getString("city"),
                        result.getString("state"),
                        result.getString("cep"),
                        result.getString("phone"),
                        result.getString("number")
                );
                return u;
            }
            return null;
        } catch (SQLException e) {
            return null;
        } catch (ClassNotFoundException e) {
            return null;
        }
    }

    public boolean delete(String email) throws SQLException {
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

    public boolean authentic(String email, String password) {
        String sql = "SELECT * FROM usuario WHERE email = ?";

        try (Connection connection = factory.getConnection()) {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, email);
            ResultSet result = st.executeQuery();

            User u = new User();

            if (result.next()) {
                 u = new User(
                         result.getInt("id"),
                         result.getString("privilege"),
                         result.getString("email"),
                         result.getString("matriculation"),
                         result.getString("password"),
                         result.getString("name"),
                         result.getString("gender"),
                         result.getString("photo"),
                         result.getString("street"),
                         result.getString("city"),
                         result.getString("state"),
                         result.getString("cep"),
                         result.getString("phone"),
                         result.getString("number")
                );
            }
            return (u != null && u.getPassword().equals(password));

        } catch (SQLException e) {
            return false;
        } catch (ClassNotFoundException e) {
            return false;
        }catch (NullPointerException e){
            return false;
        }
    }
}
