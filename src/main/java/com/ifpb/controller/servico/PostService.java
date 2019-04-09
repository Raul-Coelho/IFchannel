package com.ifpb.controller.servico;

import com.ifpb.model.dao.PostDao;
import com.ifpb.model.dao.RelashionshipDao;
import com.ifpb.model.entidades.Post;
import com.ifpb.model.entidades.User;

import java.util.ArrayList;
import java.util.List;

public class PostService {

    private PostDao dao = new PostDao();

    private EvaluationService aDao = new EvaluationService();
    private RelashionshipDao rDao = new RelashionshipDao();

    public PostService(){
    }

    public boolean save(Post post){
        return dao.save(post);
    }

    public List<Post> list(int idUser){
        List<Post> postEvaluated = new ArrayList<>();
        for (Post post: dao.list(idUser)) {
            post.setEvaluation(aDao.media(post));
            postEvaluated.add(post);
        }
        return postEvaluated;
    }

    public boolean delete(int id){
        return dao.delete(id);
    }

    public boolean update(Post post){
        return dao.save(post);
    }

    public List<Post> searchAll(){
        return dao.searchAll();
    }

    public List<Post> searchPost(User user, String title) {
        return dao.searchByTitle(title, rDao.searchFollow(user.getEmail()));
    }

    public List<Post> searchByIdFromProfessor(int userid){
        List<Post> postEvaluated = new ArrayList<>();
        for (Post post: dao.searchByIdFromProfessor(userid)) {
            post.setEvaluation(aDao.media(post));
            postEvaluated.add(post);
        }
        return postEvaluated;
    }

    public Post search(int id){
        return dao.searchById(id);
    }


}
