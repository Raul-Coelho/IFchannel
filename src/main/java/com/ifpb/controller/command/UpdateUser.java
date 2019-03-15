package com.ifpb.controller.command;

import com.ifpb.controller.servico.UserService;
import com.ifpb.model.entidades.User;

import javax.servlet.ServletException;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.InputStream;
import java.sql.SQLException;

public class UpdateUser extends HttpServlet implements Command {
    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException, ClassNotFoundException {
        HttpSession session = request.getSession();

        UserService service = new UserService();

        User user = (User) session.getAttribute("usuer");

        user.setPassword(request.getParameter("password"));
        user.setCep(request.getParameter("cep"));
        user.setCity(request.getParameter("city"));
        user.setName(request.getParameter("name"));
        user.setPhone(request.getParameter("phone"));

        Part part = request.getPart("photo");
        byte[] foto = new byte[(int) part.getSize()];
        InputStream stream = part.getInputStream();
        stream.read(foto);
        stream.close();
        user.setPhoto(foto);

        user.setSex(request.getParameter("gender"));
        user.setState("state");
        user.setStreet(request.getParameter("street"));

        if(service.update(user)){
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
