package com.ifpb.controller.command;

import com.ifpb.controller.command.Command;
import com.ifpb.controller.servico.UserService;
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

public class SearchProfessor implements Command {
    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException, ClassNotFoundException {
        HttpSession session = request.getSession();

        UserService service = new UserService();

        List<User> professores = (List<User>) service.searchByLogin(request.getParameter("search"));

        session.setAttribute("professores", professores);

        RequestDispatcher dispatcher = request.getRequestDispatcher("searchProfessor.jsp");
        dispatcher.forward(request, response);


    }
}
