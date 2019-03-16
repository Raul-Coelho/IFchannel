package com.ifpb.connection;

public class Cassandra {
    private String serverIP = "127.0.0.1";
    private String keyspace = "teste";
    private int port = 9042;

    public Cassandra() {
    }

    public Cassandra(String serverIP, String keyspace, int port) {
        this.serverIP = serverIP;
        this.keyspace = keyspace;
        this.port = port;
    }

    public String getServerIP() {
        return serverIP;
    }

    public void setServerIP(String serverIP) {
        this.serverIP = serverIP;
    }

    public String getKeyspace() {
        return keyspace;
    }

    public void setKeyspace(String keyspace) {
        this.keyspace = keyspace;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }
}
