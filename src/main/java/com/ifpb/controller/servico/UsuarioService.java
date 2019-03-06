package com.ifpb.controller.servico;

import com.ifpb.model.dao.UsuarioDao;
import com.ifpb.model.entidades.User;

import java.sql.SQLException;

public class UsuarioService {
    private UsuarioDao dao = new UsuarioDao();

    public UsuarioService() throws SQLException, ClassNotFoundException {
    }

    public boolean salvar(int id, String privilege, String email, String matriculation, String password, String name, String sex, byte[] photo, String street,
                          String city, String state, String cep, String phone, String number) throws SQLException {
        User u = new User(id, privilege, email, matriculation, password, name, sex, photo, street, city, state, cep, phone, number);

        return dao.save(u);
    }

    public boolean authenticate(String login){
        try {
            return (dao.searchByLogin(login) != null);
        } catch (SQLException e) {
            return false;
        }
    }
}
