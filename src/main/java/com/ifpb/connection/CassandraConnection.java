package com.ifpb.connection;

import com.datastax.driver.core.Cluster;
import com.datastax.driver.core.Session;

public class CassandraConnection {
    static private Cluster cluster = null;
    static private Session session = null;

    public static Session getConnection() {
        Cassandra c = new Cassandra();

        cluster = Cluster.builder()
                .addContactPoint(c.getServerIP())
                .withPort(c.getPort())
                .build();
        session = cluster.connect(c.getKeyspace());

        System.out.println("Connected!");
        return session;
    }

    public static void closeConnection() {
        cluster.close();
    }

}
