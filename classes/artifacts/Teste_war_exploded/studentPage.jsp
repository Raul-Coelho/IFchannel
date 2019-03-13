<%@ page import="com.ifpb.model.entidades.User" %>
<%@ page import="com.ifpb.controller.servico.UserService" %><%--
  Created by IntelliJ IDEA.
  User: raul
  Date: 07/03/19
  Time: 12:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Student</title>
    <link rel="stylesheet" href="/css/userPage.css">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    <link rel="stylesheet" href="css/homepage.css">

</head>
<body>
<%
    User u = (User) session.getAttribute("user");

    UserService service = new UserService();

    if(u == null){
        response.sendRedirect("login.jsp");
    }else if(u.getPrivilege().equals("professor")){
        response.sendRedirect("professorPage.jsp");
    }
%>
<!--NAVBAR-->
<nav class="navbar navbar-light bg-light justify-content-between">
    <a class="navbar-brand">IFPB Channel</a>
    <form class="form-inline">
        <input class="form-control mr-sm-2 w-full" type="search" placeholder="Search" aria-label="Search">
        <button class="btn btn-outline-success my-2 my-sm-0" type="submit">Search</button>
    </form>
    <form method="post"  action="/controller?action=Logout">
        <button class="btn btn-outline-success mr-sm-3 my-2 my-sm-0" type="submit">Log out</button>
    </form>
</nav>
<!--PROFILE STUDENT-->
<div class="container">
    <div class="row profile">
        <div class="card my-3 mr-2 my-2" style="width: 16rem; left: -40px;">
            <img class="card-img-top" src="images/user.jpg" alt="Card image cap">
            <div class="card-body">
                <h5 class="card-title">${sessionScope.user.name}</h5>
                <p class="card-text">Some quick example text to build on the card title and make up the bulk of the card's content.</p>
            </div>
            <ul class="list-group list-group-flush">
                <li class="list-group-item">Matriculation</li>
                <li class="list-group-item">Information</li>
                <li class="list-group-item">Information</li>
            </ul>
            <div class="card-body">
                <a href="#" class="card-link">Email</a>
                <a href="#" class="card-link">Other Link</a>
            </div>
        </div>
        <!--VIDEO-->
        <table style="margin-left: 28%;">
            <tr class="card my-5 div-video">
                <td>
                    <div style="height: 850px">
                        <video controls  src="video/developer.mp4"></video>
                        <table>
                            <tr>
                                <hr>
                                <td>
                                    <p><h3>TITLE</h3></p>
                                </td>
                            </tr>
                            <tr>
                                <td>
                                    <p><label>Nome do Professor</label></p>
                                </td>
                            </tr>
                            <tr>
                                <td>
                                    <p><label>Disciplina</label></p>
                                </td>
                            </tr>
                            <tr>
                                <td>
                                    <p>Descrição</p>
                                    <textarea name="descricao" style="width: 300px; height: 100px" readonly></textarea>
                                </td>
                            </tr>
                            <tr>
                                <td>
                                    <form action="" method="post">
                                        <font face="arial" size="4" color="#0057AE"><b>Comente:</b></font>
                                        <br>
                                        <textarea name="comentarios" id="comentarios" style="width: 300px"></textarea>
                                        <br>
                                        <input class="form-control mr-sm-2 btn btn-outline-success" action="oi.html" type="submit" value="Comentar">
                                    </form>
                                </td>
                            </tr>
                        </table>
                    </div>
                </td>
            </tr>

        </table>
    </div>
</div>
<br>
<br>
<br>

</body>
</html>