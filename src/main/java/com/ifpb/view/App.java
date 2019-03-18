package com.ifpb.view;

import com.ifpb.model.dao.RelashionshipDao;
import com.ifpb.model.dao.UsuarioDao;
import com.ifpb.model.entidades.User;

import java.sql.SQLException;

public class App {
    public static void main(String[] args) throws SQLException {
       // UsuarioDao dao = new UsuarioDao();

//        System.out.println(dao.save(new User(0,"lucas1", "321","Lucas","M","","Fon","1","PB","5890000","889999000","102")));

        RelashionshipDao dao = new RelashionshipDao();
        User user = new User(1,"aluno","romulo@hotmail.com","201622010060",
                "123","Romulo","M","","fon","cz",
                "pb","58900000","190","940");
        User user1 = new User(2,"aluno","raul@hotmail.com","201622010066",
                "123","Raul","M","","fon","cz",
                "pb","58900000","190","940");
       //dao.saveUser(user1);
//        dao.saveUser(user1);
        //dao.createRelashionship(user,user1);
        

    }

}
