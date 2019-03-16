package com.ifpb.model.entidades;

public class UserNeo4j {
    private int id;
    private String name;

    public UserNeo4j() {
    }

    public UserNeo4j(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "UserNeo4j{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}