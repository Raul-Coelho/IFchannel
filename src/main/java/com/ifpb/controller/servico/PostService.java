package com.ifpb.controller.servico;

import com.ifpb.model.dao.PostDao;
import com.ifpb.model.dao.RelashionshipDao;
import com.ifpb.model.entidades.Post;
import com.ifpb.model.entidades.User;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PostService {

    private PostDao dao = new PostDao();
    private RelashionshipDao rDao = new RelashionshipDao();

    public PostService(){
    }

    public boolean save(Post post){
        return dao.save(post);
    }

    public List<Post> list(int idUser){
        return dao.list(idUser);
    }

    public boolean delete(int id){
        return dao.delete(id);
    }

    public boolean update(Post post){
        return dao.save(post);
    }

    public List<Post> searchPost(User user, String title) {
        return dao.searchByTitle(title, rDao.searchFollow(user.getEmail()));
    }


}
