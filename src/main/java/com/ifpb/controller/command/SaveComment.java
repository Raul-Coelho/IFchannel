package com.ifpb.controller.command;

import com.ifpb.controller.servico.CommentService;
import com.ifpb.model.dao.CommentDao;
import com.ifpb.model.entidades.Comment;
import com.ifpb.model.entidades.Post;
import com.ifpb.model.entidades.User;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;

public class SaveComment implements Command {
    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException, ClassNotFoundException {
        HttpSession session = request.getSession();

        User user = (User) session.getAttribute("user");

        Post post = (Post) session.getAttribute("post");

        Comment comment = new Comment();

        CommentService service = new CommentService();

        comment.setId(post.getIdUser());
        comment.setcoment(request.getParameter("comment"));
        comment.setUsername(user.getName());

        if (service.save(comment)){
            response.setStatus(200);
        }else {
            response.setStatus(400);
        }

        RequestDispatcher dispatcher = request.getRequestDispatcher("studentPage.jsp");

        dispatcher.forward(request,response);

    }
}
