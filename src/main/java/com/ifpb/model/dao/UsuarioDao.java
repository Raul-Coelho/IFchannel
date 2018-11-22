package com.ifpb.model.dao;

import com.ifpb.conexao.ConnectionFactory;
import com.ifpb.model.entidades.Usuario;

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

    public boolean salvar(Usuario u) throws SQLException{
        if(u.getId() == 0){
            String sql = "INSERT INTO usuario(nome, email, senha, sexo, rua, estado, cidade, numero, cep, foto, " +
                    "telefone) VALUES (?,?,?,?,?,?,?,?,?,?,?)";

            try(Connection connection = factory.getConnection()){
                PreparedStatement st = connection.prepareStatement(sql);
                st.setString(1, u.getNome());
                st.setString(2, u.getEmail() );
                st.setString(3, u.getSenha());
                st.setString(4, u.getSexo());
                st.setString(5, u.getRua());
                st.setString(6, u.getEstado());
                st.setString(7, u.getCidade());
                st.setString(8, u.getNumero());
                st.setString(9, u.getCep());
                st.setBytes(10, u.getFoto());
                st.setString(11, u.getTelefone());

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
                st.setString(1, u.getNome());
                st.setString(2, u.getSenha());
                st.setString(3, u.getSexo());
                st.setString(4, u.getRua());
                st.setString(5, u.getEstado());
                st.setString(6, u.getCidade());
                st.setString(7, u.getNumero());
                st.setString(8, u.getCep());
                st.setBytes(9, u.getFoto());
                st.setString(10, u.getTelefone());

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


    public Usuario buscarById(int id) throws SQLException {
        String sql = "SELECT * FROM usuario WHERE id = ?";

        try(Connection connection = factory.getConnection()){
            PreparedStatement st = connection.prepareStatement(sql);

            st.setInt(1, id);
            ResultSet resultado = st.executeQuery();

            if(resultado.next()){
                Usuario u = new Usuario(
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

    public List<Usuario> buscarByName(String nome) throws SQLException{
        String sql = "SELECT * FROM usuario WHERE nome = ?";
        List<Usuario> usuarios = null;

        try(Connection connection = factory.getConnection()){
            PreparedStatement st = connection.prepareStatement(sql);

            st.setString(1, nome);
            ResultSet resultado = st.executeQuery();

            while(resultado.next()){
                Usuario u = new Usuario(
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
                usuarios.add(u);
            }
            return usuarios;
        }catch (SQLException e){
            return null;
        } catch (ClassNotFoundException e) {
            return null;
        }
    }

    public List<Usuario> listar() throws SQLException{
        String sql = "SELECT * FROM usuario";
        List<Usuario> usuarios = null;

        try(Connection connection = factory.getConnection()){
            PreparedStatement st = connection.prepareStatement(sql);

            ResultSet resultado = st.executeQuery();

            while(resultado.next()){
                Usuario u = new Usuario(
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
                usuarios.add(u);
            }
            return usuarios;
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

}
