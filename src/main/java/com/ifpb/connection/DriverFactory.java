package com.ifpb.connection;

import org.neo4j.driver.v1.AuthTokens;
import org.neo4j.driver.v1.Driver;
import org.neo4j.driver.v1.GraphDatabase;

public class DriverFactory {
    private Driver driver;

    public DriverFactory (){
        Neo4j neo4j = new Neo4j();

        driver = GraphDatabase.driver(neo4j.getUrl(), AuthTokens.basic(neo4j.getUsuario(),neo4j.getSenha()));
    }
    public Driver getDriver(){
        return driver;
    }
}