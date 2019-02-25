package com.ifpb.controller.servico;

import com.ifpb.model.dao.UsuarioDao;
import com.ifpb.model.entidades.Usuario;

import java.sql.SQLException;

public class UsuarioService {
    private UsuarioDao dao = new UsuarioDao();

    public UsuarioService() throws SQLException, ClassNotFoundException {
    }

    public boolean salvar(int id, String email, String senha, String nome, String sexo, byte[] foto, String rua,
                          String cidade, String estado, String cep, String telefone, String numero) throws SQLException {
        Usuario u = new Usuario(id, email, senha, nome, sexo, foto, rua, cidade, estado, cep, telefone, numero);

        return dao.salvar(u);
    }

    public boolean authenticate(String login){
        try {
            return (dao.searchByLogin(login) != null);
        } catch (SQLException e) {
            return false;
        }
    }
}
