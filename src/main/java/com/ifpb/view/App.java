package com.ifpb.view;

import com.ifpb.controller.servico.CommentService;
import com.ifpb.controller.servico.PostService;
import com.ifpb.model.dao.RelashionshipDao;
import com.ifpb.model.entidades.Comment;
import com.ifpb.model.entidades.User;

import java.sql.SQLException;
import java.util.UUID;

public class App {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
       // UserDao dao = new UserDao();

//        System.out.println(dao.save(new User(0,"lucas1", "321","Lucas","M","","Fon","1","PB","5890000","889999000","102")));

//        RelashionshipDao dao = new RelashionshipDao();
//        User user = new User(1,"aluno","romulo@hotmail.com","201622010060",
//                "123","Romulo","M","","fon","cz",
//                "pb","58900000","190","940");
//        User user1 = new User(2,"aluno","raul@hotmail.com","201622010066",
//                "123","Raul","M","","fon","cz",
//                "pb","58900000","190","940");
//        System.out.println(dao.saveUser(user));
//        System.out.println(dao.saveUser(user1));
//        dao.createRelashionship(user,user1);

//        PostService service = new PostService();
//
//        System.out.println(service.list(2));


        CommentService service = new CommentService();
//        UUID uuid = UUID.randomUUID();
//        service.save(new Comment(uuid,02,"Esse e um teste no app","Teste"));
//        System.out.println(service.list());


    }

}
