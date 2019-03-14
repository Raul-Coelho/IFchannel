<%@ page import="com.ifpb.model.entidades.User" %>
<%@ page import="com.ifpb.controller.servico.UserService" %><%--
  Created by IntelliJ IDEA.
  User: raul
  Date: 10/03/19
  Time: 09:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Professor</title>
    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js" integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy" crossorigin="anonymous"></script>
    <link rel="stylesheet" href="/css/userPage.css">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    <link rel="stylesheet" href="css/homepage.css">
    <link rel="stylesheet" href="css/font.css">
    <link rel="stylesheet" href="css/btn-size.css">
</head>
<body>

<%
    User u = (User) session.getAttribute("user");

    UserService service = new UserService();

    if(u == null){
        response.sendRedirect("login.jsp");
    }else if(u.getPrivilege().equals("aluno")){
        response.sendRedirect("studentPage.jsp");
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
                <li class="list-group-item">${sessionScope.user.matriculation}</li>
                <li class="list-group-item">Information</li>
                <li class="list-group-item">Information</li>
            </ul>
            <div class="card-body">
                <a href="#" class="card-link">Email</a>
                <a href="#" class="card-link">Other Link</a>
            </div>
        </div>
        <div class="card my-3 mr-2 my-2" style="width: 40rem; height: auto; left: 50px">
           <table style="margin-left: 100px; margin-top: 100px">
               <tr>
                   <h2 style="color: #1e7e34; margin-left: 240px" class="my-5">Materials</h2>
                   <hr width="50%" style="margin-left: 150px">
               </tr>
               <tr>
                   <td>
                       <form action="login.jsp">
                           <button class="btn btn-primary btn-outline-success btn-size" type="button" data-toggle="modal" data-target="#modalExemplo">REGISTER</button>
                           <!-- MODAL -->
                           <div class="modal fade" id="modalExemplo" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
                               <div class="modal-dialog" role="document">
                                   <div class="modal-content">
                                       <div class="modal-header">
                                           <h6 class="modal-title" id="exampleModalLabel">Sign up for a new lesson</h6>
                                           <button type="button" class="close" data-dismiss="modal" aria-label="Fechar">
                                               <span aria-hidden="true">&times;</span>
                                           </button>
                                       </div>
                                       <div class="modal-body">
                                           <form>
                                               <div class="form-group">
                                                   <label for="recipient-title" class="col-form-label">Title:</label>
                                                   <input type="text" name="title" class="form-control" id="recipient-title">
                                               </div>
                                               <div class="form-group">
                                                   <label for="recipient-name" class="col-form-label">Your Name:</label>
                                                   <input type="text" name="name" class="form-control" id="recipient-name">
                                               </div>
                                               <div class="form-group">
                                                   <label for="recipient-discipline" class="col-form-label">Discipline:</label>
                                                   <input type="text" name="discipline" class="form-control" id="recipient-discipline">
                                               </div>
                                               <div class="form-group">
                                                   <label for="recipient-description" class="col-form-label">Description:</label>
                                                   <input type="text" name="description" class="form-control" id="recipient-description">
                                               </div>
                                               <div class="form-group">
                                                   <label for="recipient-file" class="col-form-label">Video:</label>
                                                   <input type="file" name="file" class="form-control" id="recipient-file">
                                               </div>
                                           </form>
                                       </div>
                                       <div class="modal-footer">
                                           <button type="button" class="btn btn-secondary" data-dismiss="modal">Exit</button>
                                           <button type="button" class="btn btn-primary">Save</button>
                                       </div>
                                   </div>
                               </div>
                           </div>

                       </form>
                   </td>
                   <td>
                       <form action="login.jsp">
                           <button class="btn btn-outline-success btn-size" type="button">REMOVE</button>
                       </form>
                   </td>
               </tr>
               <tr>
                   <td>
                       <form action="login.jsp">
                           <button class="btn btn-outline-success btn-size" type="button">LIST</button>
                       </form>
                   </td>
                   <td>
                       <form action="login.jsp">
                           <button class="btn btn-outline-success btn-size" type="button">UPDATE</button>
                       </form>
                   </td>
               </tr>
           </table>
        </div>
    </div>
</div>


</body>
</html>
