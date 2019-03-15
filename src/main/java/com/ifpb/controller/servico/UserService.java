package com.ifpb.controller.servico;

import com.ifpb.model.dao.UsuarioDao;
import com.ifpb.model.entidades.User;

import java.sql.SQLException;

public class UserService {
    private UsuarioDao dao = new UsuarioDao();

    public UserService() throws SQLException, ClassNotFoundException {
    }

    public boolean save(int id, String privilege, String email, String matriculation, String password, String name, String sex, byte[] photo, String street,
                        String city, String state, String cep, String phone, String number) throws SQLException {
        User u = new User(id, privilege, email, matriculation, password, name, sex, photo, street, city, state, cep, phone, number);

        return dao.save(u);
    }

    public boolean authenticate(String login, String password){
        return dao.authentic(login, password);
    }

    public User searchByLogin(String email) throws SQLException {
        return dao.searchByLogin(email);
    }

    public boolean update(User user) throws SQLException {
        return dao.save(user);
    }
}
