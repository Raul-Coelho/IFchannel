package com.ifpb.model.dao;

import com.ifpb.connection.DriverFactory;
import com.ifpb.model.entidades.User;
import org.neo4j.driver.v1.*;
import org.neo4j.driver.v1.exceptions.ClientException;

import java.util.ArrayList;
import java.util.List;

import static org.neo4j.driver.v1.Values.parameters;

public class RelashionshipDao {
    private Driver driver;
    private Session session;

    public RelashionshipDao(){
        driver = new DriverFactory().getDriver();
        session = driver.session();
    }

    public boolean saveUser(User user){
        try (Transaction transaction = session.beginTransaction()){
            StatementResult result = transaction.run( "CREATE (:User{id:$id, name:$name})",
                    parameters("id",user.getId(),
                            "name",user.getEmail()));
            transaction.success();
        }catch (ClientException ex){
            return false;
        }

        return true;
    }

    public boolean createRelashionship(String email, String email1){
        try (Transaction transaction = session.beginTransaction()){
            StatementResult result = transaction.run("MATCH (x:User), (y:User)WHERE x.name=$name1 AND y.name=$name2 CREATE (x)-[:Follow]->(y) RETURN x,y", parameters("name1",email, "name2",email1));
            transaction.success();
        }catch (ClientException ex){
            return false;
        }
        return true;
    }

    public boolean unfollow (String email, String email1){
        try (Transaction transaction = session.beginTransaction()){
            StatementResult result = transaction.run("MATCH(:User{name:$name1})-[r:Follow]->(:User{name:$name2})\n" +
                            "DELETE r",
                    parameters("name1",email,
                            "name2",email1));
            transaction.success();
        }catch (ClientException ex){
            return false;
        }

        return true;
    }

    public List<User> searchFollow(String email) {
        List list = new ArrayList();
        try (Transaction transaction = session.beginTransaction()) {
            StatementResult result = transaction.run("MATCH(a:User)-[:Follow]->(b:User{name:$name})RETURN a.name",
                    parameters("name", email));
            transaction.success();

            while (result.hasNext()){
                Record record = result.next();
                list.add(record.get("a.name").asString());
            }
            transaction.success();
            return list;
        }catch (ClientException ex){
            return null;
        }
    }
    public void close() throws Exception {
        session.close();
        driver.close();
    }
}