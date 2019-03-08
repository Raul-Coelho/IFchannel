package com.ifpb.controller.command;

import com.ifpb.controller.servico.UserService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;

public class Authenticate  implements Command{
    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException, ClassNotFoundException {
        HttpSession session = request.getSession();

        String matriculation = request.getParameter("matriculation");

        UserService service = new UserService();

        if(service.authenticate(matriculation)){
            

        }
    }
}
