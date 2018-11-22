package com.ifpb.controller.command;

import com.ifpb.controller.servico.UsuarioService;

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
        String nome = request.getParameter("nome");
        String email = request.getParameter("email");
        String senha = request.getParameter("senha");
        String sexo = request.getParameter("sexo");
        String rua = request.getParameter("rua");
        String numero = request.getParameter("numero");
        String cidade = request.getParameter("cidade");
        String estado = request.getParameter("estado");
        String cep = request.getParameter("cep");
        String telefone = request.getParameter("telefone");
        Part part = request.getPart("foto");


        byte[] foto = new byte[(int) part.getSize()];
        InputStream stream = part.getInputStream();
        stream.read(foto);
        stream.close();

        //     String fotoPerfil = "data:image/jpeg;base64," + Base64.getEncoder().encodeToString(foto);

        UsuarioService service = new UsuarioService();

        if(service.salvar(id, email, senha, nome, sexo, foto, rua, cidade, estado, cep, telefone, numero)){
            response.setStatus(200);
        }else{
            response.setStatus(400);
            response.setHeader("ERROR", "Não foi possivel cadastrar o usuário");
        }

        request.getRequestDispatcher("index.html").forward(request, response);
//        RequestDispatcher requestDispatcher = request.getRequestDispatcher("nome.jsp");
//        requestDispatcher.forward(request, response);

    }
}

