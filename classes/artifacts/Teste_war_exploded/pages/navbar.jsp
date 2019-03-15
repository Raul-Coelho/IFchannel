<%--
  Created by IntelliJ IDEA.
  User: raul
  Date: 15/03/19
  Time: 09:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Navbar</title>
</head>
<body>
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
</body>
</html>
