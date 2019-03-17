<%--
  Created by IntelliJ IDEA.
  User: raul
  Date: 15/03/19
  Time: 21:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Modal Profile</title>
</head>
<body>
<div class="modal fade" id="modalProfile" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h6 class="modal-title" id="exampleModalLabel">Edit your Profile</h6>
                <button type="button" class="close" data-dismiss="modal" aria-label="Fechar">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <div class="modal-body">
                <form action="/controller?action=UpdateUser" method="post">
                    <div class="form-group">
                        <label for="recipient-name" class="col-form-label">Name:</label>
                        <input type="text" name="name" class="form-control" id="recipient-name" value="${sessionScope.user.name}">
                    </div>
                    <div class="form-group">
                        <label for="recipient-password" class="col-form-label">Password:</label>
                        <input type="text" name="password" class="form-control" id="recipient-password" value="${sessionScope.user.password}">
                    </div>
                    <div class="form-group">
                        <label for="recipient-street" class="col-form-label">Street:</label>
                        <input type="text" name="street" class="form-control" id="recipient-street" value="${sessionScope.user.street}">
                    </div>
                    <div class="form-group">
                        <label for="recipient-number" class="col-form-label">Number:</label>
                        <input type="text" name="number" class="form-control" id="recipient-number" value="${sessionScope.user.number}">
                    </div>
                    <div class="form-group">
                        <label for="recipient-city" class="col-form-label">City:</label>
                        <input type="text" name="city" class="form-control" id="recipient-city" value="${sessionScope.user.city}">
                    </div>
                    <div class="form-group">
                        <label for="recipient-state" class="col-form-label">State:</label>
                        <input type="text" name="state" class="form-control" id="recipient-state" value="${sessionScope.user.state}">
                    </div>
                    <div class="form-group">
                        <label for="recipient-cep" class="col-form-label">Cep:</label>
                        <input type="text" name="cep" class="form-control" id="recipient-cep" value="${sessionScope.user.cep}">
                    </div>
                    <div class="form-group">
                        <label for="recipient-phone" class="col-form-label">Phone:</label>
                        <input type="text" name="phone" class="form-control" id="recipient-phone" value="${sessionScope.user.phone}">
                    </div>
                    <div class="form-group">
                        <label for="recipient-photo" class="col-form-label">Photo:</label>
                        <input type="file" name="photo" class="form-control" id="recipient-photo">
                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-secondary" data-dismiss="modal">Exit</button>
                        <input type="submit" class="btn btn-primary" name="action" value="Save">
                    </div>
                </form>
            </div>

        </div>
    </div>
</div>
</body>
</html>
