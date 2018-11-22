package com.ifpb.view;

import com.ifpb.model.dao.UsuarioDao;
import com.ifpb.model.entidades.Usuario;

import java.sql.SQLException;

public class App {
    public static void main(String[] args) throws SQLException {
        UsuarioDao dao = new UsuarioDao();

//        System.out.println(dao.salvar(new Usuario(0,"lucas1", "321","Lucas","M","",
//                "Fon","1","PB","5890000","889999000","102")));
    }
}
