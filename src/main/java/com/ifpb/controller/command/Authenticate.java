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

        UserService service = new UserService();

//        String matriculation = request.getParameter("matriculation");

        User user = (User) session.getAttribute("user");


        if(user != null){
            if(user.getPrivilege() == "professor"){
                response.sendRedirect("professorPage.jsp?sucess=1");
            }else{
                response.sendRedirect("studentPage.jsp?sucess=1");
            }
        }else if (service.authenticate(request.getParameter("email"), request.getParameter("password"))){
            User login = service.searchByLogin(request.getParameter("email"));

            session.setAttribute("user", login);

            if(login.getPrivilege().equals("aluno")){
                RequestDispatcher dispatcher = request.getRequestDispatcher("studentPage.jsp?value=1");
                dispatcher.forward(request, response);
            }else{
                RequestDispatcher dispatcher = request.getRequestDispatcher("professorPage.jsp?value=1");
                dispatcher.forward(request, response);
            }



        }else{
            response.sendRedirect("login.jsp?value=1");
        }
    }
}
