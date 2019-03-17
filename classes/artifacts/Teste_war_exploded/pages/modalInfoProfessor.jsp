<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: raul
  Date: 17/03/19
  Time: 17:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Modal Info Professor</title>
</head>
<body>
<div class="modal fade" id="modalInfoProfessor" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h6 class="modal-title" id="exampleModalLabel">Professor Informations</h6>
                <button type="button" class="close" data-dismiss="modal" aria-label="Fechar">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <div class="modal-body">
                    <img class="card-img-top w-50 ml-3" src="${sessionScope.user.photo}" alt="Card image cap">
                    <div class="card-body">
                        <h5 class="card-title">${sessionScope.user.name}</h5>
                        <p>Professor of Analysis and Development Systems of IFPB-Cajazeiras .</p>
                    </div>
                    <ul class="list-group list-group-flush">
                        <li class="list-group-item">${sessionScope.user.email}</li>
                        <li class="list-group-item">${sessionScope.user.phone}</li>
                    </ul>
                    <c:forEach var="aula" items="${aulas}">
                        <tr>
                            <td>${aula.title}</td>
                            <td>${aula.discipline}</td>
                        </tr>
                    </c:forEach>
                    <div class="card-body">
                        <button class="btn btn-primary btn-outline-success btn-size" type="button" >Follow</button>
                    </div>
            </div>
        </div>
    </div>
</div>
</body>
</html>
