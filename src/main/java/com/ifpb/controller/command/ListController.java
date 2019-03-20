package com.ifpb.controller.command;

import com.ifpb.controller.servico.PostService;
import com.ifpb.model.dao.PostDao;
import com.ifpb.model.entidades.Post;
import com.ifpb.model.entidades.User;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ListController implements Command {
    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException, ClassNotFoundException {
        PostService service = new PostService();
        List<Post> post = new ArrayList<>();

        HttpSession session = request.getSession();

        User user = (User) session.getAttribute("user");
        post = service.list(user.getId());

        try{
            request.setAttribute("post", post);
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("paginadesaidaLIST.jsp");
            requestDispatcher.forward(request,response);
        }catch (Exception e){
            System.out.println(e);
            e.printStackTrace();
        }
    }
}
