package com.ifpb.controller.command;

import com.ifpb.controller.servico.PostService;
import com.ifpb.model.entidades.Post;
import com.ifpb.model.entidades.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;

public class UpdatePost extends HttpServlet implements Command {
    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException, ClassNotFoundException {

        HttpSession session = request.getSession();

        PostService postService = new PostService();

        User user = (User) session.getAttribute("user");
        Post post = (Post) session.getAttribute("post");

        post.setTitle(request.getParameter("title"));
        post.setDescription(request.getParameter("description"));

        if (postService.update(post)){
            response.setStatus(200);
        }else {
            response.setStatus(400);
            response.setHeader("ERROR", "CANT UPDATE");
        }

        if ((user.getPrivilege().equals("professor"))){
            request.getRequestDispatcher("professorPage.jsp").forward(request, response);
        }else{
            request.getRequestDispatcher("studentPage.jsp").forward(request, response);
        }

    }
}
