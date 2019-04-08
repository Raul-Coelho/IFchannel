package com.ifpb.model.entidades;

public class Evaluation {
    private int id;
    private int userId;
    private int postId;
    private float evaluation;

    public Evaluation(int id, int userId, int postId, float evaluation) {
        this.id = id;
        this.userId = userId;
        this.postId = postId;
        this.evaluation = evaluation;
    }

    public Evaluation(int userId, int postId, float evaluation) {
        this.userId = userId;
        this.postId = postId;
        this.evaluation = evaluation;
    }

    public Evaluation() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getPostId() {
        return postId;
    }

    public void setPostId(int postId) {
        this.postId = postId;
    }

    public float getEvaluation() {
        return evaluation;
    }

    public void setEvaluation(float evaluation) {
        this.evaluation = evaluation;
    }
}
