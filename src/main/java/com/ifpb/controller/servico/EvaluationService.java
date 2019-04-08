package com.ifpb.controller.servico;

import com.ifpb.model.dao.EvaluationDao;
import com.ifpb.model.entidades.Evaluation;
import com.ifpb.model.entidades.Post;

public class EvaluationService {
    private EvaluationDao dao = new EvaluationDao();

    public EvaluationService(){

    }

    public boolean save(Evaluation evaluation){
        System.out.println(dao.wasEvaluated(evaluation.getUserId(), evaluation.getPostId()));
        if(dao.wasEvaluated(evaluation.getUserId(), evaluation.getPostId())){
            System.out.println(dao.wasEvaluated(evaluation.getUserId(), evaluation.getPostId()));
            return dao.update(evaluation);
        }else {
            return dao.save(evaluation);
        }
    }

    public float media(Post post){
        return dao.totalEvaluation(post.getId());
    }
}
