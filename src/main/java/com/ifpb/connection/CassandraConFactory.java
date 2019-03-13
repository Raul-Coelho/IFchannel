package com.ifpb.connection;

import com.datastax.driver.core.Cluster;
import com.datastax.driver.core.Session;

public class CassandraConFactory {
    Cluster cluster = Cluster.builder().addContactPoint("localhost").withPort(9042).build();
    Session session = cluster.connect("IFchannel");
}
