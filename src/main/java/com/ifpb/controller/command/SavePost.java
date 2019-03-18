package com.ifpb.controller.command;

import com.ifpb.controller.servico.PostService;
import com.ifpb.model.entidades.Post;
import com.ifpb.model.entidades.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;
import java.io.IOException;
import java.io.InputStream;
import java.sql.SQLException;
import java.util.Base64;

public class SavePost implements Command {
    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException, ClassNotFoundException {
        HttpSession session = request.getSession();

        User user = (User) session.getAttribute("user");

        Post post = new Post();

        PostService service = new PostService();

        post.setId(0);
        post.setIdUser(user.getId());
        post.setTitle(request.getParameter("title"));
        post.setDescription(request.getParameter("description"));
        post.setExclusivity(request.getParameter("exclusivity"));
        post.setEvaluation(0f);
        
        Part part = request.getPart("video");


        byte[] bVideo = new byte[(int) part.getSize()];
        InputStream stream = part.getInputStream();
        stream.read(bVideo);
        stream.close();

        String video = "data:image/jpeg;base64" + Base64.getEncoder().encodeToString(bVideo);

        post.setVideo(video);

        request.setAttribute("post",post);
        session.setAttribute("post",post);

        if(service.save(post)){
            response.setStatus(200);
        }else{
            response.setStatus(400);
            response.setHeader("ERROR", "CAN'T SAVE YOUR POST");
        }

        request.getRequestDispatcher("professorPage.jsp");
    }
}
