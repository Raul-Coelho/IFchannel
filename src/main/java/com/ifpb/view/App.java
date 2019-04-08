package com.ifpb.view;

import com.ifpb.controller.servico.AvaliationService;
import com.ifpb.controller.servico.PostService;
import com.ifpb.controller.servico.RelashionshipService;
import com.ifpb.controller.servico.UserService;
import com.ifpb.model.dao.PostDao;
import com.ifpb.model.entidades.Avaliation;
import com.ifpb.model.entidades.Post;
import com.ifpb.model.entidades.User;

import java.sql.SQLException;
import java.util.List;

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


//        CommentService service = new CommentService();
//        UUID uuid = UUID.randomUUID();
//        service.save(new Comment(uuid,02,"Esse e um teste no app","Teste"));
//        System.out.println(service.list());

        PostService service = new PostService();

        AvaliationService aService = new AvaliationService();

        UserService uService = new UserService();

        User aluno = uService.searchByLogin("humano@gmail.com");

        Post post = service.searach(1);

        Avaliation avaliation = new Avaliation(aluno.getId(), post.getId(), 5f);



        if (aService.save(avaliation)){
            System.out.println("true");
        }else {
            System.out.println("false");
        }

        System.out.println(aService.media(post));

    }

}
