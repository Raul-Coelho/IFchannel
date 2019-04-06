package com.ifpb.controller.servico;

import com.datastax.driver.core.Row;
import com.ifpb.model.dao.CommentDao;
import com.ifpb.model.entidades.Comment;

import java.util.List;
import java.util.UUID;

public class CommentService {

    CommentDao dao = new CommentDao();

    public CommentService(){

    }

    public boolean save(Comment comment){
        return dao.saveComment(comment);
    }

    public boolean delete(Comment comment){
        return dao.deleteComment(comment);
    }

    public List<Comment> list(){
        return dao.listComments();
    }

    public List<Row> seach(int id){
        return dao.searchComment(id);
    }

    public boolean editComent (int id, String comment){return dao.editComent(id, comment);}

}
