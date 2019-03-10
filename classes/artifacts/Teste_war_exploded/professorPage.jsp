<%--
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
    <link rel="stylesheet" href="/css/userPage.css">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    <link rel="stylesheet" href="css/homepage.css">
</head>
<body>
<!--NAVBAR-->
<nav class="navbar navbar-light bg-light justify-content-between">
    <a class="navbar-brand">IFPB Channel</a>
    <form class="form-inline">
        <input class="form-control mr-sm-2 w-full" type="search" placeholder="Search" aria-label="Search">
        <button class="btn btn-outline-success my-2 my-sm-0" type="submit">Search</button>
    </form>
    <form action="index.html">
        <button class="btn btn-outline-success mr-sm-3 my-2 my-sm-0" type="submit">Log out</button>
    </form>
</nav>
<!--PROFILE STUDENT-->
<div class="container">
    <div class="row profile">
        <div class="card my-3 mr-2 my-2" style="width: 16rem; left: -40px;">
            <img class="card-img-top" src="images/user.jpg" alt="Card image cap">
            <div class="card-body">
                <h5 class="card-title">User Name</h5>
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
        <div class="card my-3 mr-2 my-2" style="width: 40rem; height: auto; left: 50px">
            <ul class="list-group list-group-flush">
                <h2 class="btn btn-outline-success">Materials</h2>
                <li class="list-group-item"><input type="file"></li>
                <li class="list-group-item">Information</li>
                <li class="list-group-item">Information</li>
            </ul>
        </div>

</body>
</html>
