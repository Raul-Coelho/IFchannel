package com.ifpb.controller.command;

import com.ifpb.controller.servico.UserService;
import com.ifpb.model.entidades.User;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;

public class Authenticate extends HttpServlet implements Command{
    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException, ClassNotFoundException {
        HttpSession session = request.getSession();

        User user = new User();

        String matriculation = request.getParameter("matriculation");

        UserService service = (UserService) session.getAttribute("user");

        if(user != null){
            response.sendRedirect("index.jsp?sucess=1");
        }else if (service.authenticate(request.getParameter("email"), request.getParameter("password"))){
            User actualUser = service.searchByLogin(user.getEmail());
            session.setAttribute("user", actualUser);

            RequestDispatcher dispatcher =request.getRequestDispatcher("index.jsp?value=1");
            dispatcher.forward(request, response);
        }else{
            response.sendRedirect("login.jsp?value=1");
        }
    }
}
