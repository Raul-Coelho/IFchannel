<%--
  Created by IntelliJ IDEA.
  User: Raul Coelho
  Date: 08/11/2018
  Time: 22:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>

<head>
    <meta charset="utf-8">
    <%--<link rel="stylesheet" href="css/cadastro.css"/>--%>
    <link rel="icon" type="image/png" href="images/icons/favicon.ico"/>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    <link rel="stylesheet" href="css/homepage.css">
<%--script--%>
    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js" integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy" crossorigin="anonymous"></script>

    <title>Register User</title>
</head>
<body>
    <div id="divPrincipal">
    <center>
        <jsp:include page="pages/nav-register.jsp"/>
        <div class="card w-50" style="margin-top: 20px; margin-bottom: 30px">
            <form method="post" class="my-5 ml-5" enctype="multipart/form-data" action="/controller?action=SalvarUsuario">
                <table>
                    <tr>
                        <td><label class="col-form-label">Name:</label></td>
                        <td><input type="text" name="name" class="form-control w-75" placeholder="Name"></td>
                    </tr>
                    <tr>
                        <td><label class="col-form-label">Matriculation:</label></td>
                        <td><input type="text" name="matriculation" class="form-control w-75" placeholder="Matriculation"></td>
                    </tr>
                    <tr>
                        <td><label class="col-form-label">Email:</label></td>
                        <td><input type="text" name="email" class="form-control w-75" placeholder="Email"></td>
                    </tr>
                    <tr>
                        <td><label class="col-form-label">Password:</label></td>
                        <td><input type="password" name="password" class="form-control w-75" placeholder="Password"></td>
                    </tr>
                    <tr>
                        <td><label class="labelform">Sexo </label></td>
                        <td>
                            <input type="radio" value="M" name="sex" class="inputRadio" checked><label>M</label>
                            <input type="radio" value="F" name="sex" class="inputRadio"><label>F</label>
                        </td>
                    </tr>
                    <tr>
                        <td><label class="col-form-label">Street:</label></td>
                        <td><input type="text" name="street" class="form-control w-75" placeholder="Street"></td>
                    </tr>
                    <tr>
                        <td><label class="col-form-label">Number:</label></td>
                        <td><input type="text" name="number" class="form-control w-75" placeholder="Number"></td>
                    </tr>
                    <tr>
                        <td><label class="col-form-label">City:</label></td>
                        <td><input type="text" name="city" class="form-control w-75" placeholder="City"></td>
                    </tr>
                    <tr>
                        <td><label class="col-form-label">State:</label></td>
                        <td><input type="text" name="state" class="form-control w-75" placeholder="State"></td>
                    </tr>
                    <tr>
                        <td><label class="col-form-label">Cep:</label></td>
                        <td><input type="text" name="cep" class="form-control w-75" placeholder="Cep"></td>
                    </tr>
                    <tr>
                        <td><label class="col-form-label">Phone:</label></td>
                        <td><input type="text" name="phone" class="form-control w-75" placeholder="Phone"></td>
                    </tr>
                    <tr>
                        <td><label class="col-form-label">Photo:</label></td>
                        <td><input type="file" name="photo" class="form-control w-75" placeholder="Photo"></td>
                    </tr>
                </table>
                <input type="submit" class="btn btn-primary btn-outline-success my-5" style="width: 20rem;height: 3rem; margin-right: 100px" name="action" value="Register">
            </form>
        </div>
    </center>
    </div>

<%--Nav-Bottom--%>
<jsp:include page="pages/navBottom.jsp"/>
</body>
</html>
