<%@ page import="com.ifpb.model.entidades.User" %>
<%@ page import="com.ifpb.controller.servico.UserService" %>
<%@ page import="com.ifpb.model.dao.PostDao" %>
<%@ page import="com.ifpb.model.entidades.Post" %>
<%@ page import="com.ifpb.model.dao.CommentDao" %>
<%@ page import="com.ifpb.model.entidades.Comment" %><%--
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
    <link rel="icon" type="image/png" href="../images/icons/favicon.ico"/>
    <link rel="stylesheet" href="/css/userPage.css">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    <link rel="stylesheet" href="../css/homepage.css">
    <link rel="stylesheet" href="css/font.css">

    <%--SCRIPT--%>
    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js" integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy" crossorigin="anonymous"></script>

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
<jsp:include page="../pages/navbar.jsp"/>
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
                        <video controls  src="../video/developer.mp4"></video>
                        <table class="ml-3">
                            <tr>
                                <hr>
                                <td>
                                    <p><h3>TITLE</h3></p>
                                </td>
                            </tr>
                            <tr>
                                <td>
                                    <p><h5><a href="" style="text-decoration: none" data-toggle="modal" data-target="#modalInfoProfessor">Professor Name</a></h5></p>
                                    <jsp:include page="../pages/modalInfoProfessor.jsp"/>
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
                                        <font face="Poppins-Regular" size="3" color="#0057AE"><b>Comment:</b></font>
                                        <br>
                                        <textarea name="comentario" id="comentarios" style="width: 300px"></textarea>
                                        <br>
                                        <input class="form-control mr-sm-2 btn btn-outline-success" name="action" type="submit" value="Send Comment">
                                    </form>
                                </td>
                                <td>
                                    <button class="btn btn-primary btn-outline-success btn-size" style="margin-top: 5.3rem;" type="button" data-toggle="modal" data-target="#modalComment">Show Comments</button>
                                    <jsp:include page="../pages/modalComments.jsp"/>
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
<jsp:include page="../pages/navBottom.jsp"/>
</body>
</html>