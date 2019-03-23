package com.ifpb.controller.servico;

import com.ifpb.model.dao.UserDao;
import com.ifpb.model.entidades.User;

import java.sql.SQLException;
import java.util.List;

public class UserService {
    private UserDao dao = new UserDao();

    public UserService() throws SQLException, ClassNotFoundException {
    }

    public boolean save(User user) throws SQLException {
        return dao.save(user);
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

    public List<User> list() throws SQLException {
        return dao.listar();
    }

    public boolean delete(User user) throws SQLException {
        return dao.delete(user.getEmail());
    }
}
