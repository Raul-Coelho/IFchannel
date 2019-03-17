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
    <link rel="icon" type="image/png" href="images/icons/favicon.ico"/>
    <link rel="stylesheet" href="/css/userPage.css">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    <link rel="stylesheet" href="css/homepage.css">
    <link rel="stylesheet" href="css/font.css">

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
<jsp:include page="pages/navbar.jsp"/>
<!--PROFILE STUDENT-->
<div class="container">
    <div class="row profile">
        <div class="card my-3 mr-2 my-2" style="width: 16rem;height: 40rem;left: -40px;">
            <img class="card-img-top" src="${sessionScope.user.photo}" alt="Card image cap">
            <div class="card-body">
                <h5 class="card-title">${sessionScope.user.name}</h5>
                <p>Student of Analysis and Development Systems of IFPB-Cajazeiras .</p>
            </div>
            <ul class="list-group list-group-flush">
                <li class="list-group-item">${sessionScope.user.matriculation}</li>
                <li class="list-group-item">${sessionScope.user.email}</li>
                <li class="list-group-item">${sessionScope.user.phone}</li>
            </ul>
            <div class="card-body">
                <a href="https://mail.google.com/mail/u/0/#inbox" class="card-link">Email</a>
                <a href="https://suap.ifpb.edu.br" class="card-link">Suap</a>
            </div>

        </div>
        <!--VIDEO-->
        <table style="margin-left: 10%; margin-top: 15px">
            <tr class="card div-video">
                <td>
                    <div style="height: 100%">
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
                                    <p>Avalie</p>
                                    <input type="range" min="0" max="5">
                                </td>
                            </tr>
                            <tr>
                                <td>
                                    <form action="" method="post">
                                        <font face="Poppins-Regular" size="4" color="#0057AE"><b>Comente:</b></font>
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
<%--NAVBAR-BOTTOM--%>
<jsp:include page="pages/navBottom.jsp"/>
</body>
</html>