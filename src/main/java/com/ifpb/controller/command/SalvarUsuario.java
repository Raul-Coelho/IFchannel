package com.ifpb.controller.command;

import com.ifpb.controller.servico.UserService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;
import java.io.IOException;
import java.io.InputStream;
import java.sql.SQLException;

public class SalvarUsuario implements Command {
    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException, ClassNotFoundException {
        HttpSession session = request.getSession();

        int id = 0;
        String nome = request.getParameter("name");
        String email = request.getParameter("email");
        String senha = request.getParameter("password");
        String sexo = request.getParameter("sex");
        String rua = request.getParameter("street");
        String numero = request.getParameter("number");
        String cidade = request.getParameter("city");
        String estado = request.getParameter("state");
        String cep = request.getParameter("cep");
        String telefone = request.getParameter("phone");
        Part part = request.getPart("photo");
        String matriculation = request.getParameter("matriculation");
        String privilege = "professor";

        if(matriculation.length() == 12){
            privilege = "aluno";
        }

        byte[] foto = new byte[(int) part.getSize()];
        InputStream stream = part.getInputStream();
        stream.read(foto);
        stream.close();

//             String fotoPerfil = "data:image/jpeg;base64," + Base64.getEncoder().encodeToString(foto);


        UserService service = new UserService();

        if(service.save(id, privilege, email, matriculation, senha, nome, sexo, foto, rua, cidade, estado, cep, telefone, numero)){
            response.setStatus(200);
        }else{
            response.setStatus(400);
            response.setHeader("ERROR", "Não foi possivel cadastrar o usuário");
        }

        request.getRequestDispatcher("login.jsp").forward(request, response);
//        RequestDispatcher requestDispatcher = request.getRequestDispatcher("nome.jsp");
//        requestDispatcher.forward(request, response);

    }
}

