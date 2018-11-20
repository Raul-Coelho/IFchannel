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
    <link rel="stylesheet" href="css/cadastro.css"/>
    <title>CADASTRO USUARIO</title>
</head>
<body>
    <div id="divPrincipal">
    <center>
        <h1 id="titulo">Cadastro Usuario</h1>
        <div class="divForm">
            <form method="post" action="/controller?action=SalvarUsuario">
                <table>
                    <tr>
                        <td><label class="labelform">Nome </label></td>
                        <td><input name="nome" type="text" > <br></td>
                    </tr>
                    <tr>
                        <td><label class="labelform">Email </label></td>
                        <td><input name="email" type="text"><br></td>
                    </tr>
                    <tr>
                        <td><label class="labelform">Senha </label></td>
                        <td><input name="senha" type="password"> <br></td>
                    </tr>
                    <tr>
                        <td><label class="labelform">Sexo </label></td>
                        <td>
                            <input type="radio" value="M" name="sexo" class="inputRadio" checked><label>M</label>
                            <input type="radio" value="F" name="sexo" class="inputRadio"><label>F</label>
                        </td>
                    </tr>
                    <tr>
                        <td><label class="labelform">Rua </label></td>
                        <td><input name="rua" type="text"> <br></td>
                    </tr>
                    <tr>
                        <td><label class="labelform">Numero </label></td>
                        <td><input name="numero" type="text"> <br></td>
                    </tr>
                    <tr>
                        <td><label class="labelform">Cidade </label></td>
                        <td><input name="cidade" type="text"> <br></td>
                    </tr>
                    <tr>
                        <td><label class="labelform">Estado </label></td>
                        <td><input name="estado" type="text"> <br></td>
                    </tr>
                    <tr>
                        <td><label class="labelform">Cep </label></td>
                        <td><input name="cep" type="text"> <br></td>
                    </tr>
                    <tr>
                        <td><label class="labelform">Telefone </label></td>
                        <td><input name="telefone" type="text"> <br></td>
                    </tr>
                    <tr>
                        <td><label class="labelform">Foto </label></td>
                        <td><input name="foto" type="file"> <br></td>
                    </tr>
                    <tr>
                        <td><input type="submit" value="CADASTRAR" name="action"></td>
                    </tr>
                </table>
            </form>
        </div>
    </center>
    </div>

</body>
</html>
