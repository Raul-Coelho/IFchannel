package com.ifpb.connection;

public class Neo4j {
    private String url = "bolt://localhost:7687";
    private String usuario = "neo4j";
    private String senha = "neo";

    public Neo4j() {
    }

    public Neo4j(String url, String usuario, String senha) {
        this.url = url;
        this.usuario = usuario;
        this.senha = senha;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
}
