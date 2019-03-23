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
    <link rel="icon" type="image/png" href="images/icons/favicon.ico"/>
    <link rel="stylesheet" href="/css/userPage.css">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    <link rel="stylesheet" href="css/homepage.css">
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
<%--NAVBAR--%>
<jsp:include page="pages/navbar.jsp"/>


<!--PROFILE PROFESSOR-->
<div class="container">
    <div class="row profile">
        <div class="card my-3 mr-2 my-2" style="width: 16rem; left: -40px;">
            <img class="card-img-top" src="${sessionScope.user.photo}" alt="Card image cap">
            <div class="card-body">
                <h5 class="card-title">${sessionScope.user.name}</h5>
                <p class="card-text">Some quick example text to build on the card title and make up the bulk of the card's content.</p>
            </div>
            <ul class="list-group list-group-flush">
                <li class="list-group-item">${sessionScope.user.matriculation}</li>
                <li class="list-group-item"><a href="https://mail.google.com/mail/u/0/#inbox?compose=new">${sessionScope.user.email}</a></li>
            </ul>
            <div class="card-body">
                <a href="https://mail.google.com/mail/u/0/#inbox" class="card-link">Email</a>
                <a href="#" class="card-link" data-toggle="modal" data-target="#modalProfile" >Edit Profile</a>
                <jsp:include page="pages/modalProfile.jsp"/>
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
                       <form method="post" enctype="multipart/form-data" action="/controller?action=SavePost">
                           <button class="btn btn-primary btn-outline-success btn-size" type="button" data-toggle="modal" data-target="#modalRegister">REGISTER</button>
                           <!-- MODAL REGISTER -->
                            <jsp:include page="pages/modalregister.jsp"/>

                       </form>
                   </td>
                   <td>
                       <form method="post" action="#">
                           <button class="btn btn-primary btn-outline-success btn-size" type="button" data-toggle="modal" data-target="#modalRemove">REMOVE</button>
                           <jsp:include page="pages/modalRemove.jsp"/>
                       </form>
                   </td>
               </tr>
               <tr>
                   <td>
                       <form method="post" action="#">
                           <button class="btn btn-primary btn-outline-success btn-size" type="button" data-toggle="modal" data-target="#modalList">LIST</button>
                           <jsp:include page="pages/modalList.jsp"/>
                       </form>
                   </td>
                   <td>
                       <input name="action" class="btn btn-primary btn-outline-success btn-size" type="submit" data-toggle="modal" data-target="#modalUpdate" value="UPDATE">
                       <jsp:include page="pages/modalUpdate.jsp"/>
                   </td>
               </tr>
           </table>
        </div>
    </div>
</div>
<%--NAV-BOTTOM--%>
<jsp:include page="pages/navBottom.jsp"/>

</body>
</html>
