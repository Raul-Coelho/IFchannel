package com.ifpb.controller.servico;

import com.ifpb.model.dao.RelashionshipDao;
import com.ifpb.model.entidades.User;

import java.util.List;

public class RelashionshipService {

    RelashionshipDao dao = new RelashionshipDao();

    public RelashionshipService(){

    }

    public boolean saveUser(User user){
        return dao.saveUser(user);
    }

    public boolean createRelashionship(String email, String email1) {
        return dao.createRelashionship(email,email1);
    }

    public boolean unfollow (String email, String email1) {
        return dao.unfollow(email,email1);
    }

    public List<User> searchFollow(String email) {
        return dao.searchFollow(email);
    }

    public void close() throws Exception {
        dao.close();
    }

    }
