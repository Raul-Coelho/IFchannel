package com.ifpb.model.dao;

import com.ifpb.connection.DriverFactory;
import com.ifpb.model.entidades.User;
import org.neo4j.driver.v1.Driver;
import org.neo4j.driver.v1.Session;
import org.neo4j.driver.v1.StatementResult;
import org.neo4j.driver.v1.Transaction;
import org.neo4j.driver.v1.exceptions.ClientException;

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
                            "name",user.getName()));
            transaction.success();
        }catch (ClientException ex){
            return false;
        }

        return true;
    }

    public boolean createRelashionship(User user, User user1){
        try (Transaction transaction = session.beginTransaction()){
            StatementResult result = transaction.run("MATCH (x:User), (y:User)WHERE x.id=$id1 AND y.id=$id2\n" +
                            "CREATE (x)-[:Follow]->(y) \n" +
                            "RETURN x,y",
                    parameters("id1",user.getId(),
                            "id2",user1.getId()));
            transaction.success();
        }catch (ClientException ex){
            return false;
        }
        return true;
    }

    public boolean unfollow (User user, User user1){
        try (Transaction transaction = session.beginTransaction()){
            StatementResult result = transaction.run("MATCH(:User{id:$id1})-[r:Follow]->(:User{id:$id2})\n" +
                            "DELETE r",
                    parameters("id1",user.getId(),
                            "id2",user1.getId()));
            transaction.success();
        }catch (ClientException ex){
            return false;
        }

        return true;
    }

    public void close() throws Exception {
        session.close();
        driver.close();
    }
}