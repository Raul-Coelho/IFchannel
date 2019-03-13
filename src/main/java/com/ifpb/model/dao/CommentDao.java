package com.ifpb.model.dao;

import com.ifpb.connection.CassandraConFactory;

public class CommentDao {
    private CassandraConFactory factory;

    public CommentDao(){
        factory = new CassandraConFactory();
    }

}
