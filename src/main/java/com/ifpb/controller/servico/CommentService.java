package com.ifpb.controller.servico;

import com.datastax.driver.core.Row;
import com.ifpb.model.dao.CommentDao;
import com.ifpb.model.entidades.Comment;

import java.util.List;

public class CommentService {

    CommentDao dao = new CommentDao();

    public CommentService(){

    }

    public boolean save(Comment comment){
        return dao.saveComment(comment);
    }

    public boolean delete(int comment){
        return dao.deleteComment(comment);
    }

    public List<Row> list(){
        return dao.listComments();
    }

    public List<Row> seach(int id){
        return dao.searchComment(id);
    }

}
