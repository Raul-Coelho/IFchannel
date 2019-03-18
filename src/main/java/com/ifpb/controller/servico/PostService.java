package com.ifpb.controller.servico;

import com.ifpb.model.dao.PostDao;
import com.ifpb.model.entidades.Post;

import java.sql.SQLException;
import java.util.List;

public class PostService {
    private PostDao dao = new PostDao();

    public PostService()throws SQLException, ClassNotFoundException{
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


}
