<%--
  Created by IntelliJ IDEA.
  User: raul
  Date: 16/03/19
  Time: 07:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>HOME</title>
    <link rel="icon" type="image/png" href="images/icons/favicon.ico"/>
    <!--NAVBAR-->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    <link rel="stylesheet" href="css/homepage.css">
</head>
<body >
<nav class="navbar navbar-light bg-light justify-content-between">
    <a class="navbar-brand">IFPB Channel</a>
    <form class="form-inline">
        <input class="form-control mr-sm-2 w-full" type="search" placeholder="Search" aria-label="Search">
        <button class="btn btn-outline-success my-2 my-sm-0" type="submit">Search</button>
    </form>
    <form action="login.jsp">
        <button class="btn btn-outline-success mr-sm-3 my-2 my-sm-0" type="submit">Sign Up</button>
    </form>
</nav>
<table style="margin-left: 28%;">
    <tr class="card my-5 div-video">
        <td>
            <div style="height: 250%">
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
                            <form action="#" method="post">
                                <font face="arial" size="4" color="#0057AE"><b>Show Comments:</b></font>
                                <button class="btn btn-primary btn-outline-success btn-size" type="button" data-toggle="modal" data-target="#modalComment">Show</button>
                                <jsp:include page="pages/modalComments.jsp"/>
                            </form>
                        </td>
                    </tr>
                </table>
            </div>
        </td>
    </tr>

</table>
<%--NAV-BOTTOM--%>
<jsp:include page="pages/navBottom.jsp"/>
</body>
</html>
