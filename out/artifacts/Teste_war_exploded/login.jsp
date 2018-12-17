<%--
  Created by IntelliJ IDEA.
  User: Raul Coelho
  Date: 20/11/2018
  Time: 09:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login</title>
    <link rel="stylesheet" href="css/login.css"/>
</head>
<body>
    <div id="divPrincipal">
        <center>
            <div class="divForm">
                <h1 id="titulo">LOGIN</h1>
                <table class="tablelogin">
                    <tr>
                        <td><input type="text" name="email" placeholder="Email"></td><br>
                    </tr>
                    <tr>
                        <td><input type="password" name="senha" placeholder="Password"></td><br>
                    </tr>
                    <tr>
                        <td><input type="submit" name="logar" value="LOGAR"></td>
                    </tr>
                    <tr>
                        <td><button><a href="cadastro.jsp" name="cadastrar">CADASTRAR</a></button></td>
                    </tr>
                </table>
            </div>
        </center>
    </div>
</body>
</html>
