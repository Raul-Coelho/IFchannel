package com.ifpb.controller.servico;

import com.ifpb.model.dao.AvaliationDao;
import com.ifpb.model.entidades.Avaliation;
import com.ifpb.model.entidades.Post;

public class AvaliationService {
    private AvaliationDao dao = new AvaliationDao();

    public AvaliationService(){

    }

    public boolean save(Avaliation avaliation){
        System.out.println(dao.wasEvaluated(avaliation.getUserId(), avaliation.getPostId()));
        if(dao.wasEvaluated(avaliation.getUserId(), avaliation.getPostId())){
            System.out.println(dao.wasEvaluated(avaliation.getUserId(), avaliation.getPostId()));
            return dao.update(avaliation);
        }else {
            return dao.save(avaliation);
        }
    }

    public float media(Post post){
        return dao.totalEvaluation(post.getId());
    }
}
