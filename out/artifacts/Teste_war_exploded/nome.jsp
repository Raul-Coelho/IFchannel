<%--
  Created by IntelliJ IDEA.
  User: Lucas
  Date: 07/11/2018
  Time: 16:36
  To change this template use File | Settings | File Templates.
--%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Titulo</title>
</head>
<title>Exemplo usando JSTL</title>
</head>
<body>
<c:forEach begin="1" end="5">
    <h2>Olha isso!</h2>
</c:forEach>

<h1>Olá ${nome}</h1>


</body>
</html>
