package com.ifpb.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class PostgreConFactory {


    public Connection getConnection() throws ClassNotFoundException, SQLException {

        Class.forName("org.postgresql.Driver");

        String url = "jdbc:postgresql://localhost:5432/ifchannel";
        String usuario = "postgres";
        String senha = "postgres";


        System.out.println(url);
        return DriverManager.getConnection(url, usuario, senha);

    }
}
