package com.ifpb.controller.servlet;


import com.ifpb.controller.servico.UserService;
import com.ifpb.model.entidades.User;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.sql.SQLException;

@WebServlet(urlPatterns = "/image")
public class ImageServlet extends HttpServlet {

    public void doGet(HttpServletRequest req, HttpServletResponse res){
        try {
            UserService service = new UserService();

            int idUser = Integer.parseInt(req.getParameter("idUser"));

            User user = service.searchById(idUser);

            String imgPath = "C:\\Imagem\\";

            File image = new File(imgPath + user.getPhoto());

            if(image.exists()){
                res.setContentType("image/jpg");
                res.getOutputStream().write(Files.readAllBytes(image.toPath()));
            }

        } catch (SQLException e) {
            e.printStackTrace();
//        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
